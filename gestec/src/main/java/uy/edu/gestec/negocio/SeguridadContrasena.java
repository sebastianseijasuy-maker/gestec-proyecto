/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.edu.gestec.negocio;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author Agustin y Sebastian
 */
public class SeguridadContrasena {
    


   private static final int ITERACIONES = 600000;
    private static final int LONGITUD_HASH = 256;
    private static final SecureRandom RANDOM = new SecureRandom();

    // Crear un hash seguro a partir de una contraseña
    public static String generarHash(char[] contrasena) {

        if (contrasena == null || contrasena.length == 0) {
            throw new IllegalArgumentException(
                    "La contraseña no puede estar vacía.");
        }

        byte[] sal = new byte[16];
        RANDOM.nextBytes(sal);

        byte[] hash = calcularHash(
                contrasena, sal, ITERACIONES);

        return "PBKDF2-SHA256$"
                + ITERACIONES + "$"
                + Base64.getEncoder().encodeToString(sal) + "$"
                + Base64.getEncoder().encodeToString(hash);
    }

    // Verificar una contraseña ingresada
    public static boolean verificarContrasena(
            char[] contrasena, String hashGuardado) {

        if (contrasena == null || hashGuardado == null) {
            return false;
        }

        try {
            String[] partes = hashGuardado.split("\\$");

            if (partes.length != 4
                    || !partes[0].equals("PBKDF2-SHA256")) {
                return false;
            }

            int iteraciones = Integer.parseInt(partes[1]);

            if (iteraciones < 100000 || iteraciones > 2000000) {
                return false;
            }

            byte[] sal = Base64.getDecoder().decode(partes[2]);
            byte[] hashOriginal =
                    Base64.getDecoder().decode(partes[3]);

            if (sal.length != 16 || hashOriginal.length != 32) {
                return false;
            }

            byte[] hashIngresado = calcularHash(
                    contrasena, sal, iteraciones);

            return MessageDigest.isEqual(
                    hashOriginal, hashIngresado);

        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private static byte[] calcularHash(
            char[] contrasena, byte[] sal, int iteraciones) {

        PBEKeySpec especificacion = new PBEKeySpec(
                contrasena, sal, iteraciones, LONGITUD_HASH);

        try {
            SecretKeyFactory fabrica =
                    SecretKeyFactory.getInstance(
                            "PBKDF2WithHmacSHA256");

            return fabrica.generateSecret(
                    especificacion).getEncoded();

        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(
                    "Error al proteger la contraseña.", e);

        } finally {
            especificacion.clearPassword();
        }
    }
    

    
}


