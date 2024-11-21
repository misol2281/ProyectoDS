/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Entidad.Usuario;
import java.util.List;
/**
 *
 * @author Eduardo Morales
 */
public interface InterfaceUsuario {
    List listarUsuario();

    public Usuario list(int id);
    boolean AgregarUsuario(Usuario u);
    boolean BuscarUsuario(int id);
    boolean EditarUsuario(Usuario u);
    boolean EliminarUsuario(int id);
}
    