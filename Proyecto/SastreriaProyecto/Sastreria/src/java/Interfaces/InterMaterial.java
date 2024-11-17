/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Entidad.Material;
import java.util.List;

/**
 *
 * @author MINEDUCYT
 */
public interface InterMaterial {
    List listarMaterial();
    boolean agregarMaterial(Material ma);
    boolean BuscarMaterial (int id);
    boolean editarMaterial(int id);
    boolean eliminarMaterial(int id);
    
    
}
