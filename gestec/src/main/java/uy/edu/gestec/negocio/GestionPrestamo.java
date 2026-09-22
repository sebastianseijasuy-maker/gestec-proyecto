package uy.edu.gestec.negocio;

import uy.edu.gestec.persistencia.PrestamoDAO;

public class GestionPrestamo {

    private PrestamoDAO prestamoDAO;

    public GestionPrestamo() {
        prestamoDAO = new PrestamoDAO();
    }

    public boolean registrarPrestamo(Prestamo prestamo) {

        // Validar que la persona esté habilitada
        if (!prestamo.getPersona().consultarHabilitacion()) {
            System.out.println("La persona no está habilitada para realizar préstamos");
            return false;
        }
        // Validar que el préstamo tenga al menos un recurso
if (prestamo.getRecursos() == null || prestamo.getRecursos().isEmpty()) {
    System.out.println("El préstamo debe tener al menos un recurso");
    return false;
}
// Validar que todos los recursos estén disponibles
for (RecursoTecnologico recurso : prestamo.getRecursos()) {

    if (!recurso.getDisponibilidad()) {
        System.out.println("El recurso " + recurso.getNombre()
                + " no está disponible");
        return false;
    }
}

        return prestamoDAO.registrar(prestamo);
    }
}