<%@page import="Entidad.UnidadMedida"%>
<%@page import="Modelo.UnidadMedidaDAO"%>
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
                    UnidadMedidaDAO umdao = new UnidadMedidaDAO();
                    int id = Integer.parseInt((String)request.getAttribute("idumd"));
                    UnidadMedida um = (UnidadMedida)umdao.list(id);
                %>
                <h1>Editar Unidad Medida</h1>
                <form>
                    <div class="col-md-6">
                        <label class="form-label">Unidad Medida:</label><br>
                        <input type="text" class="form-control" name="txtUnidadM" placeholder="Unidad Medida" value="<%= um.getUnidadMedida() %>"><br>                        
                    </div>
                    <div class="col-md-12">
                        <label class="form-label">Descripcion:</label><br>
                        <input type="text" class="form-control" name="txtDescripcion" placeholder="Descripcion" value="<%= um.getDescripcion() %>"><br>
                    </div>
                    <input type="hidden" name="txtid" value="<%= um.getId() %>"> <br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar">
                    <a class="btn btn-primary" href="ControladorUnidadMedida?accion=listar">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>
