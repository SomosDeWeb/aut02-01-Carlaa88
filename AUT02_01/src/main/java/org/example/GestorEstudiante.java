package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//Clase controladora
public class GestorEstudiante {

    private ArrayList<Estudiante>estudiantes; //Guardo objetos de tipo estudiante

    //Constructor
    public GestorEstudiante(){
        this.estudiantes = new ArrayList<>();
    }

    public void crearEstudiante(Estudiante nuevoEstudiante) {
       if(nuevoEstudiante==null){return;} //Compruebo que no sea null
       estudiantes.add(nuevoEstudiante); //Añado el estudiante al ArrayList
    }

    public ArrayList<Estudiante> listarEstudiante() {
        return estudiantes; //Devuelvo toda la lista de estudiantes
    }

    public Estudiante buscarEstudiante(String nombre) {
        for(int i=0; i<estudiantes.size();i++){
            if(estudiantes.get(i).getNombre().equalsIgnoreCase(nombre)){
              return estudiantes.get(i); //si hay coincidencia devuelve ese nombre
            }
        }
       return null; //si no coincide, null
    }

    public double calcularMedia() {
        double suma = 0;
        if(estudiantes.isEmpty()){return -1;} //devuelvo -1 para indicar que no hay datos si este está vacío
        for(int i=0; i<estudiantes.size();i++){
            suma+=estudiantes.get(i).getMedia(); //sumo todas las medias individuales
        }
        return suma/estudiantes.size(); // divido entre el número total de estudiantes
    }

    public Estudiante mejorNota() {
        if(estudiantes.isEmpty()){return null;} //Si está vacía devuelve null
        Estudiante mejor = estudiantes.get(0); //Inicializo mejor con el primer estudiante para comenzar con la comparación
        for(int i=1; i<estudiantes.size();i++){ //comparo todas las medias
            double mediaActual = estudiantes.get(i).getMedia(); //obtengo la media del estudiante actual
            if(mediaActual > mejor.getMedia()) {
                mejor = estudiantes.get(i); //actualizo 'mejor' si la media actual es mayor.
            }
        }
        return mejor; //devuelvo el estudiante con mejor media
    }
}
