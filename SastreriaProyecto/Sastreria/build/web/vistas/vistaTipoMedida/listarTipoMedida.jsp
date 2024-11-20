<%-- 
    Document   : listarTipoMedida
    Created on : 15 nov 2024, 18:17:44
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
    </head>
    <body>
        <div>
        <h1>Tipo de Medida</h1>
        <a href="CtrlTipoMedida?accion=agregarTipoMedida">Agregar Tipo de Medida</a>

        <table border="1">
            <thead>
                <tr>
                    <th>Tipo de Medida</th>
                    <th>Descripcion</th>
                    <th>Acciones</th>
                </tr>
            </thead>
           
                <%
                    DAOTipoMedida dao = new DAOTipoMedida();
                    List<TipoMedida> list = dao.listarTipoMedida();
                    Iterator<TipoMedida>iter=list.iterator();
                    TipoMedida tm=null;
                    while(iter.hasNext()){
                    tm=iter.next();
                %>
                <tbody>
                         
                <tr>
                    <td><%= tm.getTipoMedida() %></td>
                    <td><%= tm.getDescripcion() %></td>
                    <td>
                        
                       
                    </td>
                </tr>
                <%}%>
                         
            </tbody>
        </table>
    </body>
</html>