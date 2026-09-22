package uy.edu.gestec.persistencia;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import uy.edu.gestec.negocio.PersonaHabilitada;
import uy.edu.gestec.negocio.Prestamo;
import uy.edu.gestec.negocio.RecursoTecnologico;
import uy.edu.gestec.negocio.Usuario;
import uy.edu.gestec.negocio.GestionPrestamo;

public class probarPrestamo {

    public static void main(String[] args) {

        Usuario usuario = new Usuario(
                1,
                "41231235",
                "Sebastian",
                "Seijas",
                "091007177",
                "sseba",
                1,
                "clave de prueba"
        );

        PersonaHabilitada persona = new PersonaHabilitada(
                1,
                "Docente",
                false,
                3,
                "34345677",
                "Ana",
                "Martinez",
                "098789564"
        );

        RecursoTecnologico recurso = new RecursoTecnologico(
                10,
                "005",
                "notebook electra",
                "notebook",
                "operativo",
                true,
                false
        );
        List<RecursoTecnologico> recursos = new ArrayList<>();
        recursos.add(recurso);

        LocalDateTime fechaPrevDev = LocalDateTime.now().plusDays(7);

        Prestamo prestamo = new Prestamo(
                fechaPrevDev,
                usuario,
                persona,
                recursos
        );

        GestionPrestamo gestion = new GestionPrestamo();

boolean registrado = gestion.registrarPrestamo(prestamo);

        if (registrado) {
            System.out.println("Préstamo registrado correctamente");
        } else {
            System.out.println("No se pudo registrar el préstamo");
        }
    }
}
