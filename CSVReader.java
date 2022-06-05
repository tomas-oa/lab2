import Comparators.Track;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
    public ArrayList<Track> read(String path) {
        int contador = 0;
        String line = "";
        ArrayList<Track> tracks= new ArrayList<>();

        try{
            BufferedReader bf = new BufferedReader(new FileReader(path));

            while((line = bf.readLine()) != null){

                String[] values = line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)", -1);

                if(contador == 0) {
                    contador++;
                    continue;
                } else {
                    int popularity = Integer.parseInt(values[2]);
                    //                id       nombre    artistas   popularidad
                    Track t = new Track(values[0], values[1], values[5], popularity);
                    tracks.add(t);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tracks;
    }
}
