/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.edu.gestec.persistencia;

import uy.edu.gestec.negocio.RecursoTecnologico;
import uy.edu.gestec.negocio.Prestamo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import uy.edu.gestec.negocio.PersonaHabilitada;
import uy.edu.gestec.negocio.Usuario;

/**
 *
 * @author Sebastian Seijas
 * @author Agustin Morales
 */
public class PrestamoDAO {

    // registrar prestamo
    public boolean registrar(Prestamo prestamo) {
        String sql = "INSERT INTO prestamo "
                + "(id_usuario, id_persona_hab, fecha_prev_dev) "
                + "VALUES (?, ?, ?)";
        try (Connection conexion = ConexionBD.conectar(); PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, prestamo.getUsuario().getIdUsuario());
            ps.setInt(2, prestamo.getPersona().getIdPersonaHab());
            ps.setTimestamp(3, Timestamp.valueOf(prestamo.getFechaPrevDev()));

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas == 0) {
                return false;
            }
            int idPrestamo;

            try (ResultSet rs = ps.getGeneratedKeys()) {

                if (rs.next()) {
                    idPrestamo = rs.getInt(1);
                } else {
                    return false;
                }
            }
            String sqlRecurso = "INSERT INTO prestamo_recurso "
                    + "(id_prestamo, id_recurso) "
                    + "VALUES (?, ?)";

            try (PreparedStatement psRecurso = conexion.prepareStatement(sqlRecurso)) {

                for (RecursoTecnologico recurso : prestamo.getRecursos()) {

                    psRecurso.setInt(1, idPrestamo);
                    psRecurso.setInt(2, recurso.getIdRecurso());

                    psRecurso.executeUpdate();
                }
            }
            String sqlDisponibilidad = "UPDATE recurso_tecnologico "
                    + "SET disponibilidad = false "
                    + "WHERE id_recurso = ?";

            try (PreparedStatement psDisponibilidad
                    = conexion.prepareStatement(sqlDisponibilidad)) {

                for (RecursoTecnologico recurso : prestamo.getRecursos()) {

                    psDisponibilidad.setInt(1, recurso.getIdRecurso());
                    psDisponibilidad.executeUpdate();
                }
            }


            return true;

        } catch (SQLException e) {
            System.out.println("Error al registrar préstamo: " + e.getMessage());
        }

        return false;

    }
    
