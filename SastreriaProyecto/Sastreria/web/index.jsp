<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .form-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        form {
            padding: 0 20px; /* Espaciado interno en los lados */
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 10px;
            margin-top: 10px;
        }

        input {
            width: 90%; /* Reduce el ancho para dejar márgenes laterales */
            padding: 10px;
            margin-bottom: 15px;
            margin-top: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
            display: block; 
            margin: 0 auto; 
            
        }

        button {
            width: 90%;
            padding: 10px;
            background-color: #007BFF;
            color: #fff;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            margin: 0 auto;
            display: block;
        }

        button:hover {
            background-color: #0056b3;
        }
        
        input[type="password"] {
        margin-bottom: 25px; /* Aumentar el espacio inferior */
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Iniciar Sesión</h2>
        <form action="Login" method="POST">
            <label for="usu">Usuario:</label>
            <input type="email" name="usu" id="usu" placeholder="Ingresa tu correo" required>

            <label for="contra">Contraseña:</label>
            <input type="password" name="contra" id="contra" placeholder="Ingresa tu contraseña" required>
            <% if (request.getAttribute("error") != null) { %>
             <p style="color: red;"><%= request.getAttribute("error") %></p>
            <% } %>
            <button type="submit">Ingresar</button>
        </form>
    </div>
</body>
</html>


