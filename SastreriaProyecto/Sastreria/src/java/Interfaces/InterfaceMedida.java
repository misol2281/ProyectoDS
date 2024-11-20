/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Entidad.Medida;
import java.util.List;
/**
 *
 * @author Eduardo Morales
 */
public interface InterfaceMedida {
    List listarMedida();
    boolean AgregarMedida(Medida m);
    boolean BuscarMedida(int id);
    boolean EditarMedida(int id);
    boolean EliminarMedida(int id);
    
}