<%-- 
    Document   : editarTipoTrabajo
    Created on : 14 nov. 2024, 13:40:16
    Author     : carr0
--%>

<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/estiloEditar.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>Actualizar Registro</title>
  </head>
<body>
    <div id="actualizar" class="actualizar">
        <div class="contenedorActualizar">
            <span class="btnCerrar" id="cerrarActualizar">&times;</span>
            <h2>Formulario de Registro</h2>
                <input type="hidden" id="id" name="id" value="<%= request.getAttribute("id") %>">
                <label for="TipoTrabajo">Tipo Trabajo:</label>
                <input type="text" id="TipoTrabajo" name="TipoTrabajo" value="<%= request.getAttribute("TipoTrabajo") %>" required><br><br>
                <label for="Descripcion">Descripcion:</label>
                <input type="text" id="Descripcion" name="Descripcion" value="<%= request.getAttribute("Descripcion") %>" required><br><br>
                <input type="submit" value="Actualizar" onclick="actualizarRegistro()">
        </div>
    </div>
</body>
<script src="script/scriptTipoTrabajo/TipoTrabajo.js"></script>
</html>
