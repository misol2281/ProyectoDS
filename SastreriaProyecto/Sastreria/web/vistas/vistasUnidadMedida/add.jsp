<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>AgregarUnidadMedida</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-8">
                <h1>Agregar Unidad Medida</h1>
                <form>
                    <div class="col-md-6">
                        <label class="form-label">Unidad Medida:</label><br>
                        <input type="text" class="form-control" name="txtUnidadM" placeholder="Unidad Medida"><br>
                        <label class="form-label">Descripcion:</label><br>
                        <input type="text" class="form-control" name="txtDescripcion" placeholder="Descripcion"><br>
                    </div>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a class="btn btn-primary" href="ControladorUnidadMedida?accion=listar">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>
