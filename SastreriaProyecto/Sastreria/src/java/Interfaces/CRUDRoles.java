package Interfaces;

import java.util.List;
import Entidad.Roles;

public interface CRUDRoles {
    public List listar();
    public Roles list(int id);
    public boolean add(Roles rol);
    public boolean edit(Roles rol);
    public boolean eliminar(int id);
}
