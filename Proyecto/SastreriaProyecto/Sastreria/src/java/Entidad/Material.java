/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author MINEDUCYT
 */
public class Material {
    
   private String Material;
   private String Descripcion;
   public Material() {
    }

    public Material(String Material, String Descripcion) {
        this.Material = Material;
        this.Descripcion = Descripcion;
        
  
    }

    

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String Material) {
        this.Material = Material;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
}
