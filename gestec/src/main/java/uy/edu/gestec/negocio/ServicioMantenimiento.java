/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package uy.edu.gestec.negocio;

import java.util.List;
import uy.edu.gestec.persistencia.MantenimientoDAO;

public class ServicioMantenimiento {

    private final MantenimientoDAO mantenimientoDAO;

    public ServicioMantenimiento() {
        mantenimientoDAO = new MantenimientoDAO();
    }

    public List<Mantenimiento> consultarPorRecurso(int idRecurso) {

        if (idRecurso <= 0) {
            throw new IllegalArgumentException(
                    "Debe seleccionar un recurso válido.");
        }

        return mantenimientoDAO.consultarPorRecurso(idRecurso);
    }
    
public boolean registrarMantenimiento(
        int idRecurso,
        String detalle,
        String condicionFinal) {

    if (idRecurso <= 0) {
        return false;
    }

    if (detalle == null || detalle.trim().isEmpty()) {
        return false;
    }

    if (condicionFinal == null
            || (!condicionFinal.equals("operativo")
            && !condicionFinal.equals("en reparacion"))) {
        return false;
    }

    return mantenimientoDAO.registrarMantenimiento(
            idRecurso,
            detalle.trim(),
            condicionFinal
    );
}


}
