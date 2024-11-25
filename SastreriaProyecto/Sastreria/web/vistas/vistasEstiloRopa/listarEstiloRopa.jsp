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
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estilo de Ropa</title>
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
        <div class="container">
            <h1 class="text-center">Estilo de Ropa</h1>
        <div class="noimpr">
            <a class="btn btn-primary" href="menu.jsp">Regresar a Menu</a>            
            <a class="btn btn-primary" href="ControladorCliente?accion=add">Agregar Cliente</a>
            <button class="button btn btn-primary" onclick="javascript:window.print()">Informe</button>
        </div>
            <table class="table table-bordered">
            <thead>
                <tr class="text-center">
                    <th>Estilo de Ropa</th>
                    <th>Descripcion</th>
                    <th class="accion">Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    DAOEstiloRopa dao = null;
                    List<EstiloRopa> list = null;
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
                <tr class="text-center">
                    <td><%= er.getEstiloRopa() %></td>
                    <td><%= er.getDescripcion() %></td>
                    <td>
                        <button class="btn btn-outline-primary">Eliminar</button>
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
        </div>
    </body>
</html>
        

