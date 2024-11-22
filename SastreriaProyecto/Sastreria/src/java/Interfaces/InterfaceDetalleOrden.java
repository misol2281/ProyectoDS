/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Entidad.DetalleOrden;
import java.util.List;

public interface InterfaceDetalleOrden {
    public List<DetalleOrden> listarDetOrden();
    public boolean agregarDetOrden(DetalleOrden dO);
    public DetalleOrden buscarPorId(int id);
    public boolean eliminarDetOrden(int id);
    public boolean actualizarDetOrden(DetalleOrden dO);
}
