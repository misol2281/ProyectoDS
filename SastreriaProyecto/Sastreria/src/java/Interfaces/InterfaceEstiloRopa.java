/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Entidad.EstiloRopa;
import java.util.List;
/**
 *
 * @author Eduardo Morales
 */
public interface InterfaceEstiloRopa {
    List listarEstiloRopa();

    public EstiloRopa list(int id);
    boolean AgregarEstiloRopa(EstiloRopa esr);
    boolean BuscarEstiloRopa(int id);
    boolean EditarEstiloRopa(EstiloRopa esr);
    boolean EliminarEstiloRopa(int id);
    
}