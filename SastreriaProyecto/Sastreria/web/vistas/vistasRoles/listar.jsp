

<%@page import="java.util.Iterator"%>
<%@page import="Entidad.Roles"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.RolesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>ListarRoles</title>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Lista de Roles</h1>
            
            <a class="btn btn-primary" href="index.jsp">Regresar a Menu</a>
            <a class="btn btn-primary" href="ControladorRoles?accion=add">Agregar Roles</a>
            <br>
            <br>
            
            <table class="table table-bordered">
                <thead>
                    <tr>
                        
                        <th class="text-center">ROLES</th>
                        <th class="text-center">ACCIONES</th>
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
                        
                        <td class="text-center"><%= rol.getRol() %></td>
                        <td class="text-center">
                            <a class="btn btn-outline-primary" href="ControladorRoles?accion=editar&id=<%= rol.getId() %>">Editar</a>
                            <a class="btn btn-outline-primary" href="ControladorRoles?accion=eliminar&id=<%= rol.getId() %>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
