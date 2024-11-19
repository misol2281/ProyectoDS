

<%@page import="Entidad.Cliente"%>
<%@page import="Modelo.ClienteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Editar Cliente</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-8">
                <%
                ClienteDAO cdao = new ClienteDAO();
                int id = Integer.parseInt((String)request.getAttribute("idcli"));
                Cliente c = (Cliente)cdao.list(id);
                %>
                <h1>Editar Cliente</h1>
                <form action="ControladorCliente">
                    <div class="col-md-6">
                        <label class="form-label">Nombre:</label><br>
                        <input type="text" class="form-control" name="txtNombre" placeholder="Nombre" value="<%= c.getNombre() %>"><br>
                        <label class="form-label">Apellido:</label><br>
                        <input type="text" class="form-control" name="txtApellido" placeholder="Apellido" value="<%= c.getApellido() %>"><br>
                        <label class="form-label">Telefono:</label><br>
                        <input type="text" class="form-control" name="txtTelefono" placeholder="0000-0000" value="<%= c.getTelefono() %>"><br>
                    </div>
                    <input type="hidden" name="txtid" value="<%= c.getId() %>"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar">
                    <a class="btn btn-primary" href="ControladorCliente?accion=listar">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>