public Prestamo buscarPrestamoPendientePorId(int idPrestamo) {

    String sql = "SELECT pr.id_prestamo, pr.fecha_entrega, "
            + "pr.fecha_prev_dev, pr.estado_prestamo, "
            + "ph.id_persona_hab, ph.tipo_persona, ph.baja_logica, "
            + "p.id_persona, p.documento, p.nombre, "
            + "p.apellido, p.telefono, "
            + "u.id_usuario, u.nombre_usuario, u.password_hash, "
            + "pu.id_persona AS id_persona_usuario, "
            + "pu.documento AS documento_usuario, "
            + "pu.nombre AS nombre_operador, "
            + "pu.apellido AS apellido_operador, "
            + "pu.telefono AS telefono_operador "
            + "FROM prestamo pr "
            + "INNER JOIN persona_habilitada ph "
            + "ON pr.id_persona_hab = ph.id_persona_hab "
            + "INNER JOIN persona p ON ph.id_persona = p.id_persona "
            + "INNER JOIN usuario u ON pr.id_usuario = u.id_usuario "
            + "INNER JOIN persona pu ON u.id_persona = pu.id_persona "
            + "WHERE pr.id_prestamo = ? "
            + "AND pr.estado_prestamo IN ('Activo', 'Vencido') "
            + "AND pr.fecha_devolucion_real IS NULL";

    String sqlRecursos = "SELECT r.id_recurso, r.codigo_inv, "
            + "r.nombre, r.categoria, r.condicion, "
            + "r.disponibilidad, r.baja_logica "
            + "FROM recurso_tecnologico r "
            + "INNER JOIN prestamo_recurso pr "
            + "ON r.id_recurso = pr.id_recurso "
            + "WHERE pr.id_prestamo = ?";

    try (Connection conexion = ConexionBD.conectar();
         PreparedStatement ps = conexion.prepareStatement(sql)) {

        ps.setInt(1, idPrestamo);

        try (ResultSet rs = ps.executeQuery()) {

            if (!rs.next()) {
                return null;
            }

            // Recuperar la persona habilitada
            PersonaHabilitada persona = new PersonaHabilitada(
                    rs.getInt("id_persona_hab"),
                    rs.getString("tipo_persona"),
                    rs.getBoolean("baja_logica"),
                    rs.getInt("id_persona"),
                    rs.getString("documento"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("telefono")
            );

            // Recuperar el usuario que registró el préstamo
            Usuario usuario = new Usuario(
                    rs.getInt("id_persona_usuario"),
                    rs.getString("documento_usuario"),
                    rs.getString("nombre_operador"),
                    rs.getString("apellido_operador"),
                    rs.getString("telefono_operador"),
                    rs.getString("nombre_usuario"),
                    rs.getInt("id_usuario"),
                    rs.getString("password_hash")
            );

            // Crear la lista de recursos
            List<RecursoTecnologico> recursos = new ArrayList<>();

            try (PreparedStatement psRecursos =
                    conexion.prepareStatement(sqlRecursos)) {

                psRecursos.setInt(1, idPrestamo);

                try (ResultSet rsRecursos = psRecursos.executeQuery()) {

                    while (rsRecursos.next()) {

                        RecursoTecnologico recurso =
                                new RecursoTecnologico(
                                        rsRecursos.getInt("id_recurso"),
                                        rsRecursos.getString("codigo_inv"),
                                        rsRecursos.getString("nombre"),
                                        rsRecursos.getString("categoria"),
                                        rsRecursos.getString("condicion"),
                                        rsRecursos.getBoolean("disponibilidad"),
                                        rsRecursos.getBoolean("baja_logica")
                                );

                        recursos.add(recurso);
                    }
                }
            }

            // Construir el préstamo con los datos recuperados
            Prestamo prestamo = new Prestamo(
                    rs.getTimestamp("fecha_prev_dev").toLocalDateTime(),
                    usuario,
                    persona,
                    recursos
            );

            prestamo.setIdPrestamo(rs.getInt("id_prestamo"));
            prestamo.setFechaEntrega(
                    rs.getTimestamp("fecha_entrega").toLocalDateTime()
            );
            prestamo.setEstadoPrestamo(
                    rs.getString("estado_prestamo")
            );

            return prestamo;
        }

    } catch (SQLException e) {
        System.out.println(
                "Error al buscar préstamo: " + e.getMessage()
        );
    }

    return null;
}

public boolean registrarDevolucion(int idPrestamo) {

    String sqlPrestamo = "UPDATE prestamo "
            + "SET fecha_devolucion_real = CURRENT_TIMESTAMP, "
            + "estado_prestamo = 'Devuelto' "
            + "WHERE id_prestamo = ? "
            + "AND estado_prestamo IN ('Activo', 'Vencido') "
            + "AND fecha_devolucion_real IS NULL";

    String sqlRecursos = "UPDATE recurso_tecnologico "
            + "SET disponibilidad = TRUE "
            + "WHERE id_recurso IN ("
            + "SELECT id_recurso FROM prestamo_recurso "
            + "WHERE id_prestamo = ?)";

    try (Connection conexion = ConexionBD.conectar()) {

        conexion.setAutoCommit(false);

        try (PreparedStatement psPrestamo =
                conexion.prepareStatement(sqlPrestamo);
             PreparedStatement psRecursos =
                conexion.prepareStatement(sqlRecursos)) {

            // Actualizar el préstamo
            psPrestamo.setInt(1, idPrestamo);

            int filasAfectadas = psPrestamo.executeUpdate();

            if (filasAfectadas != 1) {
                conexion.rollback();
                return false;
            }

            // Actualizar la disponibilidad de los recursos
            psRecursos.setInt(1, idPrestamo);
            psRecursos.executeUpdate();

            // Confirmar todas las modificaciones
            conexion.commit();

            return true;

        } catch (SQLException e) {

            conexion.rollback();

            System.out.println(
                    "Error al registrar devolución: "
                    + e.getMessage()
            );

            return false;
        }

    } catch (SQLException e) {

        System.out.println(
                "Error de conexión al registrar devolución: "
                + e.getMessage()
        );

        return false;
    }
}


public List<Prestamo> consultarPrestamos(String busqueda, String filtroEstado) {

    List<Prestamo> resultados = new ArrayList<>();

    String sql = "SELECT pr.id_prestamo, pr.fecha_entrega, "
            + "pr.fecha_prev_dev, pr.fecha_devolucion_real, "
            + "pr.estado_prestamo, "
            + "ph.id_persona_hab, ph.tipo_persona, ph.baja_logica, "
            + "p.id_persona, p.documento, p.nombre, "
            + "p.apellido, p.telefono "
            + "FROM prestamo pr "
            + "INNER JOIN persona_habilitada ph "
            + "ON pr.id_persona_hab = ph.id_persona_hab "
            + "INNER JOIN persona p "
            + "ON ph.id_persona = p.id_persona "
            + "WHERE (CAST(pr.id_prestamo AS CHAR) LIKE ? "
            + "OR p.documento LIKE ? "
            + "OR p.nombre LIKE ? "
            + "OR p.apellido LIKE ? "
            + "OR CONCAT(p.nombre, ' ', p.apellido) LIKE ?) ";

    if ("Pendiente".equals(filtroEstado)
            || "Pendientes".equals(filtroEstado)) {
        sql += "AND pr.estado_prestamo IN ('Activo', 'Vencido') "
                + "AND pr.fecha_devolucion_real IS NULL ";
    } else if ("Devueltos".equals(filtroEstado)) {
        sql += "AND pr.estado_prestamo = 'Devuelto' ";
    }

    sql += "ORDER BY pr.id_prestamo DESC";

    try (Connection conexion = ConexionBD.conectar();
         PreparedStatement ps = conexion.prepareStatement(sql)) {

        String patron = "%" + (busqueda == null ? "" : busqueda.trim()) + "%";

        for (int i = 1; i <= 5; i++) {
            ps.setString(i, patron);
        }

        try (ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                PersonaHabilitada persona = new PersonaHabilitada(
                        rs.getInt("id_persona_hab"),
                        rs.getString("tipo_persona"),
                        rs.getBoolean("baja_logica"),
                        rs.getInt("id_persona"),
                        rs.getString("documento"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("telefono")
                );

                Prestamo prestamo = new Prestamo(
                        rs.getTimestamp("fecha_prev_dev").toLocalDateTime(),
                        null,
                        persona,
                        new ArrayList<>()
                );

                prestamo.setIdPrestamo(rs.getInt("id_prestamo"));
                prestamo.setEstadoPrestamo(rs.getString("estado_prestamo"));

                Timestamp fechaEntrega = rs.getTimestamp("fecha_entrega");
                if (fechaEntrega != null) {
                    prestamo.setFechaEntrega(fechaEntrega.toLocalDateTime());
                }

                Timestamp fechaReal = rs.getTimestamp("fecha_devolucion_real");
                if (fechaReal != null) {
                    prestamo.setFechaDevolucionReal(fechaReal.toLocalDateTime());
                }

                resultados.add(prestamo);
            }
        }

    } catch (SQLException e) {
        System.out.println("Error al consultar préstamos: " + e.getMessage());
    }

    return resultados;
}

}

