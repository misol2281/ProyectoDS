package Modelo;

import Config.Conexion;
import Entidad.UnidadMedida;
import Interfaces.CRUDUnidadMedida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UnidadMedidaDAO implements CRUDUnidadMedida {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    UnidadMedida um = new UnidadMedida();

    @Override
    public List listar() {
        ArrayList<UnidadMedida>list = new ArrayList<>();
        String sql = "select * from UnidadMedida";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                UnidadMedida ume = new UnidadMedida();
                ume.setId(rs.getInt("idUnidadMedida"));
                ume.setUnidadMedida(rs.getString("UnidadMedida"));
                ume.setDescripcion(rs.getString("Descripcion"));
                list.add(ume);
            }
        }catch(Exception e){
            System.out.println("Error al mostrar la lista"+e.getMessage());
        }
        return list;
    }

    @Override
    public UnidadMedida list(int id) {
        String sql = "select * from UnidadMedida where idUnidadMedida="+id;
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){                
                um.setId(rs.getInt("idUnidadMedida"));
                um.setUnidadMedida(rs.getString("UnidadMedida"));
                um.setDescripcion(rs.getString("Descripcion"));                
            }
        }catch(Exception e){
            System.out.println("Error al mostrar"+e.getMessage());
        }
        return um;
    }

    @Override
    public boolean add(UnidadMedida umd) {
        String sql = "insert into UnidadMedida(UnidadMedida, Descripcion) values ('"+umd.getUnidadMedida()+"', '"+umd.getDescripcion()+"')";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error al agregar"+e.getMessage());
        }
        return false;
    }

    @Override
    public boolean edit(UnidadMedida umd) {
        String sql = "update UnidadMedida set UnidadMedida = '"+umd.getUnidadMedida()+"', Descripcion = '"+umd.getDescripcion()+"' where idUnidadMedida ="+umd.getId();
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error al editar"+e.getMessage());
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "delete from UnidadMedida where idUnidadMedida="+id;
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error al eliminar"+e.getMessage());
        }
        return false;
    }
    
}
