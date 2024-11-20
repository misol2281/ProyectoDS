<%-- 
    Document   : agregarTipoMedida
    Created on : 15 nov 2024, 18:18:06
    Author     : Eduardo Morales
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>Agregar Tipo de Medida</title>

  </head>
</head>
    <body>
        <div>
            <h1>Agregar Tipo de Medida</h1>
            <form action="CtrlTipoMedida">
               
                Tipo de Medida:<br>
                <input type="text" name="txttm"><br>
                Descripcion:<br> 
                <input type="text" name="txtdes"><br>
                
                <input type="submit" name="accion" value="Agregar"><br>
                <a href="CtrlTipoMedida?accion=listarTipoMedida">Regresar</a>
            </form>
        </div>
    </div>
</body>


