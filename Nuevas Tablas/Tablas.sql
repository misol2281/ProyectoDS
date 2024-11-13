use Sastreria;

create table Cargos(
	idCargo int primary key IDENTITY(1,1),
    Cargo varchar(30) not null
);

create table Roles(
	idRol int primary key IDENTITY(1,1),
    Rol varchar(50) not null
);

create table Opciones(
	idOpcion int primary key IDENTITY(1,1),
    Opcion varchar(50) not null
);

create table AsignacionRolesOpciones(
	idAsignacion int primary key IDENTITY(1,1),
    idRol int not null,
    idOpcion int not null,
	foreign key (idRol) references Roles(idRol),
	foreign key (idOpcion) references Opciones(idOpcion)
);

create table Usuarios(
	idUsuario int primary key IDENTITY(1,1),
    Usuario varchar(50) not null,
    Contra varchar(50) not null,
    idRol int not null,
    idEmpleado int not null,
	foreign key (idRol) references Roles(idRol),
	foreign key (idEmpleado) references Empleado(idEmpleado)
);

alter table Empleado add idCargo int;

alter table Empleado add foreign key (idCargo) references Cargos(idCargo);