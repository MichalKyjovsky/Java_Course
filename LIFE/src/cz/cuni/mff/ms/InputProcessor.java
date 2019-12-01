import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputProcessor {

    private int size;
    private int roundsNumber;

    public String[] manageInput(){
        String[] buffer = new String[2];
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            buffer = br.readLine().split(" ");
            size = Integer.parseInt(buffer[0]);
            roundsNumber = Integer.parseInt(buffer[1]);
            buffer = new String[size];

            for(int i = 0; i < size; i++){
                buffer[i] = br.readLine();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return buffer;
    }

    public int getRoundsNumber() {
        return roundsNumber;
    }

    public int getSize() {
        return size;
    }
}
