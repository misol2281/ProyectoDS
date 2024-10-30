package Entidad;


public class MaterialUsar {
    int id;
    int idMaterial;
    int idDetalleOrden;
    int idUnidadMedida;
    String Caracteristicas;
    int Cantidad;
    float Precio;
    float SubTotal;

    public MaterialUsar() {
    }

    public MaterialUsar(int idMaterial, int idDetalleOrden, int idUnidadMedida, String Caracteristicas, int Cantidad, float Precio, float SubTotal) {
        this.idMaterial = idMaterial;
        this.idDetalleOrden = idDetalleOrden;
        this.idUnidadMedida = idUnidadMedida;
        this.Caracteristicas = Caracteristicas;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.SubTotal = SubTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public int getIdDetalleOrden() {
        return idDetalleOrden;
    }

    public void setIdDetalleOrden(int idDetalleOrden) {
        this.idDetalleOrden = idDetalleOrden;
    }

    public int getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(int idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public String getCaracteristicas() {
        return Caracteristicas;
    }

    public void setCaracteristicas(String Caracteristicas) {
        this.Caracteristicas = Caracteristicas;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public float getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(float SubTotal) {
        this.SubTotal = SubTotal;
    }
    
    
}
