import java.util.*;
import java.io.*;

public class CLI {
    public static void options() {
        Scanner scanner = new Scanner(System.in);

        int opcion1, opcion2, opcion3;

        while(true) {

            System.out.println("*********");
            System.out.println("MÉTODOS DE ORDENAMIENTO");
            System.out.println("*********");
            System.out.println("1.- Ordenar canciones");
            System.out.println("0.- Salir del menu");
            System.out.println("________");
            opcion1 = scanner.nextInt();


            //errores
            if(opcion1 == 0){ break; }

            if(opcion1 < 1 || opcion1 > 1)
            {
                System.out.println("Opcion incorrecta.");
                break;
            }

            Clear.clearConsole();

            System.out.println("Escoga el método de ordenamiento: ");
            System.out.println("1.- Merge Sort");
            System.out.println("2.- Heap Sort");
            System.out.println("3.- Insertion Sort");

            opcion2 = scanner.nextInt();

            if(opcion2 < 1 || opcion2 > 3)
            {
                System.out.println("Opcion incorrecta.");
                break;
            }

            Clear.clearConsole();

            System.out.println("Escoga según qué base ordenar: ");
            System.out.println("1.- Nombre del artista.");
            System.out.println("2.- Nombre de canción.");
            System.out.println("3.- Popularidad.");

            opcion3 = scanner.nextInt();

            if(opcion3 < 1 || opcion3 > 3)
            {
                Clear.clearConsole();
                System.out.println("Opcion incorrecta.");
                break;
            }

            // 1: artista - 2: cancion - 3: popularidad

            if(opcion2 == 1) // merge
            {
                Clear.clearConsole();
            }
            if(opcion2 == 2) // heap
            {
                Clear.clearConsole();
            }
            if(opcion2 == 3) // selection
            {
                Clear.clearConsole();
            }
        }
    }
}
