<%@page import="java.util.Iterator"%>
<%@page import="Entidad.UnidadMedida"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.UnidadMedidaDAO"%>
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
        <title>ListaUnidadMedida</title>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Lista Unidad de Medida</h1>
            <div class="noprint">
            <a class="btn btn-primary" href="index.jsp">Regresar al Menu</a>
            <a class="btn btn-primary" href="ControladorUnidadMedida?accion=add">Agregar Unidad de Medida</a>
            <button class="btn btn-primary" onclick="javascript:window.print()">Informe</button>
            </div>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr class="text-center">
                        <th>UNIDAD MEDIDA</th>
                        <th>DESCRIPCION</th>
                        <th class="accion">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    UnidadMedidaDAO umdao = new UnidadMedidaDAO();
                    List<UnidadMedida> list = umdao.listar();
                    Iterator<UnidadMedida>iter = list.iterator();
                    UnidadMedida um = null;
                    while(iter.hasNext()){
                        um = iter.next();                    
                %>
                <tbody>
                    <tr class="text-center">
                        <td><%= um.getUnidadMedida() %></td>
                        <td><%= um.getDescripcion() %></td>
                        <td class="noprint">
                            <a class="btn btn-outline-primary" href="ControladorUnidadMedida?accion=editar&id=<%= um.getId() %>">Editar</a>
                            <a class="btn btn-outline-primary" href="ControladorUnidadMedida?accion=eliminar&id=<%= um.getId() %>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
