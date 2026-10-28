/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.edu.gestec.persistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import uy.edu.gestec.negocio.Usuario;
/**
 *
 * @author Agustin y Sebastian
 */
public class UsuarioDAO {
    




    public Usuario buscarPorNombreUsuario(String nombreUsuario) {

        String sql = "SELECT u.id_usuario, "
                + "u.nombre_usuario, u.password_hash, "
                + "p.id_persona, p.documento, p.nombre, "
                + "p.apellido, p.telefono "
                + "FROM usuario u "
                + "INNER JOIN persona p "
                + "ON u.id_persona = p.id_persona "
                + "WHERE u.nombre_usuario = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps =
                     conexion.prepareStatement(sql)) {

            ps.setString(1, nombreUsuario);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return new Usuario(
                            rs.getInt("id_persona"),
                            rs.getString("documento"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("telefono"),
                            rs.getString("nombre_usuario"),
                            rs.getInt("id_usuario"),
                            rs.getString("password_hash")
                    );
                }
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error al buscar usuario: "
                    + e.getMessage()
            );
        }

        return null;
    }
    
    public boolean actualizarContrasena(int idUsuario, String nuevoHash) {

    String sql = "UPDATE usuario SET password_hash = ? WHERE id_usuario = ?";

    try (Connection conexion = ConexionBD.conectar();
         PreparedStatement ps = conexion.prepareStatement(sql)) {

        ps.setString(1, nuevoHash);
        ps.setInt(2, idUsuario);

        return ps.executeUpdate() == 1;

    } catch (SQLException e) {
        System.out.println("Error al actualizar contraseña: " + e.getMessage());
        return false;
    }
}

public boolean actualizarNombreUsuario(int idUsuario, String nuevoNombre) {

    String sql = "UPDATE usuario SET nombre_usuario = ? WHERE id_usuario = ?";

    try (Connection conexion = ConexionBD.conectar();
         PreparedStatement ps = conexion.prepareStatement(sql)) {

        ps.setString(1, nuevoNombre);
        ps.setInt(2, idUsuario);

        return ps.executeUpdate() == 1;

    } catch (SQLException e) {
        System.out.println("Error al actualizar usuario: " + e.getMessage());
        return false;
    }
}    

public boolean completarConfiguracionInicial(
        int idUsuario,
        int idPersona,
        String documento,
        String nombre,
        String apellido,
        String nuevoUsuario,
        String nuevoHash) {

    String sqlPersona = "UPDATE persona "
            + "SET documento = ?, nombre = ?, apellido = ? "
            + "WHERE id_persona = ? AND documento = 'GESTEC-ADMIN'";

    String sqlUsuario = "UPDATE usuario "
            + "SET nombre_usuario = ?, password_hash = ? "
            + "WHERE id_usuario = ? AND id_persona = ?";

    try (Connection conexion = ConexionBD.conectar()) {

        conexion.setAutoCommit(false);

        try {
            // Actualizar datos personales
            try (PreparedStatement ps =
                    conexion.prepareStatement(sqlPersona)) {

                ps.setString(1, documento);
                ps.setString(2, nombre);
                ps.setString(3, apellido);
                ps.setInt(4, idPersona);

                if (ps.executeUpdate() != 1) {
                    conexion.rollback();
                    return false;
                }
            }

            // Actualizar credenciales
            try (PreparedStatement ps =
                    conexion.prepareStatement(sqlUsuario)) {

                ps.setString(1, nuevoUsuario);
                ps.setString(2, nuevoHash);
                ps.setInt(3, idUsuario);
                ps.setInt(4, idPersona);

                if (ps.executeUpdate() != 1) {
                    conexion.rollback();
                    return false;
                }
            }

            conexion.commit();
            return true;

        } catch (SQLException e) {
            conexion.rollback();
            System.out.println(
                    "Error en configuración inicial: "
                    + e.getMessage()
            );
            return false;
        }

    } catch (SQLException e) {
        System.out.println(
                "Error de conexión: " + e.getMessage()
        );
        return false;
    }
}

}

    

