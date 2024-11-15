
<%@page import="Entidad.Cargo"%>
<%@page import="Modelo.CargoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>EditarCargo</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-8">
                <%
                CargoDAO cdao = new CargoDAO();
                int id = Integer.parseInt((String)request.getAttribute("idcar"));
                Cargo c = (Cargo)cdao.list(id);
                %>
                <h1>Editar Cargo</h1>
                <form action="ControladorCargo">
                    <div class="col-md-6">
                        <label for="formGroupExampleInput" class="form-label">Cargo:</label><br>
                        <input type="text" class="form-control" name="txtCargo" placeholder="Cargo" value="<%= c.getCargo() %>"> <br>
                    </div>

                    <input type="hidden" name="txtid" value="<%= c.getId() %>"> <br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar">
                    <a class="btn btn-primary" href="ControladorCargo?accion=listar">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>
