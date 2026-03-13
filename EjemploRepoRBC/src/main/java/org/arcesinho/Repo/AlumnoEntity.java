package org.arcesinho.Repo;

public class AlumnoEntity {

    private int id;
    private String nombre;
    private String apellidos;
    private String dni;
    private int grupoid;

    public AlumnoEntity(int id, String nombre, String apellidos, String dni, int grupoid) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.grupoid = grupoid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getGrupoid() {
        return grupoid;
    }

    public void setGrupoid(int grupoid) {
        this.grupoid = grupoid;
    }
}
