<%@page import="Entidad.MaterialUsar"%>
<%@page import="Modelo.MaterialUsarDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar MaterialUsar</title>
    </head>
    <body>
        <div>
            <%
                MaterialUsarDAO mudao = new MaterialUsarDAO();
                int id = Integer.parseInt((String)request.getAttribute("idmtu"));
                MaterialUsar mu = (MaterialUsar)mudao.list(id);
            %>
            <h1>Editar MaterialUsa</h1>
            <form >
                ID:<br>  
                IDMaterial:<br>
                <input type="text" name="txtidMaterial" value="<%= mu.getIdMaterial() %>"><br>
                IDDetalleOrden:<br> 
                <input type="text" name="txtidDetalleOrden" value="<%= mu.getIdDetalleOrden() %>"><br>
                IDUnidadMedida:<br>
                <input type="text" name="txtidUnidadMedida" value="<%= mu.getIdUnidadMedida() %>"><br>
                Caracteristicas Material:<br>
                <input type="text" name="txtCaractMaterial" value="<%= mu.getCaracteristicas() %>"><br>
                Cantidad:<br>
                <input type="text" name="txtCantidad" value="<%= mu.getCantidad() %>"><br>
                Precio:<br>
                <input type="text" name="txtPrecio" value="<%= mu.getPrecio() %>"><br>
                SubTotal:<br>
                <input type="text" name="txtSubTotal" value="<%= mu.getSubTotal() %>"><br>
                
                <input type="hidden" name="txtid" value="<%= mu.getId() %>">
                <input type="submit" name="accion" value="Actualizar"><br>
                <a href="ControladorMaterialUsar?accion=listar">Regresar</a>
            </form>
        </div>
    </body>
</html>
