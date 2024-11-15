

<%@page import="java.util.Iterator"%>
<%@page import="Entidad.Roles"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.RolesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ListarRoles</title>
    </head>
    <body>
        <div>
            <h1>Lista de Roles</h1>
            
            <a href="index.jsp">Regresar a Menu</a>
            <a href="ControladorRoles?accion=add">Agregar Roles</a>
            <br>
            
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>ROLES</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <%
                    RolesDAO rdao = new RolesDAO();
                    List<Roles> list = rdao.listar();
                    Iterator<Roles>iter = list.iterator();
                    Roles rol = null;
                    while(iter.hasNext()){
                        rol = iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td><%= rol.getId() %></td>
                        <td><%= rol.getRol() %></td>
                        <td>
                            <a href="ControladorRoles?accion=editar&id=<%= rol.getId() %>">Editar</a>
                            <a href="ControladorRoles?accion=eliminar&id=<%= rol.getId() %>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
