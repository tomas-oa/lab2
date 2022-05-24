import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public void read(String path) {
        int contador = 0;
        String line = "";

        try{
            BufferedReader bf = new BufferedReader(new FileReader(path));

            while((line = bf.readLine()) != null){

                String[] values = line.split(",(?=(?:[^\\\"]\\\"[^\\\"]\\\")[^\\\"]$)", -1);

                if(contador == 0){
                    contador++;
                    continue;
                } else {
                    //agregar al array las canciones
                    // Track n_track = new Track(values[0],values[1],values[5],values[2]);
                    // tracks.add(n_track);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
