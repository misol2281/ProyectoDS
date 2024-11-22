package Modelo;

import Config.Conexion;
import Entidad.Material;
import Interfaces.CRUDMaterial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAO implements CRUDMaterial {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Material m = new Material();

    @Override
    public List listar() {
        ArrayList<Material>list = new ArrayList<>();
        String sql = "Select * from Material";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Material mat = new Material();
                mat.setId(rs.getInt("idMaterial"));
                mat.setMaterial(rs.getString("Material"));
                mat.setDescripcion(rs.getString("Descripcion"));
                list.add(mat);
            }
        }catch(Exception e){
            System.out.println("Error al mostrar" +e.getMessage());
        }
        return list;
    }

    @Override
    public Material list(int id) {
        String sql = "Select * from Material where idMaterial="+id;
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                m.setId(rs.getInt("idMaterial"));
                m.setMaterial(rs.getString("Material"));
                m.setDescripcion(rs.getString("Descripcion"));
            }
        }catch(Exception e){
            System.out.println("Error al mostrar"+e.getMessage());
        }
        return m;
    }

    @Override
    public boolean add(Material mat) {
        String sql = "insert into Material(Material, Descripcion) values ('"+mat.getMaterial()+"', '"+mat.getDescripcion()+"')";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error al agregar Material" +e.getMessage());
        }
        return false;
    }

    @Override
    public boolean edit(Material mat) {
        String sql = "update Material set Material = '"+mat.getMaterial()+"', Descripcion = '"+mat.getDescripcion()+"' where idMaterial ="+mat.getId();
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
        String sql = "delete from Material where idMaterial="+id;
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
