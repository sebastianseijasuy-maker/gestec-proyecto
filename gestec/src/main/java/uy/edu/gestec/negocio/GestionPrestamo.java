package uy.edu.gestec.negocio;

import java.util.List;
import uy.edu.gestec.persistencia.PrestamoDAO;
import uy.edu.gestec.persistencia.PersonaHabilitadaDAO;

public class GestionPrestamo {

    private PrestamoDAO prestamoDAO;
private final PersonaHabilitadaDAO personaDAO = new PersonaHabilitadaDAO();


    public GestionPrestamo() {
        prestamoDAO = new PrestamoDAO();
    }


public boolean registrarPrestamo(Prestamo prestamo) {

    // Validar que exista un préstamo y una persona
    if (prestamo == null || prestamo.getPersona() == null) {
        return false;
    }

    // Consultar el estado actualizado de la persona
    PersonaHabilitada personaActual =
            personaDAO.buscarPorDocumento(
                    prestamo.getPersona().getDocumento()
            );

    if (personaActual == null || personaActual.getBajaLogica()) {
        System.out.println(
                "La persona no está habilitada para realizar préstamos"
        );
        return false;
    }

    // Validar que exista al menos un recurso
    if (prestamo.getRecursos() == null
            || prestamo.getRecursos().isEmpty()) {

        System.out.println(
                "El préstamo debe tener al menos un recurso"
        );
        return false;
    }

    // Validar recursos repetidos y disponibilidad
    java.util.Set<Integer> idsRecursos =
            new java.util.HashSet<>();

    for (RecursoTecnologico recurso : prestamo.getRecursos()) {

        if (recurso == null) {
            return false;
        }

        if (!idsRecursos.add(recurso.getIdRecurso())) {
            System.out.println(
                    "No se puede agregar dos veces el mismo recurso"
            );
            return false;
        }

        if (!recurso.getDisponibilidad()) {
            System.out.println(
                    "El recurso " + recurso.getNombre()
                    + " no está disponible"
            );
            return false;
        }
    }

    return prestamoDAO.registrar(prestamo);
}


    public List<Prestamo> consultarPrestamos(
            String busqueda, String filtroEstado) {

        if (busqueda == null) {
            busqueda = "";
        }

        if (filtroEstado == null || filtroEstado.trim().isEmpty()) {
            filtroEstado = "Todos";
        }

        return prestamoDAO.consultarPrestamos(
                busqueda.trim(), filtroEstado);
    }
    
    
public Prestamo buscarPrestamoPendientePorId(int idPrestamo) {

    if (idPrestamo <= 0) {
        return null;
    }

    return prestamoDAO.buscarPrestamoPendientePorId(idPrestamo);
}

public boolean registrarDevolucion(int idPrestamo) {

    if (idPrestamo <= 0) {
        return false;
    }

    return prestamoDAO.registrarDevolucion(idPrestamo);
}




}
