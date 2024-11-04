/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author Cristian
 */
public class DetalleOrden {
    private int idEstiloRopa;
    private int idTipoTrabajo;
    private int idOrden;
    private String instrucciones;
    private float subTotal;

    public DetalleOrden() {
    }

    public DetalleOrden(int idEstiloRopa, int idTipoTrabajo, int idOrden, String instrucciones, float subTotal) {
        this.idEstiloRopa = idEstiloRopa;
        this.idTipoTrabajo = idTipoTrabajo;
        this.idOrden = idOrden;
        this.instrucciones = instrucciones;
        this.subTotal = subTotal;
    }

    public int getIdEstiloRopa() {
        return idEstiloRopa;
    }

    public void setIdEstiloRopa(int idEstiloRopa) {
        this.idEstiloRopa = idEstiloRopa;
    }

    public int getIdTipoTrabajo() {
        return idTipoTrabajo;
    }

    public void setIdTipoTrabajo(int idTipoTrabajo) {
        this.idTipoTrabajo = idTipoTrabajo;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }
    
    
}
