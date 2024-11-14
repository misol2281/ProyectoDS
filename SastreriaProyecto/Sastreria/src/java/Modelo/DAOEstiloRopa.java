/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Config.Conexion;
import Entidad.EstiloRopa;
import Interfaces.InterfaceEstiloRopa;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author Eduardo Morales
 */
public class DAOEstiloRopa implements InterfaceEstiloRopa {

    Conexion conexion = new Conexion();
    Connection con = conexion.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public List listarEstiloRopa() {
       String sql = "select * from EstiloRopa";
       ArrayList<EstiloRopa> lstEstiloRopa = new ArrayList<>();
       try{
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               EstiloRopa er = new EstiloRopa();
               er.setEstiloRopa(rs.getString("EstiloRopa"));
               er.setDescripcion("Descripcion");
               lstEstiloRopa.add(er);
           }
       }
       catch(SQLException e){
              System.out.println("Error al listar"+e.getMessage());  
           }
       return lstEstiloRopa;
    }

    @Override
    public boolean editarEstiloRopa(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarEstiloRopa(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }  

    @Override
    public boolean agregarEstiloRopa(EstiloRopa er) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
