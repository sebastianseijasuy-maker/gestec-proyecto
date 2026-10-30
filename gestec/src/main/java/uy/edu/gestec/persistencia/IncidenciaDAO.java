/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.edu.gestec.persistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author jjaam
 */
public class IncidenciaDAO {
    




    public boolean registrarIncidencia(
            int idRecurso,
            String tipoIncidencia,
            String descripcion) {

        String sql = "INSERT INTO incidencia "
                + "(id_recurso, tipo_incidencia, descripcion) "
                + "VALUES (?, ?, ?)";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps =
                     conexion.prepareStatement(sql)) {

            ps.setInt(1, idRecurso);
            ps.setString(2, tipoIncidencia);
            ps.setString(3, descripcion);

            return ps.executeUpdate() == 1;

        } catch (SQLException e) {

            System.out.println(
                    "Error al registrar incidencia: "
                    + e.getMessage()
            );

            return false;
        }
    }
}

    

