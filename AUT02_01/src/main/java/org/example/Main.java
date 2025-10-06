package org.example;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GestorEstudiante gestor = new GestorEstudiante();
        gestionarMenu(gestor);
    }

    public static void gestionarMenu(GestorEstudiante gestor){
        Scanner listaOpciones = new Scanner(System.in); //Recojo las respuestas

        boolean salir = false;
        String select;
        int opcion = 0;

        do{
            System.out.println();
            menu();
            do{
                System.out.print("Elige una opción (1-6):\n");
                try{
                    select = listaOpciones.nextLine();
                    opcion = Integer.parseInt(select);
                    if(opcion<1||opcion>6){
                        System.out.println("Opción no válida. Debe ser entre 1 y 6. Prueba de nuevo");
                    }
                }catch (Exception e){
                    System.out.println("Debes introducir un número entero");
                    opcion = 0; //aseguro que siga el bucle
                }
            }while(opcion<1||opcion>6);

            switch (opcion) {
                case 1:
                    añadirEstudiante(gestor, listaOpciones);
                    break;
                case 2:
                    ArrayList<Estudiante>lista=gestor.listarEstudiante();
                    if (lista.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.\n");
                    } else {
                        System.out.println("=== Lista de Estudiantes ===");
                        for (int i = 0; i < lista.size(); i++) {
                            System.out.println((i + 1) + ". " + lista.get(i));
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                     buscarEstudiante(gestor, listaOpciones);
                    break;
                case 4:
                    double mediaGeneral = gestor.calcularMedia();
                    if (mediaGeneral == -1) {
                        System.out.println("No hay estudiantes registrados.\n");
                    } else {
                        System.out.println("La media general de los estudiantes es: "
                                + Math.round(mediaGeneral * 100.0) / 100.0 + "\n");

                    }
                    break;
                case 5:
                    Estudiante mayorNota = gestor.mejorNota();
                    if(mayorNota!=null){
                        System.out.println("El estudiante con mejor nota es: " + mayorNota + "\n");
                    }else{
                        System.out.println("No hay estudiantes registrados.\n");
                    }
                    break;
                case 6:
                    salir = true; //arreglar
                    System.out.print("Has salido del programa");
            }
        }while(!salir);


    }

    public static void menu(){
        System.out.println("===Gestor de Estudiantes===");
        System.out.println("1. Añadir estudiante");
        System.out.println("2. Listar estudiante");
        System.out.println("3. Buscar estudiante por nombre");
        System.out.println("4. Calcular nota media general");
        System.out.println("5. Mostrar estudiante con mejor nota");
        System.out.println("6. Salir");
    }

    public static void añadirEstudiante(GestorEstudiante gestor, Scanner sc){
        String nombre;
        int edad;
        double media;

        //Validar nombre
        do{
            System.out.print("Nombre: ");
            nombre = sc.nextLine().trim();
            if(!nombreValido(nombre)){
                System.out.println("El nombre no puede estar vacío. Solo puede contener letras y espacios.");
            }

            //Comprobar si ya existe el nombre
            if(gestor.buscarEstudiante(nombre)!=null){
                System.out.println("Ya existe un estudiante con ese nombre. No se añadirá otro igual.\n");
                nombre = "";
            }

        }while(!nombreValido(nombre));

       //Validar edad
        do {
            System.out.print("Edad: ");
            while (!sc.hasNextInt()) {
                System.out.println("Debes introducir un número entero para la edad.");
                sc.next(); // descarta entrada incorrecta
            }
            edad = sc.nextInt();
            if (edad <= 0) {
                System.out.println("La edad debe ser mayor que cero.");
            }
            sc.nextLine(); // limpiar salto de línea pendiente
        }while(edad<=0);

        //Validar media
        do{
            System.out.print("Media: ");
            while (!sc.hasNextDouble()) {
                System.out.println("Debes introducir un número decimal para la media.");
                sc.next();
            }
            media = sc.nextDouble();
            if (media < 0 || media > 10) {
                System.out.println("La media debe estar entre 0 y 10.");
            }

        }while(media < 0 || media > 10);

        sc.nextLine(); // limpiar buffer

        //Crear un estudiante
        Estudiante nuevo = new Estudiante(nombre, edad, media, true);
        gestor.crearEstudiante(nuevo);

        System.out.println("Estudiante añadido correctamente.\n");

    }

    public static void buscarEstudiante(GestorEstudiante gestor, Scanner sc) {
        System.out.print("Introduce el nombre a buscar: ");
        String nombre = sc.nextLine();
        Estudiante estudiante = gestor.buscarEstudiante(nombre);
        if (estudiante != null) {
            System.out.println("Estudiante encontrado: " + estudiante + "\n");
        } else {
            System.out.println("No se ha encontrado ningún estudiante.\n");
        }
    }

    //VALIDACIONES
    public static boolean nombreValido(String nombre)
    {
        char c;
        if(nombre.isEmpty()) return false;
        for(int i=0; i<nombre.length(); i++) {
            c = nombre.charAt(i);
            if(!Character.isLetter(c) && c != ' '){
                return false;
            }
        }
        return true;
    }



}


