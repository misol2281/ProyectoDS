/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Config.Conexion;
import Entidad.Usuario;
import Interfaces.InterfaceUsuario;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class DAOUsuario implements InterfaceUsuario{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Usuario us = new Usuario();
    
    @Override
    public List listarUsuario() {
       ArrayList<Usuario> lstUsuario = new ArrayList<>();
       String sql = "select * from Usuario";
       try{
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               Usuario u = new Usuario();
               u.setIdUsuario(rs.getInt("idUsuario"));
               u.setContrasenia(rs.getString("contrasenia"));
               u.setIdRol(rs.getInt("Rol"));
               u.setIdEmpleado(rs.getInt("idEmpleado"));
               lstUsuario.add(u);
           }
       }
       catch(Exception e){
              System.out.println("Error al listar"+e.getMessage());  
           }
       return lstUsuario;
    }
    
    public Usuario validarUsuario(String usu, String contra) {
        String sql = "SELECT * FROM Usuarios WHERE Usuario = ? AND Contra = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usu);
            ps.setString(2, contra);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setUsuario(rs.getString("Usuario"));
                usuario.setContrasenia(rs.getString("Contra"));
                usuario.setIdEmpleado(rs.getInt("idRol"));
                usuario.setIdRol(rs.getInt("idEmpleado"));
                return usuario;
            }
        } catch (SQLException e) {
            System.out.println("Error al validar usuario: " + e.getMessage());
        }
        return null;
    }

  
    @Override
    public  Usuario list(int id) {
         String sql = "select * from Usuario where idUsuario="+id;
       try{
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               us.setIdUsuario(rs.getInt("idUsuario"));
               us.setContrasenia(rs.getString("contrasenia"));
               us.setIdRol(rs.getInt("Rol"));
               us.setIdEmpleado(rs.getInt("IdEmpleado"));
               
              
           }
       }
       catch(Exception e){
              System.out.println("Error al listar"+e.getMessage());  
           }
       return us;
    }

    @Override
    public boolean AgregarUsuario(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean BuscarUsuario(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean EditarUsuario(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean EliminarUsuario(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

