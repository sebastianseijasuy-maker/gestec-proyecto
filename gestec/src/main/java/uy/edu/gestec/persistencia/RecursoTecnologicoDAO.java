/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.edu.gestec.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uy.edu.gestec.negocio.RecursoTecnologico;

/**
 *
 * @author Sebastian Seijas
 * @author Sebastian Seijas
 */
public class RecursoTecnologicoDAO {

    public List<RecursoTecnologico> buscarPorNombre(String nombre) {
        List<RecursoTecnologico> recursos = new ArrayList<>();

        String sql = "Select id_recurso, codigo_Inv, nombre, "
                + "categoria, condicion, disponibilidad, baja_logica "
                + "FROM recurso_tecnologico "
                + "WHERE nombre LIKE ?";

        try (Connection conexion = ConexionBD.conectar(); PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, "%" + nombre + "%");

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    RecursoTecnologico recurso = new RecursoTecnologico(
                            rs.getInt("id_recurso"),
                            rs.getString("codigo_inv"),
                            rs.getString("nombre"),
                            rs.getString("categoria"),
                            rs.getString("condicion"),
                            rs.getBoolean("disponibilidad"),
                            rs.getBoolean("baja_logica")
                    );

                    recursos.add(recurso);

                }
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar recurso: " + e.getMessage());
        }

        return recursos;
    }

    public boolean agregarRecurso(RecursoTecnologico recurso) {
        String sql = "INSERT INTO recurso_tecnologico "
                + "(codigo_inv, nombre, categoria, condicion, disponibilidad, baja_logica )"
                + "VALUES(?,?,?,?,?,?)";

        try (Connection conexion = ConexionBD.conectar(); PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, recurso.getCodigoInv());
            ps.setString(2, recurso.getNombre());
            ps.setString(3, recurso.getCategoria());
            ps.setString(4, recurso.getCondicion());
            ps.setBoolean(5, recurso.getDisponibilidad());
            ps.setBoolean(6, recurso.getBajaLogica());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.print("Error al agregar recurso: " + e.getMessage());
        }

        return false;

    }

    public boolean modificarRecurso(RecursoTecnologico recurso) {

        String sql = "UPDATE recurso_tecnologico "
                + "SET codigo_inv = ?, nombre = ?, categoria = ?, "
                + "condicion = ?, disponibilidad = ? "
                + "WHERE id_recurso = ?";

        try (Connection conexion = ConexionBD.conectar(); PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, recurso.getCodigoInv());
            ps.setString(2, recurso.getNombre());
            ps.setString(3, recurso.getCategoria());
            ps.setString(4, recurso.getCondicion());
            ps.setBoolean(5, recurso.getDisponibilidad());
            ps.setInt(6, recurso.getIdRecurso());

            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;

        }
        catch (SQLException e) {
    System.out.println("Error al modificar recurso: " + e.getMessage());
}

return false;

    }
    
    
    public boolean eliminarRecurso(int idRecurso){
        
        String sql ="Update recurso_tecnologico "
                +"SET baja_logica = true "
                +"WHERE id_recurso=?";
        
      try (Connection conexion = ConexionBD.conectar(); 
              PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idRecurso);

            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;

        }
        catch (SQLException e) {
    System.out.println("Error al eliminar recurso: " + e.getMessage());
}

return false;   
    }

}
