package org.example;

public class Estudiante {

    //Atributos
    private String nombre;
    private int edad;
    private double media;
    private boolean matriculado = true;

    //Constructor
    public Estudiante (String nombre, int edad, double media, boolean matriculado){
        this.nombre=nombre;
        this.edad=edad;
        this.media=media;
        this.matriculado=matriculado;
    }

    public Estudiante(){} //Constructor vacío

    //Getters
    public String getNombre() {return nombre;}
    public int getEdad() {return edad;}
    public double getMedia() {return media;}
    public boolean isMatriculado() {return matriculado;}

    //Setters
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setEdad(int edad) {this.edad = edad;}
    public void setMedia(double media) {this.media = media;}
    public void setMatriculado(boolean matriculado) {this.matriculado = matriculado;}

    //ToString para devolver los datos sin interacción con el usuario
    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", media=" + media +
                ", matriculado=" + matriculado +
                '}';
    }
}


