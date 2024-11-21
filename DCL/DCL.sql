Use Sastreria;

-- Creacion de roles
CREATE ROLE SysAdmin;
CREATE ROLE Gerente;
CREATE ROLE RRHH;
CREATE ROLE AtencioAlCliente;
CREATE ROLE Cortador;
CREATE ROLE Diseñador;
CREATE ROLE Sastre;
CREATE ROLE Costurero;

-- Asignacion de permisos

-- SysAdmin
use Sastreria;
GRANT CONTROL ON DATABASE:: Sastreria TO SysAdmin;

-- Permisos de Gerente
use Sastreria;
-- CLIENTE
GRANT SELECT ON Cliente TO Gerente;
GRANT INSERT ON Cliente TO Gerente;
GRANT UPDATE ON Cliente TO Gerente;
GRANT DELETE ON Cliente TO Gerente;
-- EMPLEADO
GRANT SELECT ON Empleado TO Gerente;
GRANT INSERT ON Empleado TO Gerente;
GRANT UPDATE ON Empleado TO Gerente;
GRANT DELETE ON Empleado TO Gerente;
-- Cargos
GRANT SELECT ON Cargos TO Gerente;
GRANT UPDATE ON Cargos TO Gerente;
-- TipoTrabajo
GRANT SELECT ON TipoTrabajo TO Gerente;
GRANT INSERT ON TipoTrabajo TO Gerente;
GRANT UPDATE ON TipoTrabajo TO Gerente;
GRANT DELETE ON TipoTrabajo TO Gerente;
-- EstiloRopa
GRANT SELECT ON EstiloRopa TO Gerente;
GRANT INSERT ON EstiloRopa TO Gerente;
GRANT UPDATE ON EstiloRopa TO Gerente;
GRANT DELETE ON EstiloRopa TO Gerente;
-- UnidadMedida
GRANT SELECT ON UnidadMedida TO Gerente;
GRANT INSERT ON UnidadMedida TO Gerente;
GRANT UPDATE ON UnidadMedida TO Gerente;
GRANT DELETE ON UnidadMedida TO Gerente;
-- TipoMedida
GRANT SELECT ON TipoMedida TO Gerente;
GRANT INSERT ON TipoMedida TO Gerente;
GRANT UPDATE ON TipoMedida TO Gerente;
GRANT DELETE ON TipoMedida TO Gerente;
-- Orden
GRANT SELECT ON Orden TO Gerente;
GRANT INSERT ON Orden TO Gerente;
GRANT UPDATE ON Orden TO Gerente;
GRANT DELETE ON Orden TO Gerente;
-- Detalle Orden
GRANT SELECT ON DetalleOrden TO Gerente;
GRANT INSERT ON DetalleOrden TO Gerente;
GRANT UPDATE ON DetalleOrden TO Gerente;
GRANT DELETE ON Orden TO Gerente;
-- Material
GRANT SELECT ON Material TO Gerente;
GRANT INSERT ON Material TO Gerente;
GRANT UPDATE ON Material TO Gerente;
GRANT DELETE ON Material TO Gerente;
-- MaterialUsar
GRANT SELECT ON MaterialUsar TO Gerente;
GRANT INSERT ON MaterialUsar TO Gerente;
GRANT UPDATE ON MaterialUsar TO Gerente;
GRANT DELETE ON MaterialUsar TO Gerente;
-- Medida
GRANT SELECT ON Medida TO Gerente;
GRANT INSERT ON Medida TO Gerente;
GRANT UPDATE ON Medida TO Gerente;
GRANT DELETE ON Medida TO Gerente;

-- Permisos de RRHH
-- Empleados
GRANT SELECT ON Empleado TO RRHH;
GRANT INSERT ON Empleado TO RRHH;
GRANT UPDATE ON Empleado TO RRHH;
-- Cargos
GRANT SELECT ON Cargos TO RRHH;

-- Permisos Atencion al Cliente
-- Cliente
GRANT SELECT ON Cliente TO AtencioAlCliente;
GRANT INSERT ON Cliente TO AtencioAlCliente;
GRANT UPDATE ON Cliente TO AtencioAlCliente;
-- Orden
GRANT SELECT ON Orden TO AtencioAlCliente;
GRANT INSERT ON Orden TO AtencioAlCliente;
GRANT UPDATE ON Orden TO AtencioAlCliente;
-- DetalleOrden
GRANT SELECT ON Orden TO AtencioAlCliente;
GRANT INSERT ON Orden TO AtencioAlCliente;
GRANT UPDATE ON Orden TO AtencioAlCliente;

-- Permisos de Cortador
-- Medida
GRANT SELECT ON Medida TO Cortador;
-- Detalle Orden
GRANT SELECT ON DetalleOrden TO Cortador;

-- Permisos Diseñador
-- DetalleOrden
GRANT SELECT ON DetalleOrden TO Diseñador;
-- EstiloRopa
GRANT SELECT ON EstiloRopa TO Diseñador;
GRANT INSERT ON EstiloRopa TO Diseñador;
GRANT UPDATE ON EstiloRopa TO Diseñador;
-- Medida
GRANT SELECT ON Medida TO Diseñador;
-- Material
GRANT SELECT ON Material TO Diseñador;
-- Material Usar
GRANT SELECT ON MaterialUsar TO Diseñador;
GRANT INSERT ON MaterialUsar TO Diseñador;
GRANT UPDATE ON MaterialUsar TO Diseñador;

-- Permisos Sastre
-- DetalleOrden
GRANT SELECT ON DetalleOrden TO Sastre;
-- Medida
GRANT SELECT ON Medida TO Sastre;
-- Material
GRANT SELECT ON Material TO Sastre;
-- Material Usar
GRANT SELECT ON MaterialUsar TO Sastre;
GRANT UPDATE ON MaterialUsar TO Sastre;
-- EstiloRopa
GRANT SELECT ON EstiloRopa TO Sastre;

-- Permisos Costurero
-- DetalleOrden
GRANT SELECT ON DetalleOrden TO Costurero;
-- Medida
GRANT SELECT ON Medida TO Costurero;
-- Material Usar
GRANT SELECT ON MaterialUsar TO Costurero;