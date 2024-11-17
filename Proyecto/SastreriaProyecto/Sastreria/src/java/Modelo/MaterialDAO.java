/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Config.Conexion;
import Entidad.Material;
import Interfaces.InterMaterial;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author MINEDUCYT
 */
public class MaterialDAO implements InterMaterial{
    Conexion conexion = new Conexion();
    Connection con = conexion.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public List listarMaterial() {
       String sql = "select * from Material";
       ArrayList<Material> lstMaterial = new ArrayList<>();
       try{
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               Material ma = new Material();
               ma.setMaterial(rs.getString("Material"));
               ma.setDescripcion("Descripcion");
               lstMaterial.add(ma);
           }
       }
       catch(SQLException e){
              System.out.println("Error al listar"+e.getMessage());  
           }
       return lstMaterial;
    }

    @Override
    public boolean editarMaterial(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarMaterial(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }  

    @Override
    public boolean agregarMaterial(Material ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean BuscarMaterial(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
