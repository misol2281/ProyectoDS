

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AgregarCargo</title>
    </head>
    <body>
        <div>
            <h1>Agregar Cargo</h1>
            <form action="ControladorCargo">
                Cargo:<br>
                <input type="text" name="txtCargo"> <br>
                
                <input type="submit" name="accion" value="Agregar">
            </form>
        </div>
    </body>
</html>
