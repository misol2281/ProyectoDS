<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Empleados"%>
<%@page import="Modelo.EmpleadoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>ListarEmpleados</title>
        <script>
            function imprimir{
                window.print();
            }
        </script>
        <style>
            @media print{
                table {
                    width: 100%;
                    border-collapse: collapse;
                    margin: 0;
                }
                th, td {
                    border: 1px solid black;
                    padding: 8px;
                    text-align: left;
                    word-wrap: break-word; /* Asegura que el texto largo se ajuste */
                }
                body {
                    margin: 0;
                }
                 .container {
                    margin: 0;
                    padding: 0;
                    width: 100%; 
                }
                 @page {
                    margin: 0;
                }
                .accion, .noimp, .noip{
                    display:none;
                }
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Lista de Empleados</h1>
            <div class="noimp">
                <a class="btn btn-primary" href="menu.jsp">Regresar a Menu</a>
                <a class="btn btn-primary" href="ControladorEmpleado?accion=add">Agregar Empleado</a>
                <button class="btn btn-primary" onclick="javascript:window.print()">Imprimir</button>
            </div>
            <br> 
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr class="text-center">                        
                        <th>NOMBRES</th>
                        <th>APELLIDOS</th>
                        <th>DUI</th>
                        <th>FECHA NACIMIENTO</th>
                        <th>TELEFONO</th>
                        <th>GENERO</th>
                        <th>ESTADO CIVIL</th>
                        <th>CORREO</th>
                        <th>CARGO</th>
                        <th class="accion">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    EmpleadoDAO edao = new EmpleadoDAO();
                    List<Empleados> list = edao.listar();
                    Iterator<Empleados>iter = list.iterator();
                    Empleados emp = null;
                    while(iter.hasNext()){
                        emp = iter.next();
                    
                %>
                <tbody>
                    <tr class="text-center">
                        
                        <td><%= emp.getNombre() %></td>
                        <td><%= emp.getApellido() %></td>
                        <td><%= emp.getDUI() %></td>
                        <td><%= emp.getFechaNacimiento() %></td>
                        <td><%= emp.getTelefono() %></td>
                        <td><%= emp.getGenero() %></td>
                        <td><%= emp.getEstadoCivil() %></td>
                        <td><%= emp.getCorreo() %></td>
                        <td><%= emp.getCargo() %></td>
                        <td class="noip">
                            <div class="col-10">
                                <a class="btn btn-outline-primary" href="ControladorEmpleado?accion=editar&id=<%= emp.getId() %>">Editar</a>
                                <a class="btn btn-outline-primary" href="ControladorEmpleado?accion=eliminar&id=<%= emp.getId() %>">Eliminar</a>
                            </div>
                        </td>
                    </tr>
                    <%}%>
                </tbody>                
            </table>
        </div>
    </body>
</html>
