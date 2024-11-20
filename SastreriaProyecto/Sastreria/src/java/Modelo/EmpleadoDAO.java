package Modelo;

import Config.Conexion;
import Entidad.Cargo;
import Entidad.Empleados;
import Interfaces.CRUDEmpleado;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.List;


public class EmpleadoDAO implements CRUDEmpleado {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Empleados e = new Empleados();

    @Override
    public List listar() {
        ArrayList<Empleados>list = new ArrayList<>();
        String sql = "select Empleado.idEmpleado, Empleado.Nombre, Empleado.Apellido, Empleado.dui,\n" +
                    "Empleado.FechaNacimiento, Empleado.Telefono, \n" +
                    "Empleado.Genero, Empleado.EstadoCivil, Empleado.Correo,\n" +
                    "Cargos.Cargo AS Cargo \n" +
                    "from Empleado inner join Cargos\n" +
                    "on Empleado.idCargo = Cargos.idCargo;";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Empleados emp = new Empleados();
                emp.setId(rs.getInt("idEmpleado"));
                emp.setNombre(rs.getString("Nombre"));
                emp.setApellido(rs.getString("Apellido"));
                emp.setDUI(rs.getString("dui"));
                emp.setFechaNacimiento(rs.getDate("FechaNacimiento"));
                emp.setTelefono(rs.getString("Telefono"));
                emp.setGenero(rs.getString("Genero").charAt(0));
                emp.setEstadoCivil(rs.getString("EstadoCivil"));
                emp.setCorreo(rs.getString("Correo"));
                emp.setCargo(rs.getString("Cargo"));
                list.add(emp);
            }
        } catch (Exception e){
            System.out.println("Error al mostrar"+e.getMessage());
        }
        return list;
    }

    @Override
    public Empleados list(int id) {
        String sql = "select * from Empleado where idEmpleado="+id;
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                e.setId(rs.getInt("idEmpleado"));
                e.setNombre(rs.getString("Nombre"));
                e.setApellido(rs.getString("Apellido"));
                e.setDUI(rs.getString("dui"));
                e.setFechaNacimiento(rs.getDate("FechaNacimiento"));
                e.setTelefono(rs.getString("Telefono"));
                e.setGenero(rs.getString("Genero").charAt(0));
                e.setEstadoCivil(rs.getString("EstadoCivil"));
                e.setCorreo(rs.getString("Correo"));
                e.setIdCargo(rs.getInt("idCargo"));
            }
        }catch(Exception e){
            
        }
        return e;     
    }

    @Override
    public boolean add(Empleados emp) {
       String sql = "insert into Empleado(Nombre, Apellido, dui, FechaNacimiento, Telefono, Genero, EstadoCivil, Correo, idCargo) values ('"+emp.getNombre()+"', '"+emp.getApellido()+"', '"+emp.getDUI()+"', '"+emp.getFechaNacimiento()+"', '"+emp.getTelefono()+"', '"+emp.getGenero()+"', '"+emp.getEstadoCivil()+"', '"+emp.getCorreo()+"', '"+emp.getIdCargo()+"')"; 
       try{
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.executeUpdate();
       }catch (Exception e){
            System.out.println("Error al insertar en la base de datos: " + e.getMessage());
       }
       return false;
    }

    @Override
    public boolean edit(Empleados emp) {
       String sql = "update Empleado set Nombre = '"+emp.getNombre()+"', Apellido = '"+emp.getApellido()+"', dui = '"+emp.getDUI()+"', FechaNacimiento = '"+emp.getFechaNacimiento()+"', Telefono = '"+emp.getTelefono()+"', Genero = '"+emp.getGenero()+"', EstadoCivil = '"+emp.getEstadoCivil()+"', Correo = '"+emp.getCorreo()+"', idCargo = '"+emp.getIdCargo()+"' where idEmpleado="+emp.getId();
       try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch(Exception e){
            System.out.println("Error al actualizar en la base de datos: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "delete from Empleado where idEmpleado="+id;
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch(Exception e){
            
        }
        return false;
    }
    
}
