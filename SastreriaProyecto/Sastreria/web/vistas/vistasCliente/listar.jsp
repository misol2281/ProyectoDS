

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Cliente"%>
<%@page import="Modelo.ClienteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Clientes</title>
    </head>
    <body>
        <div>
            <h1>Lista de Clientes</h1>

                <a href="index.jsp">Regresar a Menu</a>
                <a href="ControladorCliente?accion=add">Agregar Cliente</a>
                <br>
                
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOMBRE</th>
                        <th>APELLIDO</th>
                        <th>TELEFONO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <%
                    ClienteDAO cdao = new ClienteDAO();
                    List<Cliente> list = cdao.listar();
                    Iterator<Cliente>iter = list.iterator();
                    Cliente cli = null;
                    while(iter.hasNext()){
                        cli = iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td><%= cli.getId() %></td>
                        <td><%= cli.getNombre() %></td>
                        <td><%= cli.getApellido() %></td>
                        <td><%= cli.getTelefono() %></td>
                        <td>
                            <a href="ControladorCliente?accion=editar&id=<%= cli.getId()%>">Editar</a>
                            <a href="ControladorCliente?accion=eliminar&id=<%= cli.getId()%>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
                
              
        </div>
    </body>
</html>
