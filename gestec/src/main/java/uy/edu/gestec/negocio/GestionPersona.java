
package uy.edu.gestec.negocio;

import uy.edu.gestec.persistencia.PersonaDAO;

public class GestionPersona {

    private final PersonaDAO personaDAO;

    public GestionPersona() {
        personaDAO = new PersonaDAO();
    }

    public Persona buscarPorDocumento(String documento) {

        if (documento == null
                || documento.trim().isEmpty()) {
            return null;
        }

        return personaDAO.buscarPorDocumento(documento.trim());
    }
}
