

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Cliente"%>
<%@page import="Modelo.ClienteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Lista Clientes</title>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Lista de Clientes</h1>

            <a class="btn btn-primary" href="index.jsp">Regresar a Menu</a>
            
            <a class="btn btn-primary" href="ControladorCliente?accion=add">Agregar Cliente</a>
            <br>
            <br>    
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">NOMBRE</th>
                        <th class="text-center">APELLIDO</th>
                        <th class="text-center">TELEFONO</th>
                        <th class="text-center">ACCIONES</th>
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
                        <td class="text-center"><%= cli.getId() %></td>
                        <td class="text-center"><%= cli.getNombre() %></td>
                        <td class="text-center"><%= cli.getApellido() %></td>
                        <td class="text-center"><%= cli.getTelefono() %></td>
                        <td class="text-center">
                            <a class="btn btn-outline-primary" href="ControladorCliente?accion=editar&id=<%= cli.getId()%>">Editar</a>
                            <a class="btn btn-outline-primary" href="ControladorCliente?accion=eliminar&id=<%= cli.getId()%>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
                
              
        </div>
    </body>
</html>
