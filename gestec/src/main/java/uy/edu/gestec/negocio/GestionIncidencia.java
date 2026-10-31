
package uy.edu.gestec.negocio;

import uy.edu.gestec.persistencia.IncidenciaDAO;

public class GestionIncidencia {

    private final IncidenciaDAO incidenciaDAO;

    public GestionIncidencia() {
        incidenciaDAO = new IncidenciaDAO();
    }

    public boolean registrarIncidencia(
            int idRecurso,
            String tipoIncidencia,
            String descripcion) {

        if (idRecurso <= 0) {
            return false;
        }

        if (tipoIncidencia == null
                || tipoIncidencia.trim().isEmpty()) {
            return false;
        }

        if (descripcion == null
                || descripcion.trim().isEmpty()) {
            return false;
        }

        return incidenciaDAO.registrarIncidencia(
                idRecurso,
                tipoIncidencia.trim(),
                descripcion.trim()
        );
    }
}
