

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Cliente</title>
    </head>
    <body>
        <div>
            <h1>Agregar Cliente</h1>
            <form action="ControladorCliente">
                ID:<br>
                Nombre:<br>
                <input type="text" name="txtNombre"><br>
                Apellido:<br> 
                <input type="text" name="txtApellido"><br>
                Telefono:<br>
                <input type="text" name="txtTelefono"><br>
                <input type="submit" name="accion" value="Agregar"><br>
            </form>
        </div>
    </body>
</html>
