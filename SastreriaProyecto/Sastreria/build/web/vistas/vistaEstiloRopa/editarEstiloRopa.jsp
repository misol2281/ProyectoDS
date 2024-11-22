<%-- 
    Document   : editarEstiloRopa
    Created on : 18 nov 2024, 16:28:02
    Author     : Eduardo Morales
--%>
<%@page import="Modelo.DAOEstiloRopa"%>
<%@page import="Entidad.EstiloRopa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <%
                DAOEstiloRopa dao= new DAOEstiloRopa();
                int id=Integer.parseInt((String)request.getAttribute("idesr"));
                EstiloRopa e=(EstiloRopa)dao.list(id);
            %>
        <h1>Modificar Estilo de Ropa</h1>
            <form action="CtrlEstiloRopa">
               
                Estilo de Ropa:<br>
                <input type="text" name="txter" value="<%=e.getEstiloRopa()%>"><br>
                Descripcion:<br> 
                <input type="text" name="txtdes"value="<%=e.getDescripcion()%>"><br>
                
                <input type="hidden" name="txtid" value="<%=e.getId()%>"><br>
                <input type="submit" name="accion" value="Actualizar"><br>
                <a href="CtrlEstiloRopa?accion=listarEstiloRopa">Regresar</a>
            </form>
        </div>
    </div>
</body>
</html>
