

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>AgregarCargo</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-8">
                <h1>Agregar Cargo</h1>
                <form action="ControladorCargo">
                    <div class="col-md-6">
                        <label for="formGroupExampleInput" class="form-label">Cargo:</label><br>
                        <input type="text" class="form-control" name="txtCargo" placeholder="Cargo"><br>
                    </div>

                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a class="btn btn-primary" href="ControladorCargo?accion=listar">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>
