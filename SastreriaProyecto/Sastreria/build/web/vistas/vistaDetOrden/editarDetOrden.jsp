<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.ClienteDAO"%>
<%@page import="Entidad.Cliente"%>
<%@page import="Modelo.EmpleadoDAO"%>
<%@page import="Entidad.Empleados"%>
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
        <span class="btnCerrar" id="cerrarAgregar">&times;</span>
        <h2>Formulario de Registro</h2>
        <form id="formAgregar" action="../../CtrlOrden" method="POST">
            <label for="Cliente">Cliente:</label>
            <input list="lsClientes" id="cliente" name="cliente" placeholder="Escribe para ver sugerencias">
            <datalist id="lsClientes">
                <%
                    ClienteDAO daoC = new ClienteDAO();
                    List<Cliente> listC = daoC.listar();
                    if (listC != null && !listC.isEmpty()) {
                        for (Cliente c : listC) {
                %>
                    <option value="<%= c.getNombre() %> <%= c.getApellido() %>" data-id="<%= c.getId() %>"></option>
                <%  
                        }
                    }
                %>
            </datalist><br><br>

            <!-- Campo oculto para ID del cliente -->
            <input type="hidden" id="idCliente" name="idCliente" value="<%= request.getAttribute("idCliente") %>">

            <label for="Empleado">Empleado:</label>
            <input list="lsEmpleados" id="empleado" name="empleado" placeholder="Escribe para ver sugerencias">
            <datalist id="lsEmpleados">
                <%
                    EmpleadoDAO daoE = new EmpleadoDAO();
                    List<Empleados> listE = daoE.listar();
                    if (listE != null && !listE.isEmpty()) {
                        for (Empleados em : listE) {
                %>
                    <option value="<%= em.getNombre() %> <%= em.getApellido() %>"data-id="<%= em.getId() %>"></option>
                <%  
                        }
                    }
                    else{
                %>
                    <option value="Null">
                        <%}%>
            </datalist><br><br>

            <!-- Campo oculto para ID del empleado -->
            <input type="hidden" id="idEmpleado" name="idEmpleado" value="<%= request.getAttribute("idEmpleado") %>">
            <input type="hidden" id="id" name="id" value="<%= request.getAttribute("id") %>">
            <label for="fechaOrden">Fecha Orden:</label>
            <input type="date" id="fechaOrden" name="fechaOrden" value="<%= request.getAttribute("fechaOrden") %>">

            <label for="fechaEntrega">Fecha Entrega:</label>
            <input type="date" id="fechaEntrega" name="fechaEntrega" value="<%= request.getAttribute("fechaEntrega") %>">

            <label for="monto">Monto Total:</label>
            <input type="text" id="monto" name="monto" value="<%= request.getAttribute("monto") %>">

            <button type="submit" id="btnAgregar">Agregar</button>
        </form>
    </div>
</div>
</body>
<script src="script/scriptOrden/EditarOrden.js"></script>
</html>
