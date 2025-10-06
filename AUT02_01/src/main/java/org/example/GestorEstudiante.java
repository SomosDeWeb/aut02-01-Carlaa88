package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorEstudiante {

    private ArrayList<Estudiante>estudiantes;

    public GestorEstudiante(){
        this.estudiantes = new ArrayList<>();
    }

    public void crearEstudiante(Estudiante nuevoEstudiante) {
       if(nuevoEstudiante==null){return;}
       estudiantes.add(nuevoEstudiante);
    }

    public ArrayList<Estudiante> listarEstudiante() {
        return estudiantes;
    }

    public Estudiante buscarEstudiante(String nombre) {

        for(int i=0; i<estudiantes.size();i++){
            if(estudiantes.get(i).getNombre().equalsIgnoreCase(nombre)){
              return estudiantes.get(i); //si se encuentra
            }
        }
       return null; //si no se encuentra
    }

    public double calcularMedia() {
        double suma = 0;
        if(estudiantes.isEmpty()){return -1;}
        for(int i=0; i<estudiantes.size();i++){
            suma+=estudiantes.get(i).getMedia();
        }
        return suma/estudiantes.size();
    }

    public Estudiante mejorNota() {
        Estudiante mejor = estudiantes.get(0);
        if(estudiantes.isEmpty()){return null;}
        for(int i=0; i<estudiantes.size();i++){
            if(estudiantes.get(i).getMedia() > mejor.getMedia()) {
                mejor = estudiantes.get(i);
            }
        }
        return mejor;
    }
}
