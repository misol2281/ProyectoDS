<%@page import="Entidad.Material"%>
<%@page import="Modelo.MaterialDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>EditarMaterial</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-8">
                <%
                    MaterialDAO mdao = new MaterialDAO();
                    int id = Integer.parseInt((String)request.getAttribute("idmat"));
                    Material m = (Material)mdao.list(id);
                %>
                <h1>Editar Material</h1>
                <form>
                    <div class="col-md-6">
                        <label class="form-label">Material:</label><br>
                        <input type="text" class="form-control" name="txtMaterial" placeholder="Material" value="<%= m.getMaterial() %>"><br>                        
                    </div>
                    <div class="col-md-12">
                        <label class="form-label">Descripcion:</label><br>
                        <input type="text" class="form-control" name="txtDescripcion" placeholder="Descripcion" value="<%= m.getDescripcion() %>"><br>
                    </div>
                    <input type="hidden" name="txtid" value="<%= m.getId() %>"> <br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar">
                    <a class="btn btn-primary" href="ControladorMaterial?accion=listar">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>
