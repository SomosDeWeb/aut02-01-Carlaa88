package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GestorEstudiante gestor = new GestorEstudiante(); //creo un objeto gestor que va a guardar la lista de estudiantes
        gestionarMenu(gestor); //llamada que se encarga de mostrar el menú y sus interacciónes con el usuario y le paso el gestor
    }

    public static void gestionarMenu(GestorEstudiante gestor){
        Scanner listaOpciones = new Scanner(System.in); //Recojo los datos que escribe el usuario

        boolean salir = false;
        String select;
        int opcion = 0;

        //utilizo do...while en ambas ocasiones ya que cada bucle se debe realizar al menos una vez
        do{
            System.out.println(); //salto de línea para que visualmente quede más limpio
            menu(); //llamada para mostrar el menú
            do{
                System.out.print("Elige una opción (1-6):\n");
                //compruebo que la opcion que se inserte sea la correcta
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
                    ArrayList<Estudiante>lista=gestor.listarEstudiante(); //pido lista completa
                    if (lista.isEmpty()) { // donde comprueba si está vacía
                        System.out.println("No hay estudiantes registrados.\n");
                    } else { //sino la recorre e imprime
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
                    double mediaGeneral = gestor.calcularMedia(); //llamada al gestor
                    if (mediaGeneral == -1) {
                        System.out.println("No hay estudiantes registrados.\n");
                    } else { //sin no está vacía, muestra la media redondeada a dos decimales
                        System.out.println("La media general de los estudiantes es: " + Math.round(mediaGeneral * 100.0) / 100.0 + "\n");
                    }
                    break;
                case 5:
                    Estudiante mayorNota = gestor.mejorNota(); //llamada al gestor
                    if(mayorNota!=null){
                        System.out.println("El estudiante con mejor nota es: " + mayorNota);
                    }else{
                        System.out.println("No hay estudiantes registrados.\n");
                    }
                    break;
                case 6:
                    salir = true; //al cambiar el valor de la variable sale del programa y avisa al usuario
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

    //CASO 1
    public static void añadirEstudiante(GestorEstudiante gestor, Scanner sc){
        String nombre;
        int edad;
        double media;

        //Validar nombre
        do{
            System.out.print("Nombre: ");
            nombre = sc.nextLine().trim();
            if(!textoValido(nombre)){
                System.out.println("El nombre no puede estar vacío. Solo puede contener letras y espacios.");
            }
            //Comprobar si ya existe el nombre
            if(gestor.buscarEstudiante(nombre)!=null){
                System.out.println("Ya existe un estudiante con ese nombre. No se añadirá otro igual.\n");
                nombre = "";
            }
        }while(!textoValido(nombre));

       //Validar edad (mayor que 0 y entero)
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

        //Validar media (nºdecimal entre 0 y 10)
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

        //Crear y guardar un estudiante
        Estudiante nuevo = new Estudiante(nombre, edad, media, true);
        gestor.crearEstudiante(nuevo);

        System.out.println("Estudiante añadido correctamente.");

    }

    //CASO 2
    public static void buscarEstudiante(GestorEstudiante gestor, Scanner sc) {
        System.out.print("Introduce el nombre a buscar: ");
        String nombre = sc.nextLine();
        Estudiante estudiante = gestor.buscarEstudiante(nombre); //busco en la lista llamando al gestor
        if (estudiante != null) {
            System.out.println("Estudiante encontrado: " + estudiante + "\n");
        } else {
            System.out.println("No se ha encontrado ningún estudiante.\n");
        }
    }

    //VALIDACIONES
    public static boolean textoValido(String nombre)
    {
        char c; //caracter
        if(nombre.isEmpty()) return false; // si el texto introducido "nombre" está vacío se vuelve a intentar
        for(int i=0; i<nombre.length(); i++) { //recorremos cada caracter del nombre
            c = nombre.charAt(i); //devuelvo el char que está en la posición i de la cadena "nombre" en este caso y la guarda en c para analizarlo
            if(!Character.isLetter(c) && c != ' '){ //comparativa según esta condición
                return false; //si "c" no es una letra devuelve o un espacio devuelve false y no sería un texto válido
            }
        }
        return true;
    }

}


