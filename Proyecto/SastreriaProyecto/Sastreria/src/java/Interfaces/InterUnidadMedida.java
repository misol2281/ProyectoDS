/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;
import Entidad.UnidadMedida;
import java.util.List;

/**
 *
 * @author MINEDUCYT
 */
public interface InterUnidadMedida {
    List listarUnidadMedida ();
    boolean AgregarUnidadMedida (UnidadMedida  um);
    boolean BuscarUnidadMedida (int id);
    boolean EditarUnidadMedida (int id);
    boolean EliminarUnidadMedida (int id);
    
}