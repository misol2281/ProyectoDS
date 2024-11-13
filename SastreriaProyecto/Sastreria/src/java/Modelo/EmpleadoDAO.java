package Modelo;

import Config.Conexion;
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
        String sql = "select * from Empleado";
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
                emp.setIdCargo(rs.getInt("idCargo"));
                list.add(emp);
            }
        } catch (Exception e){
            
        }
        return list;
    }

    @Override
    public Empleados list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(Empleados emp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean edit(Empleados emp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
