/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.edu.gestec.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import uy.edu.gestec.negocio.PersonaHabilitada;
import java.sql.Statement;


/**
 *
 * 
 *
 */
public class PersonaHabilitadaDAO {

    public PersonaHabilitada buscarPorDocumento(String documento) {

        String sql = "SELECT p.id_persona, p.documento, p.nombre, "
                + "p.apellido, p.telefono, ph.id_persona_hab, "
                + "ph.tipo_persona, ph.baja_logica "
                + "FROM persona p "
                + "INNER JOIN persona_habilitada ph "
                + "ON p.id_persona = ph.id_persona "
                + "WHERE p.documento = ?";

        try (Connection conexion = ConexionBD.conectar();
                PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, documento);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

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

                    return persona;
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar persona: " + e.getMessage());
        }

        return null;
    }
    
public boolean registrarPersona(
        String documento,
        String nombre,
        String apellido,
        String telefono,
        String tipoPersona) {

    String sqlBuscar = "SELECT id_persona FROM persona "
            + "WHERE documento = ?";

    String sqlPersona = "INSERT INTO persona "
            + "(documento, nombre, apellido, telefono) "
            + "VALUES (?, ?, ?, ?)";

    String sqlHabilitada = "INSERT INTO persona_habilitada "
            + "(id_persona, tipo_persona, baja_logica) "
            + "VALUES (?, ?, false)";

    try (Connection conexion = ConexionBD.conectar()) {

        conexion.setAutoCommit(false);

        try {
            // Verificar que no exista el documento
            try (PreparedStatement ps =
                    conexion.prepareStatement(sqlBuscar)) {

                ps.setString(1, documento);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        conexion.rollback();
                        return false;
                    }
                }
            }

            int idPersona;

            // Registrar datos personales
            try (PreparedStatement ps =
                    conexion.prepareStatement(
                            sqlPersona,
                            Statement.RETURN_GENERATED_KEYS)) {

                ps.setString(1, documento);
                ps.setString(2, nombre);
                ps.setString(3, apellido);
                ps.setString(4, telefono);

                ps.executeUpdate();

                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (!rs.next()) {
                        throw new SQLException(
                                "No se obtuvo el ID de la persona.");
                    }

                    idPersona = rs.getInt(1);
                }
            }

            // Registrar persona habilitada
            try (PreparedStatement ps =
                    conexion.prepareStatement(sqlHabilitada)) {

                ps.setInt(1, idPersona);
                ps.setString(2, tipoPersona);

                ps.executeUpdate();
            }

            conexion.commit();
            return true;

        } catch (SQLException e) {
            conexion.rollback();

            System.out.println(
                    "Error al registrar persona: " + e.getMessage());

            return false;
        }

    } catch (SQLException e) {
        System.out.println(
                "Error de conexión: " + e.getMessage());

        return false;
    }
}


/**
 * 
 * Método utilizado para modificar persona 
 */
public boolean modificarPersona(
        int idPersona,
        String nombre,
        String apellido,
        String telefono,
        String tipoPersona) {

    String sqlVerificar = "SELECT id_persona_hab "
            + "FROM persona_habilitada "
            + "WHERE id_persona = ? AND baja_logica = false "
            + "FOR UPDATE";

    String sqlPersona = "UPDATE persona "
            + "SET nombre = ?, apellido = ?, telefono = ? "
            + "WHERE id_persona = ?";

    String sqlHabilitada = "UPDATE persona_habilitada "
            + "SET tipo_persona = ? "
            + "WHERE id_persona = ?";

    try (Connection conexion = ConexionBD.conectar()) {

        conexion.setAutoCommit(false);

        try {
            // Verificar que la persona siga habilitada
            try (PreparedStatement ps =
                    conexion.prepareStatement(sqlVerificar)) {

                ps.setInt(1, idPersona);

                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) {
                        conexion.rollback();
                        return false;
                    }
                }
            }

            // Modificar los datos personales
            try (PreparedStatement ps =
                    conexion.prepareStatement(sqlPersona)) {

                ps.setString(1, nombre);
                ps.setString(2, apellido);
                ps.setString(3, telefono);
                ps.setInt(4, idPersona);

                ps.executeUpdate();
            }

            // Modificar el tipo de persona
            try (PreparedStatement ps =
                    conexion.prepareStatement(sqlHabilitada)) {

                ps.setString(1, tipoPersona);
                ps.setInt(2, idPersona);

                ps.executeUpdate();
            }

            // Confirmar los cambios
            conexion.commit();
            return true;

        } catch (SQLException e) {

            conexion.rollback();

            System.out.println(
                    "Error al modificar persona: "
                    + e.getMessage()
            );

            return false;
        }

    } catch (SQLException e) {

        System.out.println(
                "Error de conexión al modificar persona: "
                + e.getMessage()
        );

        return false;
    }
}
/*
* Método que se utiliza utiliza las tablas persona_habilitada y prestamo (el método recibe idPersonaHab).
*/
public boolean darDeBajaPersona(int idPersonaHab) {

    String sql = "UPDATE persona_habilitada ph "
            + "SET ph.baja_logica = true "
            + "WHERE ph.id_persona_hab = ? "
            + "AND ph.baja_logica = false "
            + "AND NOT EXISTS ("
            + "SELECT 1 FROM prestamo pr "
            + "WHERE pr.id_persona_hab = ph.id_persona_hab "
            + "AND pr.estado_prestamo IN ('Activo', 'Vencido') "
            + "AND pr.fecha_devolucion_real IS NULL"
            + ")";

    try (Connection conexion = ConexionBD.conectar();
         PreparedStatement ps = conexion.prepareStatement(sql)) {

        ps.setInt(1, idPersonaHab);

        int filasAfectadas = ps.executeUpdate();

        return filasAfectadas == 1;

    } catch (SQLException e) {

        System.out.println(
                "Error al dar de baja persona: "
                + e.getMessage()
        );

        return false;
    }
}

}