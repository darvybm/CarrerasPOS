package edu.pucmm.eict.modelos;

public class Carrera {
    private String nombre;
    private String urlFoto;

    public Carrera(String nombre, String urlFoto) {
        this.nombre = nombre;
        this.urlFoto = urlFoto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}
