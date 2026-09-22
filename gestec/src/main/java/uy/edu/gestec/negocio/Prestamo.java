/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.edu.gestec.negocio;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Representa un préstamo de un recurso tecnológico.
 *
 * @author Sebastián Seijas
 * @author Agustín Morales
 */
public class Prestamo {

    private int idPrestamo;
    private LocalDateTime fechaEntrega;
    private LocalDateTime fechaPrevDev;
    private LocalDateTime fechaDevolucionReal;
    private String estadoPrestamo;

    private Usuario usuario;
    private PersonaHabilitada persona;
    private List<RecursoTecnologico> recursos;

    public Prestamo(LocalDateTime fechaEntrega,
            LocalDateTime fechaPrevDev,
            LocalDateTime fechaDevoluciónReal,
            String estadoPrestamo,
            Usuario usuario,
            PersonaHabilitada persona,
            List<RecursoTecnologico> recursos) {

        this.fechaEntrega = fechaEntrega;
        this.fechaPrevDev = fechaPrevDev;
        this.estadoPrestamo = estadoPrestamo;
        this.usuario = usuario;
        this.persona = persona;
        this.recursos = recursos;
    }

    public Prestamo(LocalDateTime fechaPrevDev,
            Usuario usuario,
            PersonaHabilitada persona,
            List<RecursoTecnologico> recursos) {

        this.fechaPrevDev = fechaPrevDev;
        this.usuario = usuario;
        this.persona = persona;
        this.recursos = recursos;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public void setFechaEntrega(LocalDateTime fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public void setFechaPrevDev(LocalDateTime fechaPrevDev) {
        this.fechaPrevDev = fechaPrevDev;
    }

    public void setFechaDevolucionReal(LocalDateTime fechaDevolucionReal) {
        this.fechaDevolucionReal = fechaDevolucionReal;
    }

    public void setEstadoPrestamo(String estadoPrestamo) {
        this.estadoPrestamo = estadoPrestamo;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setPersona(PersonaHabilitada persona) {
        this.persona = persona;
    }

    public void setRecursos(List<RecursoTecnologico> recursos) {
        this.recursos = recursos;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public LocalDateTime getFechaEntrega() {
        return fechaEntrega;
    }

    public LocalDateTime getFechaPrevDev() {
        return fechaPrevDev;
    }

    public LocalDateTime getFechaDevolucionReal() {
        return fechaDevolucionReal;
    }

    public String getEstadoPrestamo() {
        return estadoPrestamo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public PersonaHabilitada getPersona() {
        return persona;
    }

    public List<RecursoTecnologico> getRecursos() {
        return recursos;
    }

    // verifica si el prestamo esta vencido
    public boolean verificarVencimiento() {
        return LocalDateTime.now().isAfter(fechaPrevDev);
    }

}
