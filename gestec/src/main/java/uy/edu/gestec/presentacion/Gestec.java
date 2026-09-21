package uy.edu.gestec.presentacion;

import java.sql.Connection;
import java.sql.SQLException;
import uy.edu.gestec.persistencia.ConexionBD;

public class Gestec {

    public static void main(String[] args) {

        try (Connection conexion = ConexionBD.conectar()) {
            System.out.println("Conexión exitosa con la base de datos GESTEC");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos:");
            System.out.println(e.getMessage());
        }
    }
}