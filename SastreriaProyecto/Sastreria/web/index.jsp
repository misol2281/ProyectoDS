
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>MENU</title>
    </head>
    <body>
        <div class='dashboard'>
        <div class="dashboard-nav">
        <header>
            <a href="#!" class="menu-toggle"><i class="fas fa-bars"></i></a>
            <a href="#" class="brand-logo"><i class="fas fa-anchor"></i> 
            <span>BRAND</span></a>
        </header>
        <nav class="dashboard-nav-list">
            <a href="index.jsp" class="dashboard-nav-item"><i class="fas fa-home"></i> Home </a>
            <a href="ControladorCliente?accion=listar" class="dashboard-nav-item active"><i class="fas fa-tachometer-alt"></i> Lista de Clientes</a>                                                                              
        <div>
            
            <br>
            <a href="ControladorMaterialUsar?accion=listar">Lista de Material a Usar</a>
            <br>
            <a href="ControladorEmpleado?accion=listar">Lista de Empleados</a>
            <br>
            <a href="ControladorCargo?accion=listar">Lista de Cargos</a>
            <br>
            <a href="ControladorRoles?accion=listar">Lista de Roles</a>
            <br>
            <a href="ControladorMaterial?accion=listar">Lista de Materiales</a>
            <br>
            <a href="ControladorUnidadMedida?accion=listar">Lista de UnidadMedida</a>
        </div>
    </body>
</html>
