<%-- 
    Document   : listarEstiloRopa
    Created on : 14 nov 2024, 10:55:08
    Author     : Eduardo Morales
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.DAOEstiloRopa"%>
<%@page import="Entidad.EstiloRopa"%>
<%@page import="java.util.Iterator"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <title>Lista Estilo Ropa</title>
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
        <button class="button btn btn-primary" onclick="javascript: window.print()">Informe</button>
        <div>
        <h1>Estilo de Ropa</h1>
        <a class ="btn btn -primary" href ="menu.jsp">Regresar a menu</a>
        <a href="CtrlEstiloRopa?accion=agregarEstiloRopa">Agregar Estilo Ropa</a>
        <button class="button btn btn-primary" onclick="javascript: window.print()">Informe</button>
        

        <table border="1">
            <thead>
                <tr>
                    <th>Estilo de Ropa</th>
                    <th>Descripcion</th>
                    <th>Acciones</th>
                </tr>
            </thead>
           
                <%
                    DAOEstiloRopa dao = new DAOEstiloRopa();
                    List<EstiloRopa> list = dao.listarEstiloRopa();
                    Iterator<EstiloRopa>iter=list.iterator();
                    EstiloRopa er=null;
                    while(iter.hasNext()){
                    er=iter.next();
                %>
                <tbody>
                         
                <tr>
                    <td><%= er.getEstiloRopa() %></td>
                    <td><%= er.getDescripcion() %></td>
                    <td>
                        <a href="CtrlEstiloRopa?accion=EditarEstiloRopa&id=<%= er.getId()%>">Editar</a>
                        <a href="CtrlEstiloRopa?accion=EliminarEstiloRopa&id=<%= er.getId()%>">Eliminar</a>
                       
                    </td>
                </tr>
                <%}%>
                         
            </tbody>
        </table>
    </body>
</html>