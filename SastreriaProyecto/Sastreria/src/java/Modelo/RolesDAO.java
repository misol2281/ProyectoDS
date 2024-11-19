package Modelo;

import Config.Conexion;
import Entidad.Roles;
import Interfaces.CRUDRoles;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class RolesDAO implements CRUDRoles {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Roles r = new Roles();

    @Override
    public List listar() {
        ArrayList<Roles>list = new ArrayList<>();
        String sql = "Select * from Roles";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Roles rol = new Roles();
                rol.setId(rs.getInt("idRol"));
                rol.setRol(rs.getString("Rol"));
                list.add(rol);
            }
        }catch(Exception e){
            
        }
        return list;
    }

    @Override
    public Roles list(int id) {
        String sql = "Select * from Roles where idRol="+id;
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                r.setId(rs.getInt("idRol"));
                r.setRol(rs.getString("Rol"));
            }
        }catch (Exception e){
            
        }
        return r;
    }

    @Override
    public boolean add(Roles rol) {
        String sql = "insert into Roles(Rol) values ('"+rol.getRol()+"')";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
    }

    @Override
    public boolean edit(Roles rol) {
        String sql = "update Roles set Rol = '"+rol.getRol()+"' where idRol="+rol.getId();
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "delete from Roles where idRol="+id;
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
    }
    
}
