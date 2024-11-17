<%-- 
    Document   : listarMaterial
    Created on : 14 nov 2024, 22:23:53
    Author     : MINEDUCYT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.MaterialDAO"%>
<%@page import="Entidad.Material"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Material</title>
    </head>
    <body>
        <h1>Material</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Material</th>
                    <th>Descripcion</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    MaterialDAO dao = null;
                    List<Material> list = null;
                    try {
                        dao = new MaterialDAO();
                        list = dao.listarMaterial();
                        if (list == null || list.isEmpty()) {
                %>
                <tr>
                    <td colspan="3">No hay datos disponibles</td>
                </tr>
                <%
                        } else {
                            for (Material m : list) {
                %>
                <tr>
                    <td><%= m.getMaterial() %></td>
                    <td><%= m.getDescripcion() %></td>
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