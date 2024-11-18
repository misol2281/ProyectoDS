INSERT INTO Cargos (Cargo) VALUES 
    ('SysAdmin'),
    ('Gerente'),
    ('RRHH'),
    ('Sastre'),
    ('Cortador'),
    ('Costurero'),
    ('Diseñador'),
    ('Atencion al cliente');

INSERT INTO Roles (Rol) VALUES
	('SysAdmin'),
	('Gerente'),
    ('RRHH'),
	('Atencion al cliente'),
	('Cortador'),
    ('Diseñador'),
    ('Sastre'),
    ('Costurero');

INSERT INTO Opciones (Opcion) VALUES
	('Gestionar Cargos'),
	('Gestionar Clientes'),
	('Gestionar Orden'),
	('Gestionar DetalleOrden'),
	('Gestionar Empleados'),
	('Gestionar EstiloRopa'),
	('Gestionar Material'),
	('Gestionar MaterialUsar'),
	('Gestionar Medida'),
	('Gestionar TipoMedida'),
	('Gestionar TipoTrabajo'),
	('Gestionar UnidadMedida'),
	('Gestionar Roles'),
	('Gestionar AsignaciondeRoles'),
	('Gestionar Usuarios'),
	('Gestionar Opciones');

INSERT INTO AsignacionRolesOpciones (idRol, idOpcion) VALUES
	('');

INSERT INTO Usuarios (Usuario, Contra, idRol, idEmpleado) VALUES
	('');