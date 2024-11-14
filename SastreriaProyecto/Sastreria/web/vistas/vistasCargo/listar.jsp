<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Cargo"%>
<%@page import="Modelo.CargoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ListarCargos</title>
    </head>
    <body>
        <div>
            <h1>Listar Cargos</h1>
            
            <a href="index.jsp">Regresar a Menu</a>
            <a href="ControladorCargo?accion=add">Agregar Cargo</a>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>CARGO</th>
                        <th>ACCIONES</th>
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
                        <td><%= car.getId() %></td>
                        <td><%= car.getCargo() %></td>
                        <td>
                            <a href="ControladorCargo?accion=editar&id=<%= car.getId() %>">Editar</a>
                            <a href="ControladorCargo?accion=eliminar&id=<%= car.getId() %>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
