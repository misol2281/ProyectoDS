<%-- 
    Document   : listarTipoTrabajo
    Created on : 3 nov 2024, 22:06:52
    Author     : Cristian
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.DAOTipoTrabajo"%>
<%@page import="Entidad.TipoTrabajo"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tipo de Trabajos</title>
        <link rel="stylesheet" href="css/estilos.css">
    </head>
    <body>
        <div>
            <h1>Tipo de Trabajos</h1>
            <table border="1">
                <thead>
                    <tr>
                        <th>Tipo Trabajo</th>
                        <th>Descripción</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        DAOTipoTrabajo dao = null;
                        List<TipoTrabajo> list = null;
                        try {
                            dao = new DAOTipoTrabajo();
                            list = dao.listarTipoTrabajos();
                            if (list == null || list.isEmpty()) {
                    %>
                                <tr>
                                    <td colspan="2">No hay datos disponibles.</td>
                                </tr>
                    <%
                            } else {
                                for (TipoTrabajo tt : list) {
                    %>
                                <tr>
                                    <td><%= tt.getTipoTrabajo() %></td>
                                    <td><%= tt.getDescripcion() %></td>
                                </tr>
                    <%
                                }
                            }
                        } catch (Exception e) {
                            out.println("<tr><td colspan='2'>Error: " + e.getMessage() + "</td></tr>");
                            e.printStackTrace();
                        }
                    %>
                </tbody>
            </table>
        </div>
    </body>
</html>
