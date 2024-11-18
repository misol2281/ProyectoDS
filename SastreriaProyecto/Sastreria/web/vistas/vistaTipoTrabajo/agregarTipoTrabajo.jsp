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
    <link rel="stylesheet" href="../../css/estiloAgregar.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>Agregar Registro</title>
  </head>
<body>
    <div id="agregar" class="agregar">
        <div class="contenedorAgregar">
            <span class="btnCerrar" id="cerrarAgregar">&times;</span>
            <h2>Formulario de Registro</h2>
            <form id="formAgregar" action="../../CtrlOrden" method="POST">
            <label for="TipoTrabajo">Tipo Trabajo:</label>
            <input type="text" id="Cliente" name="TipoTrabajo" required><br><br>
            <label for="Descripcion">Descripcion:</label>
            <input type="text" id="Descripcion" name="Descripcion" required><br><br>
            <button type="submit" id="btnAgregar">Agregar</button>
            </form>
        </div>
    </div>
</body>
<script src="/Sastreria/script/scriptTipoTrabajo/TipoTrabajo.js"></script>
</html>

