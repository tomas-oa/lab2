import java.util.*;
import java.io.*;

public class CLI {
    public static Integer inicio() {
        Scanner scanner = new Scanner(System.in);
        Clear.clearConsole();

        System.out.println("*********");
        System.out.println("MÉTODOS DE ORDENAMIENTO");
        System.out.println("*********");
        System.out.println("0.- Salir");
        System.out.println("1.- Ordenar canciones");
        System.out.println("________");
        int opcion = scanner.nextInt();

        return opcion;
    }

    public static String op1() {
        Scanner scanner = new Scanner(System.in);
        Clear.clearConsole();

        System.out.println("Escoga el método de ordenamiento: ");
        System.out.println("1.- Merge Sort");
        System.out.println("2.- Heap Sort");
        System.out.println("3.- Insertion Sort");
        int opcion = scanner.nextInt();
        String metodo = "";

        if (opcion == 1) {
            metodo = "Merge";
        } else if (opcion == 2) {
            metodo = "Heap";
        } else if (opcion == 3) {
            metodo = "Insertion";
        } else {
            System.out.println("Opción inválida.");
        }

        return metodo;
    }

    public static String op2() {
        Scanner scanner = new Scanner(System.in);
        Clear.clearConsole();

        System.out.println("Escoga columna a ordenar: ");
        System.out.println("1.- Nombre del artista.");
        System.out.println("2.- Nombre de canción.");
        System.out.println("3.- Popularidad.");

        int opcion = scanner.nextInt();
        String columna = "";

        if (opcion == 1) {
            columna = "artista";
        } else if (opcion == 2) {
            columna = "cancion";
        } else if (opcion == 3) {
            columna = "popularidad";
        } else {
            System.out.println("Opción inválida.");
        }

        return columna;
    }
}
