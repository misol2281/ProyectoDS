package Interfaces;

import Entidad.Material;
import java.util.List;

public interface CRUDMaterial {
    public List listar();
    public Material list(int id);
    public boolean add(Material mat);
    public boolean edit(Material mat);
    public boolean eliminar(int id);
}
