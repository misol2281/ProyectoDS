package Modelo;

import Config.Conexion;
import Entidad.MaterialUsar;
import Interfaces.CRUDMaterialUsar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class MaterialUsarDAO implements CRUDMaterialUsar{
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    MaterialUsar mu = new MaterialUsar();
    

    @Override
    public List listar() {
        ArrayList<MaterialUsar>list = new ArrayList<>();
        String sql = "Select mu.idMaterialUsar, Material.Material AS Material, mu.idDetalleOrden, UnidadMedida.UnidadMedida AS UnidadMedida,\n" +
                     "mu.CaracteristicasMaterial, mu.Cantidad, mu.Precio, mu.SubTotal\n" +
                     "from MaterialUsar as mu inner join Material on mu.idMaterial = Material.idMaterial\n" +
                     "inner join UnidadMedida on mu.idUnidadMedida = UnidadMedida.idUnidadMedida";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                MaterialUsar mtu = new MaterialUsar();
                mtu.setId(rs.getInt("idMaterialUsar"));                
                mtu.setMaterial(rs.getString("Material"));
                mtu.setIdDetalleOrden(rs.getInt("idDetalleOrden"));                
                mtu.setUnidadMedida(rs.getString("UnidadMedida"));
                mtu.setCaracteristicas(rs.getString("CaracteristicasMaterial"));
                mtu.setCantidad(rs.getInt("Cantidad"));
                mtu.setPrecio(rs.getFloat("Precio"));
                mtu.setSubTotal(rs.getFloat("SubTotal"));
                list.add(mtu);
            }
        }catch(Exception e){
            System.out.println("Error al mostrar" +e.getMessage());
        }
        return list;
    }

    @Override
    public MaterialUsar list(int id) {
        String sql = "select * from MaterialUsar where idMaterialUsar="+id;
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                mu.setId(rs.getInt("idMaterialUsar"));
                mu.setIdMaterial(rs.getInt("idMaterial"));
                mu.setIdDetalleOrden(rs.getInt("idDetalleOrden"));
                mu.setIdUnidadMedida(rs.getInt("idUnidadMedida"));
                mu.setCaracteristicas(rs.getString("CaracteristicasMaterial"));
                mu.setCantidad(rs.getInt("Cantidad"));
                mu.setPrecio(rs.getFloat("Precio"));
                mu.setSubTotal(rs.getFloat("SubTotal"));
                
            }
        }catch(Exception e){
            
        }
        return mu;
    }

    @Override
    public boolean add(MaterialUsar mu) {
        String sql = "insert into MaterialUsar(idMaterial, idDetalleOrden, idUnidadMedida, CaracteristicasMaterial, Cantidad, Precio, SubTotal) values ('"+mu.getIdMaterial()+"','"+mu.getIdDetalleOrden()+"','"+mu.getIdUnidadMedida()+"','"+mu.getCaracteristicas()+"','"+mu.getCantidad()+"','"+mu.getPrecio()+"','"+mu.getSubTotal()+"')";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();      
        }catch (Exception e){
            
        }
        return false;
    }

    @Override
    public boolean edit(MaterialUsar mu) {
        String sql = "update MaterialUsar set idMaterial = '"+mu.getIdMaterial()+"', idDetalleOrden = '"+mu.getIdDetalleOrden()+"', idUnidadMedida = '"+mu.getIdUnidadMedida()+"', CaracteristicasMaterial = '"+mu.getCaracteristicas()+"', Cantidad = '"+mu.getCantidad()+"', Precio = '"+mu.getPrecio()+"', SubTotal = '"+mu.getSubTotal()+"' where idMaterialUsar="+mu.getId();
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
        String sql = "delete from MaterialUsar where idMaterialUsar="+id;
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e){
            
        }
        return false;
    }
    
}
