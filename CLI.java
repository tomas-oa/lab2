import java.util.*;

public class CLI {
    public static Integer inicio() {
        Scanner scanner = new Scanner(System.in);
        // Clear.clearConsole();

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
        // Clear.clearConsole();

        System.out.println("Por favor ingrese uno de los siguientes métodos de ordenamiento:");
        System.out.println("Merge sort");
        System.out.println("Heap sort");
        System.out.println("Insertion sort");
        String opcion = scanner.nextLine();

        // para evitar typos
        opcion = opcion.replaceAll("\\s", "");
        opcion = opcion.toLowerCase();

        return opcion;
    }

    public static String op2() {
        Scanner scanner = new Scanner(System.in);
        // Clear.clearConsole();

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
