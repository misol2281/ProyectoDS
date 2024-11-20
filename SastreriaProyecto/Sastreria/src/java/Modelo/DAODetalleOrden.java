/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Entidad.DetalleOrden;
import Interfaces.InterfaceDetalleOrden;
import java.util.List;
import Config.Conexion;
import java.sql.*;
import java.util.ArrayList;

public class DAODetalleOrden implements InterfaceDetalleOrden {
    Conexion conexion = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public List<DetalleOrden> listarDetOrden() {
        String sql = "select \n" +
        "EstiloRopa.EstiloRopa as EstiloRopa,\n" +
        "TipoTrabajo.TipoTrabajo as TipoTrabajo,\n" +
        "DetalleOrden.idDetalleOrden,\n" +
        "DetalleOrden.idEstiloRopa,\n" +
        "DetalleOrden.idTipoTrabajo,\n" +
        "DetalleOrden.idOrden,\n" +
        "DetalleOrden.Instrucciones,\n" +
        "DetalleOrden.SubTotal\n" +
        "from\n" +
        "DetalleOrden\n" +
        "inner join\n" +
        "EstiloRopa\n" +
        "on\n" +
        "EstiloRopa.idEstiloRopa = DetalleOrden.idEstiloRopa\n" +
        "inner join\n" +
        "TipoTrabajo\n" +
        "on\n" +
        "TipoTrabajo.idTipoTrabajo = DetalleOrden.idTipoTrabajo;";
        List<DetalleOrden> ls = new ArrayList<>();
        DetalleOrden dO = new DetalleOrden();
        try{
            con = conexion.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                DetalleOrden d = new DetalleOrden();
                d.setIdEstiloRopa(rs.getInt("idEstiloRopa"));
                d.setIdTipoTrabajo(rs.getInt("idTipoTrabajo"));
                d.setEstiloRopa(rs.getString("EstiloRopa"));
                d.setTipoTrabajo(rs.getString("TipoTrabajo"));
                d.setIdOrden(rs.getInt("idOrden"));
                d.setInstrucciones(rs.getString("Instrucciones"));
                d.setSubTotal(rs.getFloat("SubTotal"));
                ls.add(d);
            }
        }catch(SQLException e){
            System.out.println("Error al listar"+e.getMessage());
        }
        return ls;
    }

    @Override
    public boolean agregarDetOrden(DetalleOrden dO) {
        String sql = "insert into DetalleOrden (idEstiloRopa, idTipoTrabajo, idOrden, Instrucciones,"
        + "SubTotal) into(?,?,?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, dO.getIdEstiloRopa());
            ps.setInt(2, dO.getIdTipoTrabajo());
            ps.setInt(3, dO.getIdOrden());
            ps.setString(4, dO.getInstrucciones());
            ps.setFloat(5, dO.getSubTotal());
            int agregado = ps.executeUpdate();
            if(agregado>0){
                System.out.println("Se agrego con exito");
                return true;
            }
        }
        catch(SQLException e){
            System.out.println("Error al agregar Detalle Orden "+e.getMessage());
        }
        return false;
    }

    @Override
    public boolean buscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarDetOrden(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizarDetOrden(DetalleOrden dO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
