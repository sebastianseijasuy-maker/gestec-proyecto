/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.edu.gestec.negocio;

import java.time.LocalDateTime;

/**
 *
 * @author sseba
 */
public class Mantenimiento {
    
private int idMantenimiento;
private LocalDateTime fechaInicio;
private String detalleTecnico;
private int idRecurso;


public Mantenimiento (int idMantenimiento, 
                        LocalDateTime fechaInicio,
                        String detalleTecnico,
                        int idRecurso){
    
    this.idMantenimiento= idMantenimiento;
    this.fechaInicio = fechaInicio;
    this.detalleTecnico = detalleTecnico;
    this.idRecurso = idRecurso;
}

public int getIdMantenimiento(){
    return idMantenimiento;
            }

public LocalDateTime getFechaInicio(){
    return fechaInicio;
}

public String getDetalletecnico(){
    return detalleTecnico;
}

public int getIdRecurso(){
    return idRecurso;
}


}
