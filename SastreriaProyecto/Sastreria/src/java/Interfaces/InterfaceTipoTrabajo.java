/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Entidad.TipoTrabajo;
import java.util.List;

/**
 *
 * @author Cristian
 */
public interface InterfaceTipoTrabajo {
    List listarTipoTrabajos();
    boolean AgregarTipoTrabajo(TipoTrabajo Tt);
    TipoTrabajo BuscarPorId(int id);
    boolean EditarTipoTrabajo(TipoTrabajo Tt);
    boolean EliminarTipoTrabajo(int id);
}
