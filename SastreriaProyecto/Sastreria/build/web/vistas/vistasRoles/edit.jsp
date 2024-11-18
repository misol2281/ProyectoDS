

<%@page import="Entidad.Roles"%>
<%@page import="Modelo.RolesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EditarRoles</title>
    </head>
    <body>
        <div>
            <%
                RolesDAO rdao = new RolesDAO();
                int id = Integer.parseInt((String)request.getAttribute("idrol"));
                Roles r = (Roles)rdao.list(id);
            %>
            <h1>Editar Roles</h1>
            <form action="ControladorRoles">
                Rol:
                <input type="text" name="txtRol" value="<%= r.getRol() %>">
                
                <input type="hidden" name="txtid" value="<%= r.getId() %>">
                <input type="submit" name="accion" value="Actualizar">
                <br>
                <a href="ControladorRoles?accion=listar">Regresar a Menu</a>
            </form>
        </div>
    </body>
</html>
