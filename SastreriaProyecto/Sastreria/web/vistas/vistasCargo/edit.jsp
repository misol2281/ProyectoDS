
<%@page import="Entidad.Cargo"%>
<%@page import="Modelo.CargoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EditarCargo</title>
    </head>
    <body>
        <div>
            <%
                CargoDAO cdao = new CargoDAO();
                int id = Integer.parseInt((String)request.getAttribute("idcar"));
                Cargo c = (Cargo)cdao.list(id);
            %>
            <h1>Editar Cargo</h1>
            <form action="ControladorCargo">
                Cargo:<br>
                <input type="text" name="txtCargo" value="<%= c.getCargo() %>"> <br>
                
                <input type="hidden" name="txtid" value="<%= c.getId() %>"> <br>
                <input type="submit" name="accion" value="Actualizar"><br>
                <a href="ControladorCargo?accion=listar">Regresar</a>
            </form>
        </div>
    </body>
</html>
