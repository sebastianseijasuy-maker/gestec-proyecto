/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.edu.gestec.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import uy.edu.gestec.negocio.Persona;

/**
 *
 * @author sseba
 */
public class PersonaDAO {
    
    
    public Persona buscarPorDocumento(String documento) {
        
        String sql = "SELECT id_persona, documento, nombre, "
                + "apellido, telefono "
                + "FROM persona "
                + "WHERE documento = ?";
    
        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, documento);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return new Persona(
                            rs.getInt("id_persona"),
                            rs.getString("documento"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("telefono")
                    );
                }
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error al buscar persona: " + e.getMessage()
            );
        }

        return null;
    }

    }
    

