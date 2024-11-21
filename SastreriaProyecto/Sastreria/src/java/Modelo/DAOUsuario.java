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
               u.setId(rs.getInt("idUsuario"));
               u.setUsuario(rs.getString("Usuario"));
               u.setCargo(rs.getString("Cargo"));
               u.setRol(rs.getString("Rol"));
               u.setContraseña("Contraseña");
               lstUsuario.add(u);
           }
       }
       catch(Exception e){
              System.out.println("Error al listar"+e.getMessage());  
           }
       return lstUsuario;
    }

  
    @Override
    public  Usuario list(int id) {
         String sql = "select * from Usuario where idUsuario="+id;
       try{
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               us.setUsuario(rs.getString("Usuario"));
               us.setCargo(rs.getString("Cargo"));
               us.setRol(rs.getString("Rol"));
               us.setContraseña("Contraseña");
               
              
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

