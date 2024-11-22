<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.DAOEstiloRopa"%>
<%@page import="Entidad.EstiloRopa"%>
<%@page import="Modelo.DAOTipoTrabajo"%>
<%@page import="Entidad.TipoTrabajo"%>
<%@page import="Modelo.DAOOrden"%>
<%@page import="Entidad.Orden"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>Agregar Registro</title>
</head>
<body>

<div id="agregar" class="agregar">
    <div class="contenedorAgregar">
        <h2>Formulario de Registro</h2>
        <form id="formAgregar">
            <input type="hidden" id="id" name="id" value="<%= request.getAttribute("id") %>">
            <label for="ER">Estilo Ropa:</label>
            <input list="lsER" id="ER" name="ER" placeholder="Escribe para ver sugerencias">
            <datalist id="lsER">
                <%
                    DAOEstiloRopa daoER = new DAOEstiloRopa();
                    List<EstiloRopa> listER = daoER.listarEstiloRopa();
                    if (listER != null && !listER.isEmpty()) {
                        for (EstiloRopa er : listER) {
                %>
                    <option value="<%= er.getEstiloRopa() %>" data-id="<%= er.getId() %>"></option>
                <%  
                        }
                    }
                %>
            </datalist><br><br>

            
            <input type="hidden" id="idEstiloRopa" name="idEstiloRopa" value="<%= request.getAttribute("idER") %>">

            <label for="TT">Tipo Trabajo:</label>
            <input list="lsTT" id="TT" name="TT" placeholder="Escribe para ver sugerencias">
            <datalist id="lsTT">
                <%
                    DAOTipoTrabajo daott = new DAOTipoTrabajo();
                    List<TipoTrabajo> listt = daott.listarTipoTrabajos();
                    if (listt != null && !listt.isEmpty()) {
                        for (TipoTrabajo tt : listt) {
                %>
                    <option value="<%= tt.getTipoTrabajo() %> "data-id="<%= tt.getId() %>"></option>
                <%  
                        }
                    }
                    
                %>
            </datalist><br><br>

            
            <input type="hidden" id="idTipoTrabajo" name="idTipoTrabajo" value="<%= request.getAttribute("idTT") %>">


            <label for="orden">Orden:</label>
            <input list="lsOrden" id="orden" name="orden" placeholder="Escribe para ver sugerencias">
            <datalist id="lsOrden">
                <%
                    DAOOrden daoO = new DAOOrden();
                    List<Orden> listO = daoO.listarOrden();
                    if (listO != null && !listO.isEmpty()) {
                        for (Orden o : listO) {
                %>
                    <option value="<%= o.getId() %>"></option>
                <%  
                        }
                    }
                    else{
                %>
                    <option value="Null">
                        <%}%>
            </datalist><br><br>

            <!-- Campo oculto para ID del empleado -->
            <input type="hidden" id="idO" name="idO" value="<%= request.getAttribute("idO") %>">
            
            <label for="instrucciones">Instrucciones:</label>
            <input type="input" id="instrucciones" name="instrucciones" value="<%= request.getAttribute("instrucciones") %>">

            <label for="subTotal">Sub Total:</label>
            <input type="input" id="subTotal" name="subTotal" value="<%= request.getAttribute("subTotal") %>">

            <button type="submit" id="btnAgregar" name="accion" value="Actualizar">Actualizar</button>
        </form>
    </div>
</div>

</body>
<script src="/Sastreria/script/scriptDetOrden/EditarDetOrden.js"></script>
</html>
