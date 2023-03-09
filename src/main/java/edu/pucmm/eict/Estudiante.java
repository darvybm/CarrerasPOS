package edu.pucmm.eict;

public class Estudiante {
    public static int idEstudiante = 1;
    private int id;
    private String nombre;
    private String sexo;
    private int edad;
    private String provincia;
    private String carrera;

    public Estudiante(String nombre, String sexo, int edad, String provincia, String carrera) {
        this.id = Estudiante.idEstudiante;
        Estudiante.idEstudiante++;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.provincia = provincia;
        this.carrera = carrera;
    }

    public Estudiante() {};

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

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String generarBoleto() {
        String boleto = String.format(
                        "         OPEN HOUSE 2023         \n" +
                        "---------------ICC---------------\n" +
                        "ID:      %d                      \n" +
                        "Nombre:  %s                      \n" +
                        "Edad:    %d                      \n" +
                        "Sexo:    %s                      \n" +
                        "Carrera: %s                      \n" +
                        "---------------ICC---------------\n",
                        id, nombre, edad,sexo,carrera);

        return boleto;
    }
}
