

<%@page import="Entidad.Roles"%>
<%@page import="Modelo.RolesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>EditarRoles</title>
    </head>
    <body>
        <div class="container">
            <%
                RolesDAO rdao = new RolesDAO();
                int id = Integer.parseInt((String)request.getAttribute("idrol"));
                Roles r = (Roles)rdao.list(id);
            %>
            <div class="col-lg-8">
                <h1>Editar Roles</h1>
                <form action="ControladorRoles">
                    <div class="col-md-6">
                        <label  class="form-label">Rol:</label>
                        <input type="text" class="form-control" name="txtRol" placeholder="Rol" value="<%= r.getRol() %>">
                    </div>                    
                    
                    <input type="hidden" name="txtid" value="<%= r.getId() %>">
                    <br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar">                    
                    <a class="btn btn-primary" href="ControladorRoles?accion=listar">Regresar</a>
                </form>
            </div>            
        </div>
    </body>
</html>
