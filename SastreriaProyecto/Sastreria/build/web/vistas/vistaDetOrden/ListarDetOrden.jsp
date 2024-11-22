<%-- 
    Document   : ListarOrden
    Created on : 16 nov 2024, 14:56:45
    Author     : Cristian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.DAODetalleOrden"%>
<%@page import="Entidad.DetalleOrden"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/Sastreria/css/estiloListar.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <title>Detalles Orden</title>
    </head>
    <body>
        <div>
            <h1>Detalles Orden</h1>
            <button id="abrirAgregar" onclick="redirigir()">Agregar Registro</button>
            <table border="1">
                <thead>
                    <tr>
                        <th>Estilo Ropa</th>
                        <th>Tipo Trabajo</th>
                        <th>Orden</th>
                        <th>Instrucciones</th>
                        <th>Sub total</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                   <%
                        DAODetalleOrden dao = null;
                        List<DetalleOrden> list = null;
                        try {
                            dao = new DAODetalleOrden();
                            list = dao.listarDetOrden();
                            if (list == null || list.isEmpty()) {
                    %>
                                <tr>
                                    <td colspan="6">No hay datos disponibles.</td>
                                </tr>
                    <%
                            } else {
                                for (DetalleOrden dO : list) {
                    %>
                                <tr>
                                    <td><%= dO.getEstiloRopa() %></td>
                                    <td><%= dO.getTipoTrabajo() %></td>
                                    <td><%= dO.getIdOrden() %></td>
                                    <td><%= dO.getInstrucciones() %></td>
                                    <td><%= dO.getSubTotal() %></td>
                                    <td>
                                    <button class="btn-acciones eliminar" onclick="confirmarBorrar('<%= dO.getId()%>')">
                                    <i class="fas fa-trash-alt" id="eliminar"></i> Eliminar
                                    </button>
                                    <button class="btn-acciones modificar" onclick="editarRegistro('<%= dO.getId()%>')">
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
    <script src="/Sastreria/script/scriptDetOrden/AgregarDetOrden.js"></script>
   </html>
