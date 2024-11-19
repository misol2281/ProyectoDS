package Entidad;

public class Cargo {
    private int id;
    private String Cargo;

    public Cargo() {
    }

    public Cargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }
    
    
}
