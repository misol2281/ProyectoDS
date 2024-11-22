<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/Sastreria/css/login.css">
    <title>Login</title>
</head>
<body>
    <h2>Iniciar Sesión</h2>
    <form action="Login" method="POST">
        <label for="usu">Usuario:</label>
        <input type="email" name="usu" id="usu" required><br><br>
        <label for="contra">Contraseña:</label>
        <input type="password" name="contra" id="contra" required><br><br>
        <button type="submit">Ingresar</button>
    </form>

    <% if (request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>
</body>
</html>
