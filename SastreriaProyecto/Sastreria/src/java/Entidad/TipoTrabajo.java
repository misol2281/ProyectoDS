/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author Cristian
 */
public class TipoTrabajo {
    private String tipoTrabajo;
    private String descripcion;

    public TipoTrabajo() {
    }

    public TipoTrabajo(String tipoTrabajo, String descripcion) {
        this.tipoTrabajo = tipoTrabajo;
        this.descripcion = descripcion;
    }

    public String getTipoTrabajo() {
        return tipoTrabajo;
    }

    public void setTipoTrabajo(String tipoTrabajo) {
        this.tipoTrabajo = tipoTrabajo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
