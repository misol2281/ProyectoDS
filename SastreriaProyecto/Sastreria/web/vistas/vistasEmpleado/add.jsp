

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AgregarEmpleado</title>
    </head>
    <body>
        <div>
            <h1>Agregar Empleado</h1>
            <form action="ControladorEmpleado">
                Nombres:<br>
                <input type="text" name="txtNombre"><br>
                Apellidos:<br>
                <input type="text" name="txtApellido"><br>
                DUI:<br>
                <input  type="text" name="txtdui"><br>
                Fecha Nacimiento:<br>
                <input type="text" name="txtfnaci"><br>
                Telefono:<br>
                <input type="text" name="txtTelefono"><br>
                Genero:<br>
                <select id="genero" name="genero">
                <option value="Masculino">M</option>
                <option value="Femenino">F</option>
                </select><br>
                Estado Civil:<br>
                <input type="text" name="txtEstadoCivil"><br>
                Correo:<br>
                <input type="text" name="txtCorreo"><br>
                idCargo:<br>
                <input type="text" name="txtCargo"><br>
                
                <input type="submit" name="accion" value="Agregar"><br>
            </form>
        </div>
    </body>
</html>
