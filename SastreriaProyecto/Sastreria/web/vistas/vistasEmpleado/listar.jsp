<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Empleados"%>
<%@page import="Modelo.EmpleadoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ListarEmpleados</title>
    </head>
    <body>
        <div>
            <h1>Lista de Empleados</h1>
            
            <a href="index.jsp">Regresar a Menu</a>
            <br> 
            
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOMBRES</th>
                        <th>APELLIDOS</th>
                        <th>DUI</th>
                        <th>FECHA NACIMIENTO</th>
                        <th>TELEFONO</th>
                        <th>GENERO</th>
                        <th>ESTADO CIVIL</th>
                        <th>CORREO</th>
                        <th>CARGO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <%
                    EmpleadoDAO edao = new EmpleadoDAO();
                    List<Empleados> list = edao.listar();
                    Iterator<Empleados>iter = list.iterator();
                    Empleados emp = null;
                    while(iter.hasNext()){
                        emp = iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td><%= emp.getId() %></td>
                        <td><%= emp.getNombre() %></td>
                        <td><%= emp.getApellido() %></td>
                        <td><%= emp.getDUI() %></td>
                        <td><%= emp.getFechaNacimiento() %></td>
                        <td><%= emp.getTelefono() %></td>
                        <td><%= emp.getGenero() %></td>
                        <td><%= emp.getEstadoCivil() %></td>
                        <td><%= emp.getCorreo() %></td>
                        <td><%= emp.getIdCargo() %></td>
                        <td>
                            <a>Editar</a>
                            <a>Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
                
            </table>
        </div>
    </body>
</html>
