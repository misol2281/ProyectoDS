/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author Eduardo Morales
 */
public class TipoMedida {
   private String TipoMedida;
    private String Descripcion;
    
    public TipoMedida(){
        
    }

    public TipoMedida(String TipoMedida, String Descripcion) {
        this.TipoMedida = TipoMedida;
        this.Descripcion = Descripcion;
    }

    public String getTipoMedida() {
        return TipoMedida;
    }

    public void setTipoMedida(String TipoMedida) {
        
        this.TipoMedida = TipoMedida;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

}