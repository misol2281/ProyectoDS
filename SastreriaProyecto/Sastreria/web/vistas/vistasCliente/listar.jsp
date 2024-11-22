<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Cliente"%>
<%@page import="Modelo.ClienteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Lista Clientes</title>
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
            <h1 class="text-center">Lista de Clientes</h1>
            <div class="noimpr">
            <a class="btn btn-primary" href="menu.jsp">Regresar a Menu</a>            
            <a class="btn btn-primary" href="ControladorCliente?accion=add">Agregar Cliente</a>
            <button class="button btn btn-primary" onclick="javascript:window.print()">Informe</button>
            </div>
            <br>
            <br>    
            <table class="table table-bordered">
                <thead>
                    <tr class="text-center">
                        
                        <th>NOMBRE</th>
                        <th>APELLIDO</th>
                        <th>TELEFONO</th>
                        <th class="accion">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    ClienteDAO cdao = new ClienteDAO();
                    List<Cliente> list = cdao.listar();
                    Iterator<Cliente>iter = list.iterator();
                    Cliente cli = null;
                    while(iter.hasNext()){
                        cli = iter.next();
                    
                %>
                <tbody>
                    <tr class="text-center">
                        
                        <td><%= cli.getNombre() %></td>
                        <td><%= cli.getApellido() %></td>
                        <td><%= cli.getTelefono() %></td>
                        <td class="noimprimir">
                            <a class="btn btn-outline-primary" href="ControladorCliente?accion=editar&id=<%= cli.getId()%>">Editar</a>
                            <a class="btn btn-outline-primary" href="ControladorCliente?accion=eliminar&id=<%= cli.getId()%>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
                
              
        </div>
    </body>
</html>
