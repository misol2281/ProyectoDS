<%-- 
    Document   : agregarTipoTrabajo
    Created on : 9 nov 2024, 19:41:41
    Author     : Cristian
--%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/estiloListar.css">
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

