<%-- 
    Document   : ListarOrden
    Created on : 16 nov 2024, 14:56:45
    Author     : Cristian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.DAOOrden"%>
<%@page import="Entidad.Orden"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/Sastreria/css/estiloListar.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <title>Ordenes</title>
    </head>
    <body>
        <div>
            <h1>Ordenes</h1>
            <button id="abrirAgregar">Agregar Registro</button>
            <table border="1">
                <thead>
                    <tr>
                        <th>Cliente</th>
                        <th>Empleado</th>
                        <th>Fecha Orden</th>
                        <th>Fecha Entrega</th>
                        <th>Monto total</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                   <%
                        DAOOrden dao = null;
                        List<Orden> list = null;
                        try {
                            dao = new DAOOrden();
                            list = dao.listarOrden();
                            if (list == null || list.isEmpty()) {
                    %>
                                <tr>
                                    <td colspan="5">No hay datos disponibles.</td>
                                </tr>
                    <%
                            } else {
                                for (Orden o : list) {
                    %>
                                <tr>
                                    <td><%= o.getNombreCliente() %></td>
                                    <td><%= o.getNombreEmpleado() %></td>
                                    <td><%= o.getFechaOrden() %></td>
                                    <td><%= o.getFechaEntrega() %></td>
                                    <td><%= o.getMontoTotal() %></td>
                                    <td>
                                    <button class="btn-acciones eliminar" onclick="confirmarBorrar('<%= o.getId()%>')">
                                    <i class="fas fa-trash-alt" id="eliminar"></i> Eliminar
                                    </button>
                                    <button class="btn-acciones modificar" onclick="editarRegistro('<%= o.getId()%>')">
                                    <i class="fas fa-edit"></i> Modificar
                                    </button>
                                    </td>
                                </tr>
                    <%
                                }
                            }
                        } catch (Exception e) {
                            out.println("<tr><td colspan='5'>Error: " + e.getMessage() + "</td></tr>");
                            e.printStackTrace();
                        }
                    %>
                </tbody>
            </table>
        </div>
    </body>
    <script src="/Sastreria/script/scriptOrden/Orden.js"></script>
   </html>
