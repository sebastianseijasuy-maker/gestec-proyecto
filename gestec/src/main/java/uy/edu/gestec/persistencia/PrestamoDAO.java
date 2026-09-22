/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.edu.gestec.persistencia;

import uy.edu.gestec.negocio.Prestamo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Sebastian Seijas
 * @author Agustin Morales
 */
public class PrestamoDAO {

    // registrar prestamo
    public boolean registrar(Prestamo prestamo) {
        String sql = "INSERT INTO prestamo "
                + "(id_usuario, id_persona, id_recurso, fecha_entrega, "
                + "fecha_prev_dev, fecha_devolucion_real, estado_prestamo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conexion = ConexionBD.conectar(); PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, prestamo.getUsuario().getIdUsuario());
            ps.setInt(2, prestamo.getPersona().getIdPersonaHab());
            ps.setInt(3, prestamo.getRecurso().getIdRecurso());

            ps.setTimestamp(4, Timestamp.valueOf(prestamo.getFechaEntrega()));
            ps.setTimestamp(5, Timestamp.valueOf(prestamo.getFechaPrevDev()));

            if (prestamo.getFechaDevolucionReal() != null) {
                ps.setTimestamp(6,
                        Timestamp.valueOf(prestamo.getFechaDevolucionReal()));
            } else {
                ps.setNull(6, java.sql.Types.TIMESTAMP);
            }
            ps.setString(7, prestamo.getEstadoPrestamo());

            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;

            // Aquí colocaremos los datos del préstamo
        } catch (SQLException e) {
            System.out.println("Error al registrar préstamo: " + e.getMessage());
        }

        return false;
    }

}
