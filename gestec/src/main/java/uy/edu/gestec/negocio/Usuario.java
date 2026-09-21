/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.edu.gestec.negocio;

/**
 *
 * @author sseba
 */
public class Usuario extends Persona {

    private String nombreUsuario;
    private int idUsuario;
    private String passwordHash;

    public Usuario(int idPersona,
            String documento,
            String nombre,
            String apellido,
            String telefono,
            String nombreUsuario,
            int idUsuario,
            String passwordHash) {

        super(idPersona, documento, nombre, apellido, telefono);
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.passwordHash = passwordHash;

    }
    
    public void setIdUsuario (int idUsuario){
        this.idUsuario = idUsuario;
    }
    public void setNombreUsuario (String nombreUsuario){
        this.nombreUsuario=nombreUsuario;
    }
    public void setPasswordHash(String passwordHash){
        this.passwordHash=passwordHash;
    }
    
    public int getIdUsuario(){
        return idUsuario;
    }
    public String getNombreUsuario(){
        return nombreUsuario;
    }
    public String getPasswordHash(){
        return passwordHash;
    }
    

}
