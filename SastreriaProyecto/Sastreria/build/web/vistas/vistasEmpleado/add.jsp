<%@page import="Entidad.Cargo"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.CargoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>AgregarEmpleado</title>
    </head>

    <body>
        <div class="container">
            <div class="col-lg-8">
                <h1>Agregar Empleado</h1>
                <form class="row g-3" action="ControladorEmpleado">
                    <div class="col-md-6">
                        <label class="form-label">Nombre:</label>
                        <input type="text" class="form-control" name="txtNombre" placeholder="Nombre">
                    </div>
                    <div class="col-md-6">
                        <label class="form-label">Apellido:</label>
                        <input type="text" class="form-control" name="txtApellido" placeholder="Apellido">
                    </div>
                    <div class="col-md-3">
                        <label class="form-label">DUI:</label>
                        <input type="text" class="form-control" name="txtdui" placeholder="0000000-0">
                    </div>
                    <div class="col-md-4">
                        <label class="form-label">Fecha Nacimiento:</label>
                        <input type="text" class="form-control" name="txtfnaci" placeholder="yyyy-mm-dd">
                    </div>
                    <div class="col-md-3">
                        <label class="form-label">Telefono:</label>
                        <input type="text" class="form-control" name="txtTelefono" placeholder="0000-0000">
                    </div>                        
                    <div class="col-md-4">
                        <label class="form-label">Genero:</label>
                        <select id="genero" class="form-select" name="genero">
                        <option value="Masculino">M</option>
                        <option value="Femenino">F</option>
                        </select>
                    </div>
                    <div class="col-md-4">
                        <label class="form-label">Estado Civil:</label>                     
                        <select id="estadocivil" class="form-select" name="estadocivil">
                        <option value="Soltero">Soltero</option>
                        <option value="Casado">Casado</option>
                        <option value="Divorciado">Divorciado</option>
                        <option value="Viudo">Viudo</option>
                        <option value="Acompallado">Acompallado</option>
                        </select>
                    </div>                        
                    <div class="col-md-7">
                        <label class="form-label">Correo:</label>
                        <input type="text" class="form-control" name="txtCorreo" placeholder="nombre.apellido@sastreria.com"><br>
                    </div>
                    <div class="col-md-7">
                        <label class="form-label">Cargo:</label> 
                        <select id="txtCargo" name="txtCargo" class="form-select" required>
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
                    <div class="col-12">
                        <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                        <a class="btn btn-primary" href="ControladorEmpleado?accion=listar">Regresar</a>
                    </div>
                </form>
            </div>
            
        </div>
    </body>
</html>
