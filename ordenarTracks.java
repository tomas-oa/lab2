import java.util.List;

public class ordenarTracks {
    public static void ordenar(List<Track> tracks, String algoritmo, String nombreColumna) {
        switch (nombreColumna) {
            case "artista":
                switch (algoritmo) {
                    case "insertionsort" -> {
                        InsertionSort is = new InsertionSort();

                        long msStart = System.currentTimeMillis();
                        tracks = is.sort(tracks, new ArtistComparator());
                        long msEnd = System.currentTimeMillis();
                        long total = msEnd - msStart;

                        System.out.println("Insertion sort demoró " + total + "ms en ordenar la columna " + nombreColumna);
                    }
                    case "heapsort" -> {
                        HeapSort hs = new HeapSort();

                        long msStart = System.currentTimeMillis();
                        tracks = hs.sort(tracks, new ArtistComparator());
                        long msEnd = System.currentTimeMillis();
                        long total = msEnd - msStart;

                        System.out.println("Heap sort demoró " + total + "ms en ordenar la columna " + nombreColumna);
                    }
                    case "mergesort" -> {
                        MergeSort ms = new MergeSort();

                        long msStart = System.currentTimeMillis();
                        tracks = ms.sort(tracks, new ArtistComparator());
                        long msEnd = System.currentTimeMillis();
                        long total = msEnd - msStart;

                        System.out.println("Merge sort demoró " + total + "ms en ordenar la columna " + nombreColumna);
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

                        System.out.println("Insertion sort demoró " + total + "ms en ordenar la columna " + nombreColumna);
                    }
                    case "heapsort" -> {
                        HeapSort hs = new HeapSort();

                        long msStart = System.currentTimeMillis();
                        tracks = hs.sort(tracks, new PopularityComparator());
                        long msEnd = System.currentTimeMillis();
                        long total = msEnd - msStart;

                        System.out.println("Heap sort demoró " + total + "ms en ordenar la columna " + nombreColumna);
                    }
                    case "mergesort" -> {
                        MergeSort ms = new MergeSort();

                        long msStart = System.currentTimeMillis();
                        tracks = ms.sort(tracks, new PopularityComparator());
                        long msEnd = System.currentTimeMillis();
                        long total = msEnd - msStart;

                        System.out.println("Merge sort demoró " + total + "ms en ordenar la columna " + nombreColumna);
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

                        System.out.println("Insertion sort demoró " + total + "ms en ordenar la columna " + nombreColumna);
                    }
                    case "heapsort" -> {
                        HeapSort hs = new HeapSort();

                        long msStart = System.currentTimeMillis();
                        tracks = hs.sort(tracks, new SongComparator());
                        long msEnd = System.currentTimeMillis();
                        long total = msEnd - msStart;

                        System.out.println("Heap sort demoró " + total + "ms en ordenar la columna " + nombreColumna);
                    }
                    case "mergesort" -> {
                        MergeSort ms = new MergeSort();

                        long msStart = System.currentTimeMillis();
                        tracks = ms.sort(tracks, new SongComparator());
                        long msEnd = System.currentTimeMillis();
                        long total = msEnd - msStart;

                        System.out.println("Merge sort demoró " + total + "ms en ordenar la columna " + nombreColumna);
                    }
                }
                break;

        }
    }
}
