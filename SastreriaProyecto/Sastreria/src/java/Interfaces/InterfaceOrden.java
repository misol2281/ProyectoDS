/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Entidad.Orden;
import java.util.List;

/**
 *
 * @author Cristian
 */
public interface InterfaceOrden {
    List listarOrden();
    boolean AgregarOrden(Orden o);
    Orden BuscarPorId(int id);
    boolean EditarOrden(Orden o);
    boolean EliminarOrden(int id);
}
