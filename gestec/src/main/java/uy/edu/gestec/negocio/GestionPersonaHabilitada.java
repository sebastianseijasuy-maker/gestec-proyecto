/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package uy.edu.gestec.negocio;

import uy.edu.gestec.persistencia.PersonaHabilitadaDAO;

public class GestionPersonaHabilitada {

    private final PersonaHabilitadaDAO personaDAO;

    public GestionPersonaHabilitada() {
        personaDAO = new PersonaHabilitadaDAO();
    }

    public PersonaHabilitada buscarPorDocumento(String documento) {

        if (documento == null || documento.trim().isEmpty()) {
            return null;
        }

        return personaDAO.buscarPorDocumento(documento.trim());
    }

    public String registrarPersona(
            String documento,
            String nombre,
            String apellido,
            String telefono,
            String tipoPersona) {

        documento = limpiar(documento);
        nombre = limpiar(nombre);
        apellido = limpiar(apellido);
        telefono = limpiar(telefono);
        tipoPersona = limpiar(tipoPersona);

        if (documento.isEmpty() || nombre.isEmpty()
                || apellido.isEmpty() || telefono.isEmpty()
                || tipoPersona.isEmpty()) {
            return "Debe completar todos los campos.";
        }

        if (!documento.matches("[0-9]+")) {
            return "El documento debe contener solamente números.";
        }

        if (!nombre.matches("[\\p{L} ]+")
                || !apellido.matches("[\\p{L} ]+")
                || !tipoPersona.matches("[\\p{L} ]+")
                || !telefono.matches("[0-9]+")) {
            return "Verifique los datos ingresados.";
        }

        if (personaDAO.buscarPorDocumento(documento) != null) {
            return "Ya existe una persona habilitada con ese documento.";
        }

        boolean registrado = personaDAO.registrarPersona(
                documento, nombre, apellido, telefono, tipoPersona);

        return registrado
                ? "OK"
                : "No se pudo registrar la persona. "
                + "Verifique los datos o la conexión a MySQL.";
    }

    public String modificarPersona(
            PersonaHabilitada personaSeleccionada,
            String documento,
            String nombre,
            String apellido,
            String telefono,
            String tipoPersona) {

        if (personaSeleccionada == null) {
            return "Primero debe buscar una persona.";
        }

        if (personaSeleccionada.getBajaLogica()) {
            return "No se puede modificar una persona dada de baja.";
        }

        documento = limpiar(documento);
        nombre = limpiar(nombre);
        apellido = limpiar(apellido);
        telefono = limpiar(telefono);
        tipoPersona = limpiar(tipoPersona);

        if (!documento.equals(personaSeleccionada.getDocumento())) {
            return "No se puede cambiar el documento durante la modificación.";
        }

        if (nombre.isEmpty() || apellido.isEmpty()
                || telefono.isEmpty() || tipoPersona.isEmpty()) {
            return "Debe completar todos los campos.";
        }

        if (!nombre.matches("[\\p{L} ]+")
                || !apellido.matches("[\\p{L} ]+")
                || !tipoPersona.matches("[\\p{L} ]+")
                || !telefono.matches("[0-9]+")) {
            return "Verifique los datos ingresados.";
        }

        boolean modificado = personaDAO.modificarPersona(
                personaSeleccionada.getIdPersona(),
                nombre, apellido, telefono, tipoPersona);

        return modificado
                ? "OK"
                : "No se pudo modificar la persona.";
    }

    public String darDeBajaPersona(
            PersonaHabilitada personaSeleccionada,
            String documento) {

        if (personaSeleccionada == null) {
            return "Primero debe buscar una persona.";
        }

        if (personaSeleccionada.getBajaLogica()) {
            return "Esta persona ya se encuentra dada de baja.";
        }

        if (!limpiar(documento).equals(
                personaSeleccionada.getDocumento())) {
            return "El documento fue modificado. "
                    + "Debe buscar nuevamente a la persona.";
        }

        boolean bajaRealizada = personaDAO.darDeBajaPersona(
                personaSeleccionada.getIdPersonaHab());

        return bajaRealizada
                ? "OK"
                : "No se pudo dar de baja a la persona.\n"
                + "Puede tener préstamos pendientes de devolución "
                + "o haber ocurrido un error en la base de datos.";
    }

    private String limpiar(String valor) {
        return valor == null ? "" : valor.trim();
    }
}
