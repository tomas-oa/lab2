import Comparators.ArtistComparator;
import Comparators.PopularityComparator;
import Comparators.SongComparator;
import Comparators.Track;
import Console.CLI;
import Sorts.HeapSort;
import Sorts.InsertionSort;
import Sorts.MergeSort;

import java.util.*;

public class Spotify {
    public static void main (String [] args) {
        // declaraciones necesarias :
        CSVReader reader = new CSVReader();
        CLI menu = new CLI();
        String path = "csv/artistas.csv";

        List<Track> tracks;
        tracks = reader.read(path);

        int option = menu.inicio();
        switch (option) {
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

    public static void ordenarTracks(List tracks, String algoritmo, String nombreColumna) {
        switch (nombreColumna) {
            case "artista":
                switch (algoritmo) {
                    case "insertionsort" -> {
                        InsertionSort is = new InsertionSort();

                        long msStart = System.currentTimeMillis();
                        tracks = is.sort(tracks, new ArtistComparator());
                        long msEnd = System.currentTimeMillis();
                        long total = msEnd - msStart;

                        System.out.println(algoritmo + " " + nombreColumna + " demoró: " + total + "ms");
                    }
                    case "heapsort" -> {
                        HeapSort hs = new HeapSort();

                        long msStart = System.currentTimeMillis();
                        tracks = hs.sort(tracks, new ArtistComparator());
                        long msEnd = System.currentTimeMillis();
                        long total = msEnd - msStart;

                        System.out.println(algoritmo + " " + nombreColumna + " demoró: " + total + "ms");
                    }
                    case "mergesort" -> {
                        MergeSort ms = new MergeSort();

                        long msStart = System.currentTimeMillis();
                        tracks = ms.sort(tracks, new ArtistComparator());
                        long msEnd = System.currentTimeMillis();
                        long total = msEnd - msStart;

                        System.out.println(algoritmo + " " + nombreColumna + " demoró: " + total + "ms");
                    }
                }
                break;

            case "popularidad":
                switch (algoritmo) {
                    case "insertionsort" -> {
                        InsertionSort is = new InsertionSort();

                        long msStart = System.currentTimeMillis();
                        tracks = is.sort(tracks, new PopularityComparator());
                        long msEnd = System.currentTimeMillis();
                        long total = msEnd - msStart;

                        System.out.println(algoritmo + " " + nombreColumna + " demoró: " + total + "ms");
                    }
                    case "heapsort" -> {
                        HeapSort hs = new HeapSort();

                        long msStart = System.currentTimeMillis();
                        tracks = hs.sort(tracks, new PopularityComparator());
                        long msEnd = System.currentTimeMillis();
                        long total = msEnd - msStart;

                        System.out.println(algoritmo + " " + nombreColumna + " demoró: " + total + "ms");
                    }
                    case "mergesort" -> {
                        MergeSort ms = new MergeSort();

                        long msStart = System.currentTimeMillis();
                        tracks = ms.sort(tracks, new PopularityComparator());
                        long msEnd = System.currentTimeMillis();
                        long total = msEnd - msStart;

                        System.out.println(algoritmo + " " + nombreColumna + " demoró: " + total + "ms");
                    }
                }
                break;

            case "cancion":
                switch (algoritmo) {
                    case "insertionsort" -> {
                        InsertionSort is = new InsertionSort();

                        long msStart = System.currentTimeMillis();
                        tracks = is.sort(tracks, new SongComparator());
                        long msEnd = System.currentTimeMillis();
                        long total = msEnd - msStart;

                        System.out.println(algoritmo + " " + nombreColumna + " demoró: " + total + "ms");
                    }
                    case "heapsort" -> {
                        HeapSort hs = new HeapSort();

                        long msStart = System.currentTimeMillis();
                        tracks = hs.sort(tracks, new SongComparator());
                        long msEnd = System.currentTimeMillis();
                        long total = msEnd - msStart;

                        System.out.println(algoritmo + " " + nombreColumna + " demoró: " + total + "ms");
                    }
                    case "mergesort" -> {
                        MergeSort ms = new MergeSort();

                        long msStart = System.currentTimeMillis();
                        tracks = ms.sort(tracks, new SongComparator());
                        long msEnd = System.currentTimeMillis();
                        long total = msEnd - msStart;

                        System.out.println(algoritmo + " " + nombreColumna + " demoró: " + total + "ms");
                    }
                }
                break;
        }
    }
}