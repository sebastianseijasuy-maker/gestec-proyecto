/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.edu.gestec.persistencia;

import java.util.List;
import uy.edu.gestec.negocio.RecursoTecnologico;

/**
 *
 * @author sseba
 */
public class ProbarREcurso {

    public static void main(String[] args) {

        RecursoTecnologicoDAO dao = new RecursoTecnologicoDAO();

        /**
         * List<RecursoTecnologico> recursos = dao.buscarPorNombre("note");
         *
         * if (recursos.isEmpty()) { System.out.println("No se encontraron
         * recursos"); } else { for (RecursoTecnologico recurso : recursos) {
         * System.out.println("Nombre: " + recurso.getNombre());
         * System.out.println("Código: " + recurso.getCodigoInv());
         * System.out.println("--------------------"); } }
         *
         *
         *
         * RecursoTecnologico recurso = new RecursoTecnologico("009", "Mouse
         * HP", "Periféricos", "Operativo", true);
         *
         * boolean agregado = dao.agregarRecurso(recurso);
         *
         * if (agregado) { System.out.println("Recurso agregado correctamente");
         * } else { System.out.println("No se pudo agregar el recurso"); }
         *
         * RecursoTecnologico recurso = new RecursoTecnologico( 001, //
         * id_recurso existente "001", // codigo_inv "Mouse HP", // nombre
         * "Periféricos", // categoria "En reparación",// condicion false, //
         * disponibilidad true // bajaLogica );
         *
         * boolean modificado = dao.modificarRecurso(recurso);
         *
         * if (modificado) { System.out.println("Recurso modificado
         * correctamente"); } else { System.out.println("No se pudo modificar el
         * recurso"); }
         */
        boolean dadoDeBaja = dao.eliminarRecurso(002);

        if (dadoDeBaja) {
            System.out.println("Recurso dado de baja correctamente");
        } else {
            System.out.println("No se pudo dar de baja el recurso");
        }

        {

        }

    }

}
