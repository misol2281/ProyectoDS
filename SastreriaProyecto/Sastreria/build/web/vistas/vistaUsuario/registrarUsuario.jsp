<%-- 
    Document   : registrarUsuario
    Created on : 25 nov. 2024, 10:55:25
    Author     : carr0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="/Sastreria/CtrlUsuario" method="POST">
        <label>Usuario:</label>
        <input type="text" name="usuario" required>
        <label>Contraseña:</label>
        <input type="password" name="contra" required>
        <label>Rol:</label>
        <input type="text" name="idRol" required>
        <label>Empleado:</label>
        <input type="text" name="idEmpleado" required>
        <button type="submit">Registrar</button>
        </form>
    </body>
</html>
