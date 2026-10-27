package uy.edu.gestec.negocio;

import java.util.Arrays;

public class GenerarClaveInicial {

    public static void main(String[] args) {

        char[] contrasena = "admin".toCharArray();

        String hash = SeguridadContrasena.generarHash(contrasena);

        System.out.println("Hash generado:");
        System.out.println(hash);

        Arrays.fill(contrasena, '\0');
    }
}