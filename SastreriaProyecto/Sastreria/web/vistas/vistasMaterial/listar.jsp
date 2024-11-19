<%@page import="java.util.Iterator"%>
<%@page import="Entidad.Material"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.MaterialDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>ListaMaterial</title>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Lista Material</h1>
            <a class="btn btn-primary" href="index.jsp">Regresar a Menu</a>
            <a class="btn btn-primary" href="ControladorMaterial?accion=add">Agregar Material</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">MATERIAL</th>
                        <th class="text-center">DESCRIPCION</th>
                        <th class="text-center">ACCIONES</th>                        
                    </tr>
                </thead>
                <%
                    MaterialDAO mdao = new MaterialDAO();
                    List<Material> list = mdao.listar();
                    Iterator<Material>iter = list.iterator();
                    Material mat = null;
                    while(iter.hasNext()){
                        mat = iter.next();                    
                %>
                <tbody>
                    <tr>                        
                        <td class="text-center"><%= mat.getMaterial() %></td>
                        <td class="text-center"><%= mat.getDescripcion() %></td>
                        <td class="text-center">
                            <a class="btn btn-outline-primary" href="ControladorMaterial?accion=editar&id=<%= mat.getId() %>">Editar</a>
                            <a class="btn btn-outline-primary" href="ControladorMaterial?accion=eliminar&id=<%= mat.getId() %>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
