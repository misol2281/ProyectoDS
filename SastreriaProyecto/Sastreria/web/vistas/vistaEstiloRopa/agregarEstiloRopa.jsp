<%-- 
    Document   : agregarEstiloRopa
    Created on : 14 nov 2024, 11:45:05
    Author     : Eduardo Morales
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>Agregar Estilo de Ropa</title>

  </head>
</head>
    <body>
        <div>
            <h1>Agregar Estilo de Ropa</h1>
            <form action="CtrlEstiloRopa">
               
                Estilo de Ropa:<br>
                <input type="text" name="txter"><br>
                Descripcion:<br> 
                <input type="text" name="txtdes"><br>
                
                <input type="submit" name="accion" value="Agregar"><br>
                <a href="CtrlEstiloRopa?accion=listarEstiloRopa">Regresar</a>
            </form>
        </div>
    </div>
</body>

