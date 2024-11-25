<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!-- Enlace a Bootstrap JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css">
        <title>Menu</title>
    </head>
    <body>
        <div class='dashboard'>
        <div class="dashboard-nav">
            <header>
                <a href="#!" class="menu-toggle"><i class="fas fa-bars"></i></a>
                <a href="#" class="brand-logo"><i class="fas fa-anchor"></i> <span>Sastreria</span></a>
            </header>
            <nav class="dashboard-nav-list">
                <a href="menu.jsp" class="dashboard-nav-item"><i class="fas fa-home"></i> Home </a>
                <a href="#" class="dashboard-nav-item active"><i class="fas fa-tachometer-alt"></i> Perfil</a>
                
                <div class='dashboard-nav-dropdown'>
                    <a href="#!" class="dashboard-nav-item dashboard-nav-dropdown-toggle"><i class="fas fa-photo-video"></i> Administrar </a>
                    <div class='dashboard-nav-dropdown-menu'>
                        <a href="ControladorCargo?accion=listar" class="dashboard-nav-dropdown-item">Cargos</a>
                        <a href="ControladorEmpleado?accion=listar" class="dashboard-nav-dropdown-item">Empleados</a>
                        <a href="ControladorRoles?accion=listar" class="dashboard-nav-dropdown-item">Roles</a>                        
                        <a href="CtrlUsuario?accion=listar" class="dashboard-nav-dropdown-item">Usuarios</a>
                    </div>
                </div>
                <div class='dashboard-nav-dropdown'>
                    <a href="#!" class="dashboard-nav-item dashboard-nav-dropdown-toggle"><i class="fas fa-users"></i> Ordenes </a>
                    <div class='dashboard-nav-dropdown-menu'>
                        <a href="CtrlOrden?accion=listar" class="dashboard-nav-dropdown-item">Orden</a>
                        <a href="CtrlDetOrden?accion=listar" class="dashboard-nav-dropdown-item">Detalle Orden</a>
                        <a href="ControladorCliente?accion=listar" class="dashboard-nav-dropdown-item">Clientes</a>                        
                    </div>
                </div>
                <div class='dashboard-nav-dropdown'>
                    <a href="#!" class="dashboard-nav-item dashboard-nav-dropdown-toggle"><i class="fas fa-money-check-alt"></i> Elaboracion </a>
                    <div class='dashboard-nav-dropdown-menu'>
                        <a href="CtrlEstiloRopa?accion=listar" class="dashboard-nav-dropdown-item">Estilo de Ropa</a>
                        <a href="ControladorMaterial?accion=listar" class="dashboard-nav-dropdown-item">Material</a>
                        <a href="ControladorMaterialUsar?accion=listar" class="dashboard-nav-dropdown-item">Material a Usar</a>
                        <a href="CtrlTipoTrabajo?accion=listar" class="dashboard-nav-dropdown-item"> Tipo Trabajo</a>
                    </div>
                </div>
                <div class='dashboard-nav-dropdown'>
                    <a href="#!" class="dashboard-nav-item dashboard-nav-dropdown-toggle"><i class="fas fa-money-check-alt"></i> Medidas </a>
                    <div class='dashboard-nav-dropdown-menu'>
                        <a href="CtrlMedida?accion=listar" class="dashboard-nav-dropdown-item">Medida</a>
                        <a href="CtrlTipoMedida?accion=listar" class="dashboard-nav-dropdown-item">Tipo de Medida</a>
                        <a href="ControladorUnidadMedida?accion=listar" class="dashboard-nav-dropdown-item">Unidad de Medida</a>
                    </div>
                </div>
                <a href="about.jsp" class="dashboard-nav-item"><i class="fas fa-cogs"></i> About </a>
                <a href="#" class="dashboard-nav-item"><i class="fas fa-user"></i> Contact </a>
                <div class="nav-item-divider"></div>
                <a href="index.jsp" class="dashboard-nav-item"><i class="fas fa-sign-out-alt"></i> Logout </a>
            </nav>
        </div>
        <div class='dashboard-app'>
            <header class='dashboard-toolbar'>
                <a href="#!" class="menu-toggle"><i class="fas fa-bars"></i></a>
            </header>
            <div class='dashboard-content'>
                <div class='container'>
                    <div class='card'>
                        <div class='card-header'>
                            <h1>Bienvenido</h1>
                        </div>
                        <div class='card-body'>
                            <p>Your account type is: Administrator</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>           
        <script src="js/script.js"></script>
    </body>
</html>
