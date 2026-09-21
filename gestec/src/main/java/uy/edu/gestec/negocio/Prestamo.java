/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.edu.gestec.negocio;

import java.time.LocalDateTime;

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
    private RecursoTecnologico recurso;

    public Prestamo(LocalDateTime fechaEntrega,
            LocalDateTime fechaPrevDev,
            LocalDateTime fechaDevoluciónReal,
            String estadoPrestamo,
            Usuario usuario,
            PersonaHabilitada persona,
            RecursoTecnologico recurso) {

        
            this.fechaEntrega = fechaEntrega;
            this.fechaPrevDev = fechaPrevDev;
            this.estadoPrestamo = estadoPrestamo;
            this.usuario = usuario;
            this.persona = persona;
            this.recurso = recurso;
        

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

    public void setRecurso(RecursoTecnologico recurso) {
        this.recurso = recurso;
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

    public RecursoTecnologico getRecurso() {
        return recurso;
    }

}
