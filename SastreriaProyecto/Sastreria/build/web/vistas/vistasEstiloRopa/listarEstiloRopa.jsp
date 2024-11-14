<%-- 
    Document   : listarEstiloRopa
    Created on : 8 nov 2024, 19:30:26
    Author     : Eduardo Morales
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.DAOEstiloRopa"%>
<%@page import="Entidad.EstiloRopa"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estilo de Ropa</title>
    </head>
    <body>
        <h1>Estilo de Ropa</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Estilo de Ropa</th>
                    <th>Descripcion</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    DAOEstiloRopa dao = null;
                    List<Estilo de Ropa> list = null;
                    try {
                        dao = new DAOEstiloRopa();
                        list = dao.listarEstiloRopa();
                        if (list == null || list.isEmpty()) {
                %>
                <tr>
                    <td colspan="3">No hay datos disponibles</td>
                </tr>
                <%
                        } else {
                            for (EstiloRopa er : list) {
                %>
                <tr>
                    <td><%= m.getEstiloRopa() %></td>
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