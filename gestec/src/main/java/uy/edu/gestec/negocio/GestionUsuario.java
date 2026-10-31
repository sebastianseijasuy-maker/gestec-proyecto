/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package uy.edu.gestec.negocio;

import java.util.Arrays;
import uy.edu.gestec.persistencia.UsuarioDAO;


public class GestionUsuario {

    private final UsuarioDAO usuarioDAO;

    public GestionUsuario() {
        usuarioDAO = new UsuarioDAO();
    }

    public String completarConfiguracionInicial(
            Usuario usuarioActual,
            String documento,
            String nombre,
            String apellido,
            String nuevoUsuario,
            char[] actual,
            char[] nueva,
            char[] confirmar) {

        // Validar campos obligatorios
        if (usuarioActual == null
                || documento == null || documento.isBlank()
                || nombre == null || nombre.isBlank()
                || apellido == null || apellido.isBlank()
                || nuevoUsuario == null || nuevoUsuario.isBlank()
                || actual == null || actual.length == 0
                || nueva == null || nueva.length == 0
                || confirmar == null || confirmar.length == 0) {

            return "Complete todos los campos.";
        }

        // Verificar que sea la cuenta inicial
        if (!"GESTEC-ADMIN".equals(usuarioActual.getDocumento())) {
            return "Esta cuenta ya fue configurada.";
        }

        // Verificar contraseña actual
        if (!SeguridadContrasena.verificarContrasena(
                actual, usuarioActual.getPasswordHash())) {

            return "La contraseña actual es incorrecta.";
        }

        // Verificar coincidencia
        if (!Arrays.equals(nueva, confirmar)) {
            return "Las contraseñas nuevas no coinciden.";
        }

        // Evitar reutilizar la contraseña actual
        if (Arrays.equals(actual, nueva)) {
            return "La nueva contraseña debe ser diferente a la actual.";
        }

        // Generar hash
        String nuevoHash = SeguridadContrasena.generarHash(nueva);

        // Guardar mediante persistencia
        boolean actualizado = usuarioDAO.completarConfiguracionInicial(
                usuarioActual.getIdUsuario(),
                usuarioActual.getIdPersona(),
                documento.trim(),
                nombre.trim(),
                apellido.trim(),
                nuevoUsuario.trim(),
                nuevoHash
        );

        if (actualizado) {
            return "OK";
        }

        return "No se pudo completar la configuración.\n"
                + "Verifique que el documento y el usuario "
                + "no estén registrados.";
    }
    
    
public Usuario autenticar(String nombreUsuario, char[] contrasena) {

    if (nombreUsuario == null
            || nombreUsuario.trim().isEmpty()
            || contrasena == null
            || contrasena.length == 0) {
        return null;
    }

    Usuario usuario = usuarioDAO.buscarPorNombreUsuario(
            nombreUsuario.trim());

    if (usuario == null) {
        return null;
    }

    boolean contrasenaCorrecta =
            SeguridadContrasena.verificarContrasena(
                    contrasena,
                    usuario.getPasswordHash()
            );

    return contrasenaCorrecta ? usuario : null;
}

public boolean requiereCambioInicial(Usuario usuario) {

    if (usuario == null) {
        return false;
    }

    char[] claveInicial = "admin".toCharArray();

    try {
        return "admin".equals(usuario.getNombreUsuario())
                && SeguridadContrasena.verificarContrasena(
                        claveInicial,
                        usuario.getPasswordHash()
                );
    } finally {
        java.util.Arrays.fill(claveInicial, '\0');
    }
}
public boolean existeUsuarioParaPersona(int idPersona) {

    if (idPersona <= 0) {
        return false;
    }

    return usuarioDAO.existeUsuarioParaPersona(idPersona);
}

public boolean registrarUsuarioPOITE(
        Integer idPersona,
        String documento,
        String nombre,
        String apellido,
        String nombreUsuario,
        char[] contrasena) {

    if (documento == null || documento.trim().isEmpty()
            || nombre == null || nombre.trim().isEmpty()
            || apellido == null || apellido.trim().isEmpty()
            || nombreUsuario == null || nombreUsuario.trim().isEmpty()
            || contrasena == null || contrasena.length < 8) {

        return false;
    }

    // Generar el hash dentro de negocio
    String hash = SeguridadContrasena.generarHash(contrasena);

    return usuarioDAO.registrarUsuarioPOITE(
            idPersona,
            documento.trim(),
            nombre.trim(),
            apellido.trim(),
            nombreUsuario.trim(),
            hash
    );
}

    
}
