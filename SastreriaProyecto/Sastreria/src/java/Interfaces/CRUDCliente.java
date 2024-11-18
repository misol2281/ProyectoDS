
package Interfaces;

import java.util.List;
import Entidad.Cliente;

public interface CRUDCliente {
    public List listar();
    public Cliente list(int id);
    public boolean add(Cliente cli);
    public boolean edit(Cliente cli);
    public boolean eliminar(int id);
}
