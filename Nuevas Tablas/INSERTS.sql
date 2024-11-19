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
	 (8, 4), -- Gestionar DetalleOrden
    (8, 7), -- Gestionar Material
    (8, 8); -- Gestionar MaterialUsar

INSERT INTO Usuarios (Usuario, Contra, idRol, idEmpleado) VALUES
	('grnMaria', 'mari123', '2', '3'),
	('rrhhCarlos','carlos456','3','4'),
	('atcAna','ana789','4','5'),
	('ctrLuis','luis123','5','6'),
	('dsrSofia','sofi256','6','7');