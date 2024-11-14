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
        <link rel="stylesheet" href="css/estiloListar.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    </head>
    <body>
        <div>
            <h1>Tipo de Trabajos</h1>
            <button id="abrirAgregar">Agregar Registro</button>
            <table border="1">
                <thead>
                    <tr>
                        <th>Tipo Trabajo</th>
                        <th>Descripción</th>
                        <th>Acciones</th>
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
                                    <td>
                                    <button class="btn-acciones eliminar" onclick="confirmarBorrar('<%= tt.getTipoTrabajo() %>')">
                                    <i class="fas fa-trash-alt" id="eliminar"></i> Eliminar
                                    </button>
                                    <button class="btn-acciones modificar" onclick="editItem()">
                                    <i class="fas fa-edit"></i> Modificar
                                    </button>
                                    </td>
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
    <script src="script/scriptTipoTrabajo/TipoTrabajo.js"></script>
   </html>
