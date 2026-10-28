/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.edu.gestec.persistencia;

import uy.edu.gestec.negocio.Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author sseba
 */
public class MantenimientoDAO {
    
    public boolean registrarMantenimiento (int idRecurso, String detalleTecnico){
        
        String sql = "INSERT INTO mantenimiento "
                    + "(id_recurso, detalle_tecnico)"
                    + "VALUES (?,?)";
        
        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            
            ps.setInt(1, idRecurso);
            ps.setString(2, detalleTecnico);

            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            System.out.println("Error al registrar mantenimiento: "
                    + e.getMessage());
            return false;
        }
    }


    public List<Mantenimiento> consultarPorRecurso(int idRecurso) {

        List<Mantenimiento> mantenimientos = new ArrayList<>();

        String sql = "SELECT id_mantenimiento, fecha_inicio, "
                   + "detalle_tecnico, id_recurso "
                   + "FROM mantenimiento "
                   + "WHERE id_recurso = ? "
                   + "ORDER BY fecha_inicio DESC, id_mantenimiento DESC";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idRecurso);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    Timestamp fecha = rs.getTimestamp("fecha_inicio");

                    Mantenimiento mantenimiento = new Mantenimiento(
                            rs.getInt("id_mantenimiento"),
                            fecha.toLocalDateTime(),
                            rs.getString("detalle_tecnico"),
                            rs.getInt("id_recurso")
                    );

                    mantenimientos.add(mantenimiento);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar mantenimientos: "
                    + e.getMessage());
        }

        return mantenimientos;
    }
}