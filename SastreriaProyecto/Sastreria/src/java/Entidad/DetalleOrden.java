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
    private int id;
    private int idEstiloRopa;
    private String estiloRopa;
    private int idTipoTrabajo;
    private String tipoTrabajo;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getEstiloRopa() {
        return estiloRopa;
    }

    public void setEstiloRopa(String estiloRopa) {
        this.estiloRopa = estiloRopa;
    }

    public String getTipoTrabajo() {
        return tipoTrabajo;
    }

    public void setTipoTrabajo(String tipoTrabajo) {
        this.tipoTrabajo = tipoTrabajo;
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
