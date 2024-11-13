/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Config.Conexion;
import Entidad.TipoTrabajo;
import Interfaces.InterfaceTipoTrabajo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Cristian
 */
public class DAOTipoTrabajo implements InterfaceTipoTrabajo{
    Conexion conexion = new Conexion();
    Connection con = conexion.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public List listarTipoTrabajos() {
        String sql = "select * from TipoTrabajo";
        ArrayList<TipoTrabajo> lstTipoTrabajo = new ArrayList<>();
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                TipoTrabajo tt = new TipoTrabajo();
                tt.setTipoTrabajo(rs.getString("TipoTrabajo"));
                tt.setDescripcion(rs.getString("Descripcion"));
                lstTipoTrabajo.add(tt);
            }
        }
        catch (SQLException e){
            System.out.println("Error al listar"+e.getMessage());
        }
        return lstTipoTrabajo;
    }

    @Override
    public boolean AgregarTipoTrabajo(TipoTrabajo Tt) {
        String sql = "insert into TipoTrabajo(TipoTrabajo, Descripcion) values (?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, Tt.getTipoTrabajo());
            ps.setString(2, Tt.getDescripcion());
            int Agregado = ps.executeUpdate();
            if(Agregado>0){
            return true;
            }
        }
        catch (Exception e){
            System.out.println("Error al insertar TipoTrabajo" + e.getMessage());
        }
        return false;
        
    }

    @Override
    public boolean BuscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean EditarTipoTrabajo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean EliminarTipoTrabajo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
