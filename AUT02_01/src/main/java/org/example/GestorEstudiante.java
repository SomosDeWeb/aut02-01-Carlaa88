package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorEstudiante {

    private ArrayList<Estudiante>estudiantes;
    double suma = 0;

    public GestorEstudiante(){
        this.estudiantes = new ArrayList<>();
    }

    public void crearEstudiante(Estudiante nuevoEstudiante) {
       if(nuevoEstudiante==null){return;}
       estudiantes.add(nuevoEstudiante);
    }

//    private static void listarEstudiante() {
//    }

    public Estudiante buscarEstudiante(String nombre) {

        for(int i=0; i<estudiantes.size();i++){
            if(estudiantes.get(i).getNombre().equalsIgnoreCase(nombre)){
              return estudiantes.get(i); //si se encuentra
            }
        }
       return null; //si no se encuentra
    }

//    public double calcularMedia() {}
//    private static void mejorNota() {
//    }
}
