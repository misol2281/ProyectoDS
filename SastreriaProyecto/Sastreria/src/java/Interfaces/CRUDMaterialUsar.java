
package Interfaces;

import java.util.List;
import Entidad.MaterialUsar;

public interface CRUDMaterialUsar {
    public List listar();
    public MaterialUsar list(int id);
    public boolean add(MaterialUsar mu);
    public boolean edit(MaterialUsar mu);
    public boolean eliminar(int id);
    
}
