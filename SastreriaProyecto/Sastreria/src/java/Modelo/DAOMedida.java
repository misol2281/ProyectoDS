/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Config.Conexion;
import Entidad.Medida;
import Interfaces.InterfaceMedida;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Eduardo Morales
 */
public class DAOMedida implements InterfaceMedida{
    Conexion cn = new Conexion();
    Connection con = cn.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public List listarMedida() {
       String sql = "select * from Medida";
       ArrayList<Medida> lstMedida = new ArrayList<>();
       try{
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
            while(rs.next()){
               Medida m = new Medida();
               m.setMedida(rs.getString("Medida"));
               m.setDescripcion(rs.getString("Descripcion"));
               lstMedida.add(m);
           }
       }
       catch(Exception e){
              System.out.println("Error al listar"+e.getMessage());  
           }
       return lstMedida;
    }


    @Override
    public boolean EditarMedida(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean EliminarMedida(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }  

    @Override
    public boolean AgregarMedida(Medida m) {
         String sql="insert into Medida(Medida,Descripcion) values ('"+m.getMedida()+"','"+m.getDescripcion()+"')";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e){
            
        }
        return false;
    }

    @Override
    public boolean BuscarMedida(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }

  