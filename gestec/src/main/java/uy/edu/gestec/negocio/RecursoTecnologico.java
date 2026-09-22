/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.edu.gestec.negocio;

/**
 *
 * @author sseba
 */
public class RecursoTecnologico {
    
    private int idRecurso;
    private String codigoInv;
    private String nombre;
    private String categoria;
    private String condicion;
    private boolean disponibilidad;
    private boolean bajaLogica;
    
    
    public RecursoTecnologico(int idRecurso,
            String codigoInv,
            String nombre,
            String categoria,
            String condicion,
            boolean disponibilidad,
            boolean baja_logica){
        
        this.idRecurso=idRecurso;
        this.codigoInv=codigoInv;
        this.nombre=nombre;
        this.categoria=categoria;
        this.condicion=condicion;
        this.disponibilidad=disponibilidad;
        this.bajaLogica=bajaLogica;
    }
    
    public void setIdRecurso (int idRecurso){
        this.idRecurso=idRecurso;                
    }
    public void setCodigoInv(String codigoInv){
        this.codigoInv=codigoInv;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setCategoria(String categoria){
        this.categoria=categoria;
    }
    public void setCondicion(String condicion){
        this.condicion=condicion;
    }
    public void setDisponibilidad(boolean disponibilidad){
        this.disponibilidad=disponibilidad;
    }
    public void setBajaLogica(boolean bajaLogica){
        this.bajaLogica=bajaLogica;
    }
    
    public int getIdRecurso(){
        return idRecurso;
    }
    public String getCodigoInv(){
        return codigoInv;
    }
    public String getNombre(){
        return nombre;
    }
    public String getCategoria(){
        return categoria;
    }
    public String getCondicion(){
        return condicion;
    }
    public boolean getDisponibilidad(){
        return disponibilidad;
    }
    public boolean getBajaLogica(){
        return bajaLogica;
    }
    
    
    
    
}
