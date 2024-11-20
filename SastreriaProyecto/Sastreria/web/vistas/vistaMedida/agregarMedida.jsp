<%-- 
    Document   : agregarMedida
    Created on : 14 nov 2024, 13:23:57
    Author     : Eduardo Morales
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>Agregar Medida</title>

  </head>
</head>
    <body>
        <div>
            <h1>Agregar Medida</h1>
            <form action="CtrlMedida">
               
                Medida:<br>
                <input type="text" name="txtm"><br>
                Descripcion:<br> 
                <input type="text" name="txtdes"><br>
                
                <input type="submit" name="accion" value="Agregar"><br>
                <a href="CtrlMedida?accion=listarMedida">Regresar</a>
            </form>
        </div>
    </div>
</body>

