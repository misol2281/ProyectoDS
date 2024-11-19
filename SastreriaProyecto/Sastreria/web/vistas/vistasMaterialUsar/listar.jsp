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
        <title>Lista MaterialUsar</title>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Lista MaterialUsar</h1>
            
                <a class="btn btn-primary" href="index.jsp">Regresar a Menu</a>
                <a class="btn btn-primary" href="ControladorMaterialUsar?accion=add">Agregar Material</a>
                <br>
                <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        
                        <th class="text-center">Material</th>
                        <th class="text-center">IDDetalleOrden</th>
                        <th class="text-center">UnidadMedida</th>
                        <th class="text-center">Caracteristicas Material</th>
                        <th class="text-center">Cantidad</th>
                        <th class="text-center">Precio</th>
                        <th class="text-center">SubTotal</th>
                        <th class="text-center">ACCIONES</th>
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
                        
                        <td class="text-center"><%= mtu.getMaterial() %></td>
                        <td class="text-center"><%= mtu.getIdDetalleOrden() %></td>
                        <td class="text-center"><%= mtu.getUnidadMedida() %></td>
                        <td class="text-center"><%= mtu.getCaracteristicas() %></td>
                        <td class="text-center"><%= mtu.getCantidad() %></td>
                        <td class="text-center"><%= mtu.getPrecio() %></td>
                        <td class="text-center"><%= mtu.getSubTotal() %></td>
                        <td class="text-center">
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
