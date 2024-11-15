<%-- 
    Document   : editarTipoTrabajo
    Created on : 14 nov. 2024, 13:40:16
    Author     : carr0
--%>

<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../css/estiloAgregar.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" rel="stylesheet">
    <title>Agregar Registro</title>
  </head>
<body>
    <div id="agregar" class="agregar">
        <div class="contenedorAgregar">
            <span class="btnCerrar" id="cerrarAgregar">&times;</span>
            <h2>Formulario de Registro</h2>
            <form action="../../CtrlTipoTrabajo" method="POST">
                <label for="TipoTrabajo">Tipo Trabajo:</label>
                <input type="text" id="TipoTrabajo" name="TipoTrabajo" required><br><br>
                <label for="Descripcion">Descripcion:</label>
                <input type="text" id="Descripcion" name="Descripcion" required><br><br>
                <input type="submit" value="Agregar">
            </form>
        </div>
    </div>
</body>
</html>
