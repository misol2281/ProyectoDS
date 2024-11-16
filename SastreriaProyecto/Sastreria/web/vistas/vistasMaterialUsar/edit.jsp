<%@page import="Entidad.MaterialUsar"%>
<%@page import="Modelo.MaterialUsarDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Editar MaterialUsar</title>
    </head>
    <body>
        <div class="container">
            <%
                MaterialUsarDAO mudao = new MaterialUsarDAO();
                int id = Integer.parseInt((String)request.getAttribute("idmtu"));
                MaterialUsar mu = (MaterialUsar)mudao.list(id);
            %>
            <div class="col-lg-8">
                <h1>Editar Material a Usar</h1>
                <br> 
                <form class="row g-3" action="ControladorMaterialUsar">                    
                    <div class="col-md-4">
                        <label class="form-label">Material:</label>
                        <input type="text" class="form-control" placeholder="Material" name="txtidMaterial" value="<%= mu.getIdMaterial() %>">
                    </div>
                    <div class="col-md-6">
                        <label class="form-label">Detalle de orden:</label>
                        <input type="text" class="form-control" placeholder="Detalle Orden" name="txtidDetalleOrden" value="<%= mu.getIdDetalleOrden()%>">
                    </div>
                    <div class="col-md-4">
                        <label class="form-label">Unidad de Medida:</label>
                        <input type="text" class="form-control" placeholder="Unidad de Medida" name="txtidUnidadMedida" value="<%= mu.getIdUnidadMedida() %>">
                    </div>
                    <div class="col-md-6">
                        <label class="form-label">Caracteristicas de Material:</label>
                        <input type="text" class="form-control" placeholder="Caracteristicas" name="txtCaractMaterial" value="<%= mu.getCaracteristicas() %>">
                    </div>
                    <div class="col-md-3">
                        <label class="form-label">Cantidad:</label>
                        <input type="text" class="form-control" placeholder="00" name="txtCantidad" value="<%= mu.getCantidad() %>">
                    </div>
                    <div class="col-md-3">
                        <label class="form-label">Precio:</label>
                        <input type="text" class="form-control" placeholder="0.00" name="txtPrecio" value="<%= mu.getPrecio() %>">
                    </div>
                    <div class="col-md-3">
                        <label class="form-label">SubTotal:</label>
                        <input type="text" class="form-control" placeholder="0.00" name="txtSubTotal" value="<%= mu.getSubTotal() %>">
                    </div>
                    <input type="hidden" name="txtid" value="<%= mu.getId() %>">
                    <div class="col-12">
                        <input class="btn btn-primary" type="submit" name="accion" value="Actualizar">
                        <a class="btn btn-primary" href="ControladorMaterialUsar?accion=listar">Regresar</a>
                    </div>                    
                </form>   
            </div>            
        </div>
    </body>
</html>
