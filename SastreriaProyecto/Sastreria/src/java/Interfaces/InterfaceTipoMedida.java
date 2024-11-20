/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Entidad.TipoMedida;
import java.util.List;
/**
 *
 * @author Eduardo Morales
 */
public interface InterfaceTipoMedida {
    List listarTipoMedida();
    boolean AgregarTipoMedida(TipoMedida tm);
    boolean BuscarTipoMedida(int id);
    boolean EditarTipoMedida(int id);
    boolean EliminarTipoMedida(int id);
    
}