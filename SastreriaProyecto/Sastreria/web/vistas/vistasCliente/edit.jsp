

<%@page import="Entidad.Cliente"%>
<%@page import="Modelo.ClienteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Cliente</title>
    </head>
    <body>
        <div>
            <%
                ClienteDAO cdao = new ClienteDAO();
                int id = Integer.parseInt((String)request.getAttribute("idcli"));
                Cliente c = (Cliente)cdao.list(id);
            %>
            <h1>Editar Cliente</h1>
            <form action="ControladorCliente">
                Nombre:<br>
                <input type="text" name="txtNombre" value="<%= c.getNombre() %>"><br>
                Apellido:<br> 
                <input type="text" name="txtApellido" value="<%= c.getApellido() %>"><br>
                Telefono:<br>
                <input type="text" name="txtTelefono" value="<%= c.getTelefono() %>"><br>
                
                <input type="hidden" name="txtid" value="<%= c.getId() %>"><br>
                <input type="submit" name="accion" value="Actualizar"><br>
                <a href="ControladorCliente?accion=listar">Regresar</a>
            </form>
        </div>
    </body>
</html>
