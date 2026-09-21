package uy.edu.gestec.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL =
            "jdbc:mysql://127.0.0.1:3306/gestec";

    private static final String USUARIO = "root";
    private static final String PASSWORD = "CONTRASEÑA";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }
}