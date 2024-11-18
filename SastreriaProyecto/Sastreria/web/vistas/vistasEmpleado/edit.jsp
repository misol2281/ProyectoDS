

<%@page import="Entidad.Empleados"%>
<%@page import="Modelo.EmpleadoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>EditarEmpleado</title>
    </head>
    <body>
        <div class="container">
            <%
                EmpleadoDAO edao = new EmpleadoDAO();
                int id = Integer.parseInt((String)request.getAttribute("idemp"));
                Empleados e = (Empleados)edao.list(id);
            %>
            <h1>Editar Empleado</h1>
            <form action="ControladorEmpleado">
                Nombres:<br>
                <input type="text" name="txtNombre" value="<%= e.getNombre() %>"><br>
                Apellidos:<br>
                <input type="text" name="txtApellido" value="<%= e.getApellido() %>"><br>
                DUI:<br>
                <input  type="text" name="txtdui" value="<%= e.getDUI() %>"><br>
                Fecha Nacimiento:<br>
                <input type="text" name="txtfnaci" value="<%= e.getFechaNacimiento() %>"><br>
                Telefono:<br>
                <input type="text" name="txtTelefono" value="<%= e.getTelefono() %>"><br>
                Genero:<br>
                <select id="genero" name="genero" value="<%= e.getGenero() %>">
                <option value="Masculino">M</option>
                <option value="Femenino">F</option>
                </select><br>
                Estado Civil:<br>
                <input type="text" name="txtEstadoCivil" value="<%= e.getEstadoCivil() %>"><br>
                Correo:<br>
                <input type="text" name="txtCorreo" value="<%= e.getCorreo() %>"><br>
                idCargo:<br>
                <input type="text" name="txtCargo" value="<%= e.getIdCargo() %>"><br>
                
                <input type="hidden" name="txtid" value="<%= e.getId() %>">
                <input type="submit" name="accion" value="Actualizar"><br>
                <a href="ControladorEmpleado?accion=listar">Regresar</a>
            </form>
        </div>
    </body>
</html>
