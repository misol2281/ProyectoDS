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
    DAOOrden dao = new DAOOrden();
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public List listarOrden() {
        String sql = "select \n" +
            "Cliente.Nombre as nombreCliente,\n" +
            "Cliente.Apellido as apellidoCliente,\n" +
            "Empleado.Nombre as nombreEmpleado,\n" +
            "Empleado.Apellido as apellidoEmpleado,\n" +
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
        catch(Exception e){
            System.out.println("Error al registrar orden"+e.getMessage());
        }
        return ls;
    }

    @Override
    public boolean AgregarOrden(Orden o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Orden BuscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean EditarOrden(Orden o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean EliminarOrden(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
