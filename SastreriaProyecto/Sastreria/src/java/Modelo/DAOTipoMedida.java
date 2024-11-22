/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Config.Conexion;
import Entidad.TipoMedida;
import Interfaces.InterfaceTipoMedida;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Eduardo Morales
 */
public class DAOTipoMedida implements InterfaceTipoMedida{
    Conexion cn = new Conexion();
    Connection con = cn.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public List listarTipoMedida() {
       String sql = "select * from TipoMedida";
       ArrayList<TipoMedida> lstTipoMedida = new ArrayList<>();
       try{
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               TipoMedida tm = new TipoMedida();
               tm.setTipoMedida(rs.getString("TipoMedida"));
               tm.setDescripcion(rs.getString("Descripcion"));
               lstTipoMedida.add(tm);
           }
       }
       catch(SQLException e){
              System.out.println("Error al listar"+e.getMessage());  
           }
       return lstTipoMedida;
    }

    @Override
    public boolean EditarTipoMedida(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean EliminarTipoMedida(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }  

    @Override
    public boolean AgregarTipoMedida(TipoMedida tm) {
         String sql="insert into TipoMedida(TipoMedida,Descripcion) values ('"+tm.getTipoMedida()+"','"+tm.getDescripcion()+"')";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e){
            
        }
        return false;
    }
    

    @Override
    public boolean BuscarTipoMedida(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}