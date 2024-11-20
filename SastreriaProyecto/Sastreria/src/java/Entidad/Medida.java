/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author Eduardo Morales
 */
public class Medida {
   private String Medida;
    private String Descripcion;
    
    public Medida(){
        
    }

    public Medida(String Medida, String Descripcion) {
        this.Medida = Medida;
        this.Descripcion = Descripcion;
    }

    public String getMedida() {
        return Medida;
    }

    public void setMedida(String Medida) {
        
        this.Medida = Medida;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
}
