/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

import java.util.Date;

/**
 *
 * @author Cristian
 */
public class Orden {
    private String nombreCliente;
    private String nombreEmpleado;
    private Date fechaOrden;
    private Date fechaEntrega;
    private float montoTotal;

    public Orden() {
    }

    public Orden(String nombreCliente, String nombreEmpleado, Date fechaOrden, Date fechaEntrega, float montoTotal) {
        this.nombreCliente = nombreCliente;
        this.nombreEmpleado = nombreEmpleado;
        this.fechaOrden = fechaOrden;
        this.fechaEntrega = fechaEntrega;
        this.montoTotal = montoTotal;
    }

    

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }
    
    
}
