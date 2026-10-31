
package uy.edu.gestec.negocio;
import java.util.ArrayList;
import java.util.List;
import uy.edu.gestec.persistencia.RecursoTecnologicoDAO;

public class ServicioRecursoTecnologico {

    private final RecursoTecnologicoDAO recursoDAO;

    public ServicioRecursoTecnologico() {
        recursoDAO = new RecursoTecnologicoDAO();
    }

    public List<RecursoTecnologico> buscarParaMantenimiento(
            String busqueda) {

        if (busqueda == null || busqueda.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Ingrese el nombre o código del recurso.");
        }

        return recursoDAO.buscarParaMantenimiento(busqueda.trim());
    }

    public List<RecursoTecnologico> buscarPorNombre(String nombre) {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Debe ingresar un recurso para buscar.");
        }

        return recursoDAO.buscarPorNombre(nombre.trim());
    }

    public String agregarRecurso(RecursoTecnologico recurso) {

        String validacion = validarRecurso(recurso);

        if (!"OK".equals(validacion)) {
            return validacion;
        }

        if (recurso.getBajaLogica()) {
            return "No se puede registrar un recurso dado de baja.";
        }

        boolean agregado = recursoDAO.agregarRecurso(recurso);

        return agregado
                ? "OK"
                : "No se pudo agregar el recurso. "
                + "Verifique que el código de inventario no exista.";
    }

    public String modificarRecurso(RecursoTecnologico recurso) {

        String validacion = validarRecurso(recurso);

        if (!"OK".equals(validacion)) {
            return validacion;
        }

        if (recurso.getIdRecurso() <= 0) {
            return "Debe seleccionar un recurso válido.";
        }

        if (recurso.getBajaLogica()) {
            return "No se puede modificar un recurso dado de baja.";
        }

        boolean modificado = recursoDAO.modificarRecurso(recurso);

        return modificado
                ? "OK"
                : "No se pudo modificar el recurso.";
    }

    public String darDeBajaRecurso(RecursoTecnologico recurso) {

        if (recurso == null || recurso.getIdRecurso() <= 0) {
            return "Primero debe buscar y seleccionar un recurso.";
        }

        if (recurso.getBajaLogica()) {
            return "El recurso ya se encuentra dado de baja.";
        }

        boolean eliminado = recursoDAO.eliminarRecurso(
                recurso.getIdRecurso());

        return eliminado
                ? "OK"
                : "No se pudo dar de baja el recurso.";
    }

    private String validarRecurso(RecursoTecnologico recurso) {

        if (recurso == null) {
            return "Debe ingresar los datos del recurso.";
        }

        if (recurso.getCodigoInv() == null
                || recurso.getCodigoInv().trim().isEmpty()
                || recurso.getNombre() == null
                || recurso.getNombre().trim().isEmpty()
                || recurso.getCategoria() == null
                || recurso.getCategoria().trim().isEmpty()
                || recurso.getCondicion() == null
                || recurso.getCondicion().trim().isEmpty()) {

            return "Debe completar todos los campos.";
        }

        if (!recurso.getCodigoInv().matches("[0-9]+")) {
            return "El código de inventario debe contener solo números.";
        }

        return "OK";
    }
    
public List<RecursoTecnologico> buscarDisponiblesPorNombre(
        String nombre) {

    if (nombre == null || nombre.trim().isEmpty()) {
        return new ArrayList<>();
    }

    return recursoDAO.buscarDisponiblesPorNombre(nombre.trim());
}

}
