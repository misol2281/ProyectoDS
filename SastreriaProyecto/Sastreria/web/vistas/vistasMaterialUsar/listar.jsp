<%@page import="java.util.Iterator"%>
<%@page import="Entidad.MaterialUsar"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.MaterialUsarDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script>
            function imprimir{
                window.print();
            }
        </script>
        <style>
            @media print{
                .accion, .noprint{
                    display:none;
                }
            }
        </style>
        <title>Lista MaterialUsar</title>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Lista MaterialUsar</h1>
            <div class="noprint">
                <a class="btn btn-primary" href="menu.jsp">Regresar a Menu</a>
                <a class="btn btn-primary"  href="ControladorMaterialUsar?accion=add">Agregar Material</a>
                <button class="btn btn-primary" onclick="javascript:window.print()">Informe</button>
            </div>
                <br>
                <br>
            <table class="table table-bordered">
                <thead>
                    <tr class="text-center">                        
                        <th>Material</th>
                        <th>IDDetalleOrden</th>
                        <th>UnidadMedida</th>
                        <th>Caracteristicas Material</th>
                        <th>Cantidad</th>
                        <th>Precio</th>
                        <th>SubTotal</th>
                        <th class="accion">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    MaterialUsarDAO mudao = new MaterialUsarDAO();
                    List<MaterialUsar> list = mudao.listar();
                    Iterator<MaterialUsar>iter = list.iterator();
                    MaterialUsar mtu = null;
                    while(iter.hasNext()){
                        mtu = iter.next();    
                %>
                <tbody>
                    <tr class="text-center">                        
                        <td><%= mtu.getMaterial() %></td>
                        <td><%= mtu.getIdDetalleOrden() %></td>
                        <td><%= mtu.getUnidadMedida() %></td>
                        <td><%= mtu.getCaracteristicas() %></td>
                        <td><%= mtu.getCantidad() %></td>
                        <td><%= mtu.getPrecio() %></td>
                        <td><%= mtu.getSubTotal() %></td>
                        <td class="noprint">
                            <a class="btn btn-outline-primary" href="ControladorMaterialUsar?accion=editar&id=<%= mtu.getId() %>">Editar</a>
                            <a class="btn btn-outline-primary" href="ControladorMaterialUsar?accion=eliminar&id=<%= mtu.getId() %>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
