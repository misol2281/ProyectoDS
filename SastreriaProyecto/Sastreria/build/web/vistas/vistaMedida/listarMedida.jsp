<%-- 
    Document   : listarMedida
    Created on : 14 nov 2024, 13:04:37
    Author     : Eduardo Morales
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.DAOMedida"%>
<%@page import="Entidad.Medida"%>
<%@page import="java.util.Iterator"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
        <h1>Medida</h1>
        <a href="CtrlMedida?accion=agregarMedida">Agregar Medida</a>

        <table border="1">
            <thead>
                <tr>
                    <th>Medida</th>
                    <th>Descripcion</th>
                    <th>Acciones</th>
                </tr>
            </thead>
           
                <%
                    DAOMedida dao = new DAOMedida();
                    List<Medida> list = dao.listarMedida();
                    Iterator<Medida>iter=list.iterator();
                     Medida m=null;
                    while(iter.hasNext()){
                    m=iter.next();
                %>
                <tbody>
                         
                <tr>
                    <td><%= m.getMedida() %></td>
                    <td><%= m.getDescripcion() %></td>
                    <td>
                        
                    
                    </td>
                </tr>
                <%}%>
                         
            </tbody>
        </table>
    </body>
</html>