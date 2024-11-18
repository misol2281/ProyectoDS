package Modelo;

import Config.Conexion;
import Entidad.Cargo;
import Interfaces.CRUDCargo;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class CargoDAO implements CRUDCargo {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Cargo c = new Cargo();

    @Override
    public List listar() {
        ArrayList<Cargo>list = new ArrayList<>();
        String sql = "Select * from Cargos";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Cargo car = new Cargo();
                car.setId(rs.getInt("idCargo"));
                car.setCargo(rs.getString("Cargo"));
                list.add(car);
            }
        }catch (Exception e){
            
        }
        return list;
    }

    @Override
    public Cargo list(int id) {
        String sql = "Select * from Cargo where idCargo="+id;
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                c.setId(rs.getInt("idCargo"));
                c.setCargo(rs.getString("Cargo"));
            }
        }catch(Exception e){
            
        }
        return c;
    }

    @Override
    public boolean add(Cargo car) {
        String sql = "insert into Cargos(Cargo) values ('"+car.getCargo()+"')";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
    }

    @Override
    public boolean edit(Cargo car) {
        String sql = "update Cargos set Cargo = '"+car.getCargo()+"' where idCargo ="+car.getId();
        try{
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.executeUpdate(); 
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliinar(int id) {
       String sql = "delete from Cargos where idCargo="+id;
       try{
           con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
       }catch(Exception e){
           
       }
       return false;
    }
    
}
