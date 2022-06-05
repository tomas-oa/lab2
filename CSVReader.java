import java.io.*;
import java.util.*;

public class CSVReader {
    public ArrayList<Track> read(String path) {
        int contador = 0;
        String line = "";
        ArrayList<Track> tracks= new ArrayList<>();
        AVLTree<Track> tree = new AVLTree<>();

        try{
            BufferedReader bf = new BufferedReader(new FileReader(path));

            while((line = bf.readLine()) != null){

                String[] values = line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)", -1);

                if(contador == 0) {
                    contador++;
                } else {
                    int popularity = Integer.parseInt(values[2]);
                    //                    id        nombre    artistas   popularidad
                    Track t = new Track(values[0], values[1], values[5], popularity);
                    tracks.add(t);
                    tree.insertar(values[1], t);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tracks;
    }

    public AVLTree<Track> readTree(String path){
        int contador = 0;
        String line = "";
        AVLTree<Track> tree = new AVLTree<>();

        try{
            BufferedReader bf = new BufferedReader(new FileReader(path));

            while((line = bf.readLine()) != null){

                String[] values = line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)", -1);

                if(contador == 0) {
                    contador++;
                } else {
                    int popularity = Integer.parseInt(values[2]);
                    //                    id        nombre    artistas   popularidad
                    Track t = new Track(values[0], values[1], values[5], popularity);
                    tree.insertar(values[1], t);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tree;
    }
}
