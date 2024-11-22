<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Cargo"%>
<%@page import="Modelo.CargoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>ListarCargos</title>
        <script>
            function imprimir(){
                window.print();
            }
        </script>
        <style>
            @media print{
                .noimpp, .accion, .noimp{
                    display:none;
                }
            }
        </style>
    </head>
    <body>
        <div class="container" >
            <h1 class="text-center">Lista de Cargos</h1>
            <div class="noimpp">
                <a class="btn btn-primary" href="menu.jsp">Regresar a Menu</a>
                <a class="btn btn-primary" href="ControladorCargo?accion=add">Agregar Cargo</a>
                <button class="btn btn-primary" onclick="javascript:window.print()">Informe</button>
            </div>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr class="text-center">                        
                        <th>CARGO</th>
                        <th class="accion">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    CargoDAO cdao = new CargoDAO();
                    List<Cargo> list = cdao.listar();
                    Iterator<Cargo>iter = list.iterator();
                    Cargo car = null;
                    while(iter.hasNext()){
                    car = iter.next();
                    
                %>
                <tbody>
                    <tr class="text-center">                   
                        <td><%= car.getCargo() %></td>
                        <td class="noimp">
                            <a class="btn btn-outline-primary" href="ControladorCargo?accion=editar&id=<%= car.getId() %>">Editar</a>
                            <a class="btn btn-outline-primary" href="ControladorCargo?accion=eliminar&id=<%= car.getId() %>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
