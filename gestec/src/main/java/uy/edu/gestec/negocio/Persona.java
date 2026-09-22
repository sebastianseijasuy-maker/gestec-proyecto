/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.edu.gestec.negocio;

/**
 *
 * @author sseba
 */
public class Persona {

    private int idPersona;
    private String documento;
    private String nombre;
    private String apellido;
    private String telefono;

    public Persona(int idPersona,
            String documento,
            String nombre,
            String apellido,
            String telefono) {

        

            idPersona = idPersona;
            this.documento = documento;
            this.nombre = nombre;
            this.apellido = apellido;
            this.telefono = telefono;
        

    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;

    }

    public int getIdPersona() {
        return idPersona;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

}
