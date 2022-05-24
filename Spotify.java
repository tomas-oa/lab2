import java.util.*;
import java.io.*;

public class Spotify {
    public static void main (String [] args) {
        /*
                  String[] str = {"zfdsa", "vaca", "owo", "ola", "asd"};
                  Integer[] num = {4, 5, 2, 7, 0, 1, 210};
        */

        // declaraciones necesarias :
        CSVReader reader = new CSVReader();
        Clear clear = new Clear();
        CLI menu = new CLI();
        String path = "csv/artistas.csv";


        ArrayList<Track> tracks = new ArrayList<>();


        reader.read(path);
        menu.options();
    }
}