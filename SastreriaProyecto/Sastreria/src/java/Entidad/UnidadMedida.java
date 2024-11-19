package Entidad;

public class UnidadMedida {
    private int id;
    private String UnidadMedida;
    private String Descripcion;

    public UnidadMedida() {
    }

    public UnidadMedida(String UnidadMedida, String Descripcion) {
        this.UnidadMedida = UnidadMedida;
        this.Descripcion = Descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnidadMedida() {
        return UnidadMedida;
    }

    public void setUnidadMedida(String UnidadMedida) {
        this.UnidadMedida = UnidadMedida;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
}
