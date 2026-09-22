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
}
