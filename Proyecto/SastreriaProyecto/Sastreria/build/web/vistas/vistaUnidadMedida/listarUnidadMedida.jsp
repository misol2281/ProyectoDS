<%-- 
    Document   : listarUnidadMedida
    Created on : 14 nov 2024, 22:47:57
    Author     : MINEDUCYT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.DAOUnidadMedida"%>
<%@page import="Entidad.UnidadMedida"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UnidadMedida</title>
    </head>
    <body>
        <h1>UnidadMedida</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>UnidadMedida</th>
                    <th>Descripcion</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    DAOUnidadMedida dao = null;
                    List<UnidadMedida> list = null;
                    try {
                        dao = new DAOUnidadMedida();
                        list = dao.listarUnidadMedida();
                        if (list == null || list.isEmpty()) {
                %>
                <tr>
                    <td colspan="3">No hay datos disponibles</td>
                </tr>
                <%
                        } else {
                            for (UnidadMedida um : list) {
                %>
                <tr>
                    <td><%= um.getUnidadMedida() %></td>
                    <td><%= um.getDescripcion() %></td>
                    <td>
                        <button>Eliminar</button>
                    </td>
                </tr>
                <%
                            }
                        }
                    } catch (Exception e) {
                        out.println("<tr><td colspan='3'>Error: " + e.getMessage() + "</td></tr>");
                        e.printStackTrace();
                    }
                %>
            </tbody>
        </table>
    </body>
</html>