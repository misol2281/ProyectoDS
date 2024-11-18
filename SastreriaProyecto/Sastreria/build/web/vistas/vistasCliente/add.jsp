

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Agregar Cliente</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-8">
                <h1>Agregar Cliente</h1>
                <form action="ControladorCliente">
                    <div class="col-md-6">
                        <label for="formGroupExampleInput" class="form-label">Nombre:</label><br>
                        <input type="text"  class="form-control" name="txtNombre" placeholder="Nombre"><br>
                        <label for="formGroupExampleInput" class="form-label">Apellido:</label><br>
                        <input type="text" class="form-control" name="txtApellido" placeholder="Apellido"><br>
                        <label for="formGroupExampleInput" class="form-label">Telefono:</label><br>
                        <input type="text" class="form-control" name="txtTelefono" placeholder="0000-0000"><br>
                    </div>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a class="btn btn-primary" href="ControladorCliente?accion=listar">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>
