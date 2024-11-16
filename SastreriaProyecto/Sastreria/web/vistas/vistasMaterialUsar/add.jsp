

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Agregar Material a Usar</title>
    </head>
    <body>
        <div class="container">            
            <div class="col-lg-8">
                <h1>Agregar Material a Usar</h1>
                <br> 
               
                <form class="row g-3" action="ControladorMaterialUsar">                    
                    <div class="col-md-4">
                        <label class="form-label">Material:</label>
                        <input type="text" class="form-control" placeholder="Material" name="txtidMaterial">
                    </div>
                    <div class="col-md-6">
                        <label class="form-label">Detalle de orden:</label>
                        <input type="text" class="form-control" placeholder="Detalle Orden" name="txtidDetalleOrden">
                    </div>
                    <div class="col-md-4">
                        <label class="form-label">Unidad de Medida:</label>
                        <input type="text" class="form-control" placeholder="Unidad de Medida" name="txtidUnidadMedida">
                    </div>
                    <div class="col-md-6">
                        <label class="form-label">Caracteristicas de Material:</label>
                        <input type="text" class="form-control" placeholder="Caracteristicas" name="txtCaractMaterial">
                    </div>
                    <div class="col-md-3">
                        <label class="form-label">Cantidad:</label>
                        <input type="text" class="form-control" placeholder="00" name="txtCantidad">
                    </div>
                    <div class="col-md-3">
                        <label class="form-label">Precio:</label>
                        <input type="text" class="form-control" placeholder="0.00" name="txtPrecio"><br>
                    </div>
                    <div class="col-md-3">
                        <label class="form-label">SubTotal:</label>
                        <input type="text" class="form-control" placeholder="0.00" name="txtSubTotal"><br>
                    </div>
                    <div class="col-12">
                        <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                        <a class="btn btn-primary" href="ControladorMaterialUsar?accion=listar">Regresar</a>
                    </div>
                    
                </form>   
            </div>
        </div>
    </body>
</html>
