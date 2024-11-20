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

public class DAOEstiloRopa implements InterfaceEstiloRopa{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    EstiloRopa esr = new EstiloRopa();
    
    @Override
    public List listarEstiloRopa() {
       ArrayList<EstiloRopa> lstEstiloRopa = new ArrayList<>();
       String sql = "select * from EstiloRopa";
       try{
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               EstiloRopa er = new EstiloRopa();
               er.setId(rs.getInt("idEstiloRopa"));
               er.setEstiloRopa(rs.getString("EstiloRopa"));
               er.setDescripcion(rs.getString("Descripcion"));
               lstEstiloRopa.add(er);
           }
       }
       catch(Exception e){
              System.out.println("Error al listar"+e.getMessage());  
           }
       return lstEstiloRopa;
    }

    @Override
    public boolean AgregarEstiloRopa(EstiloRopa esr) {
       String sql="insert into EstiloRopa(EstiloRopa,Descripcion) values ('"+esr.getEstiloRopa()+"','"+esr.getDescripcion()+"')";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e){
            
        }
        return false;
    }
 

    @Override
    public boolean BuscarEstiloRopa(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    @Override
    public boolean EditarEstiloRopa(EstiloRopa esr) {
         String sql="update EstiloRopa set EstiloRopa='"+esr.getEstiloRopa()+"', Descripcion='"+esr.getDescripcion()+"'where idEstiloRopa="+esr.getId();
        con= cn.getConnection();
       
         try{
             
             ps=con.prepareStatement(sql);
            int editado= ps.executeUpdate();
            if (editado>0) {
                return true;
            }
         }catch (SQLException e){
             
             System.out.println("error al actualizar: "+e.getMessage());
         
         }
         return false;
    }

    @Override
    public boolean EliminarEstiloRopa(int id) {
         String sql = "delete from EstiloRopa where idEstiloRopa="+id;
         try{
             con = cn.getConnection();
             ps = con.prepareStatement(sql);
             ps.executeUpdate(); 
         } catch (Exception e){  
             System.out.println("error al eliminar"+e.getMessage());
         }
         return false;
    }

    @Override
    public  EstiloRopa list(int id) {
         String sql = "select * from EstiloRopa where idEstiloRopa="+id;
       try{
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               esr.setEstiloRopa(rs.getString("EstiloRopa"));
               esr.setDescripcion(rs.getString("Descripcion"));
              
           }
       }
       catch(Exception e){
              System.out.println("Error al listar"+e.getMessage());  
           }
       return esr;
    }
}

    