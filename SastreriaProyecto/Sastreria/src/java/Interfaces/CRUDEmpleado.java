
package Interfaces;

import java.util.List;
import Entidad.Empleados;

public interface CRUDEmpleado {
    public List listar();
    public Empleados list(int id);
    public boolean add(Empleados emp);
    public boolean edit(Empleados emp);
    public boolean eliminar(int id);
}
