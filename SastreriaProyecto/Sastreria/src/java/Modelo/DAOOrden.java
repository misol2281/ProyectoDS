/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Config.Conexion;
import Entidad.Orden;
import Interfaces.InterfaceOrden;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian
 */
public class DAOOrden implements InterfaceOrden{
    Conexion conexion = new Conexion();
    Connection con = conexion.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public List listarOrden() {
        String sql = "select \n" +
            "Cliente.Nombre as nombreCliente,\n" +
            "Cliente.Apellido as apellidoCliente,\n" +
            "Empleado.Nombre as nombreEmpleado,\n" +
            "Empleado.Apellido as apellidoEmpleado,\n" +
            "Orden.idOrden,\n" +    
            "Orden.idCliente,\n" +
            "Orden.idEmpleado,\n" +
            "Orden.FechaOrden,\n" +
            "Orden.FechaEntrega,\n" +
            "Orden.MontoTotal\n" +
            "from\n" +
            "Cliente\n" +
            "inner join\n" +
            "Orden\n" +
            "ON\n" +
            "Cliente.idCliente = Orden.idCliente\n" +
            "inner join\n" +
            "Empleado\n" +
            "ON\n" +
            "Empleado.idEmpleado = Orden.idEmpleado;";
        ArrayList<Orden> ls = new ArrayList<>();
        try{
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Orden o = new Orden();
                o.setId(rs.getInt("idOrden"));
                o.setIdCliente(rs.getInt("idCliente"));
                o.setIdEmpleado(rs.getInt("idEmpleado"));
                o.setNombreCliente(rs.getString("nombreCliente") +
                        " " + rs.getString("apellidoCliente"));
                o.setNombreEmpleado(rs.getString("nombreEmpleado") +
                        " " + rs.getString("apellidoEmpleado"));
                o.setFechaOrden(rs.getDate("FechaOrden"));
                o.setFechaEntrega(rs.getDate("FechaEntrega"));
                o.setMontoTotal(rs.getFloat("MontoTotal"));
                ls.add(o);   
            }
        }
        catch(SQLException e){
            System.out.println("Error al listar orden"+e.getMessage());
        }
        return ls;
    }

    @Override
    public boolean AgregarOrden(Orden o) {
        String sql = "insert into Orden(idCliente, idEmpleado, FechaOrden, FechaEntrega, MontoTotal)"
                + " values (?,?,?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, o.getIdCliente());
            ps.setInt(2, o.getIdEmpleado());
            ps.setDate(3, new java.sql.Date(o.getFechaOrden().getTime()));
            ps.setDate(4, new java.sql.Date(o.getFechaEntrega().getTime()));
            ps.setFloat(5,o.getMontoTotal());
            int Agregado = ps.executeUpdate();
            if(Agregado>0){
            return true;
            }
        }
        catch (Exception e){
            System.out.println("Error al insertar Orden" + e.getMessage());
        }
        return false;
        
    }

    @Override
    public Orden BuscarPorId(int id) {
        String sql = "select * from Orden where idOrden ="+ id;
        Orden o = new Orden();
        try{
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while(rs.next()){
 
                o.setIdCliente(rs.getInt("idCliente"));
                o.setIdEmpleado(rs.getInt("idEmpleado"));
                o.setFechaOrden(rs.getDate("FechaOrden"));
                o.setFechaEntrega(rs.getDate("FechaEntrega"));
                o.setMontoTotal(rs.getFloat("MontoTotal")); 
            }
        }
        catch(SQLException e){
            System.out.println("Error al buscar: "+e.getMessage());
        }
        return o;
    }

    @Override
    public boolean EditarOrden(Orden o) {
        String sql = "update Orden set idCliente= '" +o.getIdCliente() + "', idEmpleado = '"
        +o.getIdEmpleado() + "', FechaOrden = '" + o.getFechaOrden() + "', FechaEntrega = '"
        + o.getFechaEntrega() + "', MontoTotal= '" + o.getMontoTotal() +"' where idOrden= "+o.getId();
        try{
            ps = con.prepareStatement(sql);
            int Editado = ps.executeUpdate();
            if(Editado>0){
            return true;
            }
        }
        catch(Exception e){
            System.out.println("Error al actualizar" + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean EliminarOrden(int id) {
        String sql = "delete from Orden where idOrden =" + id;
        try{
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("Error al eliminar" + e.getMessage());
            }
        return false;
        
    }
    
}
