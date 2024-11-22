<%-- 
    Document   : listarUsuario
    Created on : 21 nov 2024, 11:57:50
    Author     : Eduardo Morales
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.DAOUsuario"%>
<%@page import="Entidad.Usuario"%>
<%@page import="java.util.Iterator"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Usuario</title>
        <script>
            function imprimir(){
                window.print();
                
            }
        </script>
        <style>
            @media print{
                .noimpr, .accion, .noimprimir{
                    display:none;
                }
            }
            
        </style>
        
    </head>
    <body>
        
        <div>
        <h1>Usuario</h1>
        <a href="CtrlUsuario?accion=agregarUsuario">Agregar Usuario</a>
        <button class="button btn btn-primary" onclick="javascript: window.print()">Informe</button>
        

        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Usuario</th>
                    <th>Contraseña</th>
                    <th>id Rol</th>
                    <th>idEmpleado</th>
                    <th>Acciones</th>
                </tr>
            </thead>
           
                <%
                    DAOUsuario dao = new DAOUsuario();
                    List<Usuario> list = dao.listarUsuario();
                    Iterator<Usuario>iter=list.iterator();
                    Usuario u=null;
                    while(iter.hasNext()){
                    u=iter.next();
                %>
                <tbody>
                         
                <tr>
                    <td><%= u.getIdUsuario() %></td>
                    <td><%= u.getusuario() %></td>
                    <td><%= u.getcontrasenia() %></td>
                    <td><%= u.getidRol() %></td>
                    <td><%= u.getidEmpleado() %></td>
                    <td>
                        
                        <a href="CtrlUsuario?accion=EditarUsuario&id=<%= u.getId()%>">Editar</a>
                        <a href="CtrlUsuario?accion=EliminarUsuario&id=<%= u.getId()%>">Eliminar</a>
                       
                    </td>
                </tr>
                <%}%>
                         
            </tbody>
        </table>
    </body>
</html>
