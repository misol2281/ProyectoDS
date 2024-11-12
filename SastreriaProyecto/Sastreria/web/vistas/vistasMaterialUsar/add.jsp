

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Material a Usar</title>
    </head>
    <body>
        <div>
            <h1>Agregar Material a Usar</h1>
            <form action="ControladorMaterialUsar">
                ID:<br>  
                IDMaterial:<br>
                <input type="text" name="txtidMaterial"><br>
                IDDetalleOrden:<br> 
                <input type="text" name="txtidDetalleOrden"><br>
                IDUnidadMedida:<br>
                <input type="text" name="txtidUnidadMedida"><br>
                Caracteristicas Material:<br>
                <input type="text" name="txtCaractMaterial"><br>
                Cantidad:<br>
                <input type="text" name="txtCantidad"><br>
                Precio:<br>
                <input type="text" name="txtPrecio"><br>
                SubTotal:<br>
                <input type="text" name="txtSubTotal"><br>
                <input type="submit" name="accion" value="Agregar"><br>
            </form>
        </div>
    </body>
</html>
