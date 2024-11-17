/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author MINEDUCYT
 */
public class UnidadMedida{
   private String UnidadMedida;
    private String Descripcion;
    
    public UnidadMedida(){
        
    }

    public UnidadMedida(String UnidadMedida, String Descripcion) {
        this.UnidadMedida = UnidadMedida;
        this.Descripcion = Descripcion;
    }

    public String getUnidadMedida() {
        return UnidadMedida;
    }

    public void setUnidadMedida(String UnidadMedida) {
        
        this.UnidadMedida = UnidadMedida;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
}