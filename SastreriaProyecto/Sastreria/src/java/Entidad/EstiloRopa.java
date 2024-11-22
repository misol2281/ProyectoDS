/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author Eduardo Morales
 */
public class EstiloRopa {
    
    int id;
    String EstiloRopa;
    String Descripcion;
   

    public EstiloRopa() {
    }

    public EstiloRopa(int id,String EstiloRopa, String Descripcion) {
        this.id = id;
        this.EstiloRopa = EstiloRopa;
        this.Descripcion= Descripcion;
        
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstiloRopa() {
        return EstiloRopa;
    }

    public void setEstiloRopa(String EstiloRopa) {
        this.EstiloRopa = EstiloRopa;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    
}