package org.example;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
            mostrarMenu();
    }

    //controlar : nombre vacios, nombre de solo letras, edades o notas negativas, opciones de menú fuera de rango,
    //nombres repetidos ? cómo los buscamos?
    //se buscan subcadenas del nombre ?


    public static void mostrarMenu(){
        Scanner listaOpciones = new Scanner(System.in); //Recojo las respuestas
        boolean salir = true;
        int opcion;

        do{
            System.out.println("===Gestor de Estudiantes===");
            System.out.println("1. Añadir estudiante");
            System.out.println("2. Listar estudiante");
            System.out.println("3. Buscar estudiante por nombre");
            System.out.println("4. Calcular nota media general");
            System.out.println("5. Mostrar estudiante con mejor nota");
            System.out.println("6. Salir");

            System.out.print("Elige una opción:\n");
            opcion = listaOpciones.nextInt();
//            if(opcion>=1 && opcion<=6)
//            {
//
//            }

            listaOpciones.nextLine(); //limpiar buffer

            switch (opcion) {
                case 1:
//                    crearEstudiante();
                    break;
                case 2:
//                    listarEstudiante();
                    break;
                case 3:
//                    buscarEstudiante();
                    break;
                case 4:
//                    calcularMedia();
                    break;
                case 5:
//                    mejorNota();
                    break;
                case 6:
                    salir = false; //arreglar
                    System.out.print("Has salido del programa");
            }
        }while(salir);

    }

}


