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
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>CARGO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td></td>
                        <td></td>
                        <td>
                            <a>Editar</a>
                            <a>Eliminar</a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
