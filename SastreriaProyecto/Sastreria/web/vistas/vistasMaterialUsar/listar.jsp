

<%@page import="java.util.Iterator"%>
<%@page import="Entidad.MaterialUsar"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.MaterialUsarDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista MaterialUsar</title>
    </head>
    <body>
        <div>
            <h1>Lista MaterialUsar</h1>
            
                <a href="index.jsp">Regresar a Menu</a>
                <a href="ControladorMaterialUsar?accion=add">Agregar Material</a>
                <br>
            
            <table border="1">
                <thead>
                    <tr>
                        <th>IDMaterialUsar</th>
                        <th>IDMaterial</th>
                        <th>IDDetalleOrden</th>
                        <th>IDUnidadMedida</th>
                        <th>Caracteristicas Material</th>
                        <th>Cantidad</th>
                        <th>Precio</th>
                        <th>SubTotal</th>
                        <th>ACCIONES</th>
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
                    <tr>
                        <td><%= mtu.getId() %></td>
                        <td><%= mtu.getIdMaterial() %></td>
                        <td><%= mtu.getIdDetalleOrden() %></td>
                        <td><%= mtu.getIdUnidadMedida() %></td>
                        <td><%= mtu.getCaracteristicas() %></td>
                        <td><%= mtu.getCantidad() %></td>
                        <td><%= mtu.getPrecio() %></td>
                        <td><%= mtu.getSubTotal() %></td>
                        <td>
                            <a href="ControladorMaterialUsar?accion=editar&id=<%= mtu.getId() %>">Editar</a>
                            <a href="ControladorMaterialUsar?accion=eliminar&id=<%= mtu.getId() %>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
