import java.util.*;

public class Spotify {
    public static void main (String [] args) {
        CSVReader reader = new CSVReader();
        String path = "csv/testfile.csv";

        List<Track> tracks;
        AVLTree<Track> tree;

        tracks = reader.read(path);

        // AVL con los métodos solicitados: buscar, insertar, eliminar y range
        // implementación de esto en el archivo AVLTree
        tree = reader.readTree(path);

        int option = CLI.inicio();

        switch (option) {
            case 0 -> System.out.println("Adiós");
            case 1 -> {
                String algoritmo = CLI.op1();
                String nombreColumna = CLI.op2();
                ordenarTracks.ordenar(tracks, algoritmo, nombreColumna);
            }
            default -> System.out.println("Opción inválida");
        }
    }
}