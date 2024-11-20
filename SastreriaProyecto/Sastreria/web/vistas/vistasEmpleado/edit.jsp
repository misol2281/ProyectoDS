<%@page import="Entidad.Cargo"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.CargoDAO"%>
<%@page import="Entidad.Empleados"%>
<%@page import="Modelo.EmpleadoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>EditarEmpleado</title>
    </head>
    <body>
        <div class="container">
            <%
                EmpleadoDAO edao = new EmpleadoDAO();
                int id = Integer.parseInt((String)request.getAttribute("idemp"));
                Empleados e = (Empleados)edao.list(id);
            %>
            <div class="col-lg-8">
                <h1>Editar Empleado</h1>
                <form class="row g-3" action="ControladorEmpleado">
                    <div class="col-md-6">
                        <label class="form-label">Nombre:</label>
                        <input type="text" class="form-control" name="txtNombre" placeholder="Nombre" value="<%= e.getNombre() %>"><br>                        
                    </div>
                    <div class="col-md-6">
                        <label class="form-label">Apellido:</label>
                        <input type="text" class="form-control" name="txtApellido" placeholder="Apellido" value="<%= e.getApellido() %>"><br>
                    </div>
                    <div class="col-md-3">
                        <label class="form-label">DUI:</label>
                        <input  type="text" class="form-control" name="txtdui" placeholder="0000000-0" value="<%= e.getDUI() %>"><br>
                    </div>
                    <div class="col-md-4">
                        <label class="form-label">Fecha Nacimiento:</label>
                        <input type="text" class="form-control" name="txtfnaci" placeholder="yyyy-mm-dd" value="<%= e.getFechaNacimiento() %>"><br>
                    </div>
                    <div class="col-md-3">
                        <label class="form-label">Telefono:</label>
                        <input type="text" class="form-control" name="txtTelefono" placeholder="0000-0000" value="<%= e.getTelefono() %>"><br>
                    </div>
                    <div class="col-md-4">
                        <label class="form-label">Genero:</label>
                        <select id="genero" name="genero" class="form-select" value="<%= e.getGenero() %>">
                        <option value="Masculino">M</option>
                        <option value="Femenino">F</option>
                    </select><br>
                    </div>
                    <div class="col-md-4">
                        <label class="form-label">Estado Civil:</label>
                        <select id="estadocivil" class="form-select" name="txtEstadoCivil" value="<%= e.getEstadoCivil() %>">
                        <option value="Soltero">Soltero</option>
                        <option value="Casado">Casado</option>
                        <option value="Divorciado">Divorciado</option>
                        <option value="Viudo">Viudo</option>
                        <option value="Acompallado">Acompallado</option>
                        </select>
                    </div>                    
                    <div class="col-md-7">
                        <label class="form-label">Correo:</label>
                        <input type="text" class="form-control" name="txtCorreo" placeholder="nombre.apellido@sastreria.com" value="<%= e.getCorreo() %>"><br>
                    </div>
                    <div class="col-md-7">
                        <label class="form-label">Cargo:</label> 
                        <select id="txtCargo" class="form-select" name="txtCargo" required>
                            <%          
                                CargoDAO cargoDAO = new CargoDAO(); 
                                List<Cargo> cargos = cargoDAO.listar();  
                            %>
                            <%
                                for (Cargo c : cargos) {
                            %>
                                <option value="<%= c.getId() %>"><%= c.getCargo() %></option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                    <input type="hidden" name="txtid" value="<%= e.getId() %>">
                    <div class="col-12">
                        <input class="btn btn-primary" type="submit" name="accion" value="Actualizar">
                        <a class="btn btn-primary" href="ControladorEmpleado?accion=listar">Regresar</a>
                    </div>                                        
                </form>
            </div>
            
        </div>
    </body>
</html>
