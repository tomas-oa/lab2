import javax.naming.SizeLimitExceededException;
import java.sql.SQLSyntaxErrorException;
import java.util.*;
import java.io.*;

public class Spotify {
    public static void main (String [] args) {
        // declaraciones necesarias :
        CSVReader reader = new CSVReader();
        CLI menu = new CLI();
        String path = "csv/artistas.csv";
        ArrayList<Track> tracks;
        // sorts:
        SelectionSortGenerics ss = new SelectionSortGenerics();
        HeapSortGenerics hs = new HeapSortGenerics();
        MergeSortGenerics ms = new MergeSortGenerics();


        tracks = reader.read(path);
        int op = menu.inicio();

        switch (op) {
            case 0:
                System.out.println("Adiós");
                break;
            case 1:
                String algoritmo = menu.op1();
                String nombreColumna = menu.op2();

                ordenarTracks(tracks, algoritmo, nombreColumna);

                break;
            default:
                System.out.println("Opción inválida");
        }
    }

    public static void ordenarTracks(ArrayList<Track> tracks, String algoritmo, String nombreColumna) {
        Object[] tracksArray = tracks.toArray();
/*
        for(Object T : tracksArray) {
            Track track = (Track) T;

            track.print();
        }
 */
        
    }
}