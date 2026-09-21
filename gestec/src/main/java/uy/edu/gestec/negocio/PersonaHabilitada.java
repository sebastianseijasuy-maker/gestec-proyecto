/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.edu.gestec.negocio;

/**
 *
 * @author Sebastian Seijas
 * @author Agustin Morales
 */
public class PersonaHabilitada extends Persona {
    
    private int idPersonaHab;
    private String tipoPersona;
    private boolean bajaLogica;
    
    public PersonaHabilitada(int idPersonaHab,
            String tipoPersona,
            boolean bajaLogica,
            int idPersona,
            String documento,
            String nombre,
            String apellido,
            String telefono){
        
        super (idPersona, documento, nombre, apellido, telefono);
        this.idPersonaHab=idPersonaHab;
        this.tipoPersona=tipoPersona;
        this.bajaLogica=bajaLogica;
        
    }
    
    public void setIdPersonaHab(int idPersonaHab){
        this.idPersonaHab=idPersonaHab;
    }
    public void setTipoPersona(String tipoPersona){
        this.tipoPersona=tipoPersona;
    }
    public void setBajaLogica(boolean bajaLogica){
        this.bajaLogica=bajaLogica;
    }
    
    public int getIdPersonaHab(){
        return idPersonaHab;
    }
    
    public String getTipoPersona(){
        return tipoPersona;
    }
    
    public boolean getBajaLogica(){
        return bajaLogica;
    }
}
