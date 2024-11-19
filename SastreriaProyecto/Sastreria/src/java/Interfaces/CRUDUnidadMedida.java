package Interfaces;

import Entidad.UnidadMedida;
import java.util.List;


public interface CRUDUnidadMedida {
    public List listar();
    public UnidadMedida list(int id);
    public boolean add(UnidadMedida umd);
    public boolean edit(UnidadMedida umd);
    public boolean eliminar(int id);
}
