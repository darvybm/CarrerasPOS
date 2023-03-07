package edu.pucmm.eict.modelos;

public class Usuario {

    private String nombre;
    private String sexo;
    private int edad;
    private Carrera carrera;

    public Usuario(String nombre, String sexo, int edad, Carrera carrera) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}
