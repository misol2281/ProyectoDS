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
        <script>
            function imprimir(){
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
        <title>ListaMaterial</title>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Lista Material</h1>
            <div class="noprint">
                <a class="btn btn-primary" href="index.jsp">Regresar a Menu</a>
                <a class="btn btn-primary" href="ControladorMaterial?accion=add">Agregar Material</a>
                <button class="btn btn-primary" onclick="javascript:window.print()" >Informe</button> 
            </div>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr class="text-center">
                        <th>MATERIAL</th>
                        <th>DESCRIPCION</th>
                        <th class="accion">ACCIONES</th>                        
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
                    <tr class="text-center">                        
                        <td><%= mat.getMaterial() %></td>
                        <td><%= mat.getDescripcion() %></td>
                        <td class="noprint">
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
