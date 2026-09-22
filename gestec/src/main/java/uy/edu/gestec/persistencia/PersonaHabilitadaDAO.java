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

/**
 *
 * @author sseba
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
}