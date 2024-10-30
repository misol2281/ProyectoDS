package Entidad;

import java.sql.Date;

public class Empleados {
    int id;
    String Nombre;
    String Apellido;
    String DUI;
    Date FechaNacimiento;
    String Telefono;
    char Genero;
    String EstadoCivil;
    String Correo;

    public Empleados() {
    }

    public Empleados(String Nombre, String Apellido, String DUI, Date FechaNacimiento, String Telefono, char Genero, String EstadoCivil, String Correo) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.DUI = DUI;
        this.FechaNacimiento = FechaNacimiento;
        this.Telefono = Telefono;
        this.Genero = Genero;
        this.EstadoCivil = EstadoCivil;
        this.Correo = Correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getDUI() {
        return DUI;
    }

    public void setDUI(String DUI) {
        this.DUI = DUI;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public char getGenero() {
        return Genero;
    }

    public void setGenero(char Genero) {
        this.Genero = Genero;
    }

    public String getEstadoCivil() {
        return EstadoCivil;
    }

    public void setEstadoCivil(String EstadoCivil) {
        this.EstadoCivil = EstadoCivil;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    
    
}
