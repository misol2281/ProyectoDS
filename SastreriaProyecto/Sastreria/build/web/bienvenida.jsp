<%@page import="Entidad.Usuario"%>
<%@page session="true"%>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bienvenido</title>
</head>
<body>
    <h1>¡Bienvenido, <%= usuario.getNombre() %>!</h1>
    <a href="logout.jsp">Cerrar sesión</a>
</body>
</html>

