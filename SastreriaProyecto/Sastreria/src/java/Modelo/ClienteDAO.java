
package Modelo;

import Config.Conexion;
import Entidad.Cliente;
import Interfaces.CRUDCliente;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteDAO implements CRUDCliente{

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Cliente c = new Cliente();
    
    
    @Override
    public List listar() {
        ArrayList<Cliente>list = new ArrayList<>();
        String sql = "select * from Cliente";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Cliente cli = new Cliente();
                cli.setId(rs.getInt("idCliente"));
                cli.setNombre(rs.getString("Nombre"));
                cli.setApellido(rs.getString("Apellido"));
                cli.setTelefono(rs.getString("Telefono"));
                list.add(cli);
            }
        }catch(Exception e){
            
        }
        return list;
    }

    @Override
    public Cliente list(int id) {
        String sql="Select * from Cliente where idCliente="+id;
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                c.setId(rs.getInt("idCliente"));
                c.setNombre(rs.getString("Nombre"));
                c.setApellido(rs.getString("Apellido"));
                c.setTelefono(rs.getString("Telefono"));
            }
        } catch(Exception e){
            
        }
        return c;
    }

    @Override
    public boolean add(Cliente cli) {
        String sql="insert into Cliente(Nombre, Apellido, Telefono) values ('"+cli.getNombre()+"','"+cli.getApellido()+"','"+cli.getTelefono()+"')";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e){
            
        }
        return false;
    }

    @Override
    public boolean edit(Cliente cli) {
        String sql="update Cliente set Nombre = '"+cli.getNombre()+"', Apellido = '"+cli.getApellido()+"', Telefono = '"+cli.getTelefono()+"' where idCliente ="+cli.getId();
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch(Exception e){
            
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql= "delete from Cliente where idCliente="+id;
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch(Exception e){
            
        }
        return false;
    }
    
}
