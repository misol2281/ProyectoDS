<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Empleados"%>
<%@page import="Modelo.EmpleadoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>ListarEmpleados</title>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Lista de Empleados</h1>
            
            <a class="btn btn-primary" href="index.jsp">Regresar a Menu</a>
            <a class="btn btn-primary" href="ControladorEmpleado?accion=add">Agregar Empleado</a>
            <br> 
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        
                        <th class="text-center">NOMBRES</th>
                        <th class="text-center">APELLIDOS</th>
                        <th class="text-center">DUI</th>
                        <th class="text-center">FECHA NACIMIENTO</th>
                        <th class="text-center">TELEFONO</th>
                        <th class="text-center">GENERO</th>
                        <th class="text-center">ESTADO CIVIL</th>
                        <th class="text-center">CORREO</th>
                        <th class="text-center">CARGO</th>
                        <th class="text-center">ACCIONES</th>
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
                        
                        <td class="text-center"><%= emp.getNombre() %></td>
                        <td class="text-center"><%= emp.getApellido() %></td>
                        <td class="text-center"><%= emp.getDUI() %></td>
                        <td class="text-center"><%= emp.getFechaNacimiento() %></td>
                        <td class="text-center"><%= emp.getTelefono() %></td>
                        <td class="text-center"><%= emp.getGenero() %></td>
                        <td class="text-center"><%= emp.getEstadoCivil() %></td>
                        <td class="text-center"><%= emp.getCorreo() %></td>
                        <td class="text-center"><%= emp.getIdCargo() %></td>
                        <td class="text-center">
                            <div class="col-10">
                                <a class="btn btn-outline-primary" href="ControladorEmpleado?accion=editar&id=<%= emp.getId() %>">Editar</a>
                                <a class="btn btn-outline-primary" href="ControladorEmpleado?accion=eliminar&id=<%= emp.getId() %>">Eliminar</a>
                            </div>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
                
            </table>
        </div>
    </body>
</html>
