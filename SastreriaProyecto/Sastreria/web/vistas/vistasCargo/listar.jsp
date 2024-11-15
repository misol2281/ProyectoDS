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
    </head>
    <body>
        <div class="container" >
            <h1 class="text-center">Listar Cargos</h1>
            
            <a class="btn btn-primary" href="index.jsp">Regresar a Menu</a>
            <a class="btn btn-primary" href="ControladorCargo?accion=add">Agregar Cargo</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">CARGO</th>
                        <th class="text-center">ACCIONES</th>
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
                    <tr>
                        <td class="text-center"><%= car.getId() %></td>
                        <td class="text-center"><%= car.getCargo() %></td>
                        <td class="text-center">
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
