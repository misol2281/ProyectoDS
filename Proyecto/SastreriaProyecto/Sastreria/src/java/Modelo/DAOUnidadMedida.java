/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Config.Conexion;
import Entidad.UnidadMedida;
import Interfaces.InterUnidadMedida;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Eduardo Morales
 */
public class DAOUnidadMedida implements InterUnidadMedida{
    Conexion conexion = new Conexion();
    Connection con = conexion.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public List listarUnidadMedida() {
       String sql = "select * from UnidadMedida";
       ArrayList<UnidadMedida> lstUnidadMedida = new ArrayList<>();
       try{
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
             UnidadMedida um = new UnidadMedida();
               um.setUnidadMedida(rs.getString("UnidadMedida"));
               um.setDescripcion(rs.getString("Descripcion"));
               lstUnidadMedida.add(um);
           }
       }
       catch(SQLException e){
              System.out.println("Error al listar"+e.getMessage());  
           }
       return lstUnidadMedida;
    }

    @Override
    public boolean EditarUnidadMedida(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean EliminarUnidadMedida(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }  

    @Override
    public boolean AgregarUnidadMedida(UnidadMedida um) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean BuscarUnidadMedida(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    }