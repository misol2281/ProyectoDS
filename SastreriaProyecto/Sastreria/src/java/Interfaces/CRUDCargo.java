package Interfaces;

import java.util.List;
import Entidad.Cargo;

public interface CRUDCargo {
    public List listar();
    public Cargo list(int id);
    public boolean add(Cargo car);
    public boolean edit(Cargo car);
    public boolean eliinar(int id);
}
