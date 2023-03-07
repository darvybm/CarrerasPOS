package edu.pucmm.eict;

import edu.pucmm.eict.modelos.Carrera;
import edu.pucmm.eict.modelos.Usuario;

import java.util.ArrayList;

public class CarritoPos{
    private static CarritoPos instancia;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Carrera> carreras;

    private CarritoPos(){
        usuarios = new ArrayList<>();
        carreras = new ArrayList<>();
    }

    public static CarritoPos getInstance(){
        if(instancia==null){
            instancia = new CarritoPos();
        }
        return instancia;
    }


    public void addUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public ArrayList<Usuario> getUsuarios(){
        return usuarios;
    }

    public void addCarrera(Carrera carrera){
        carreras.add(carrera);
    }

    public ArrayList<Carrera> getCarreras(){
        return carreras;
    }

}
