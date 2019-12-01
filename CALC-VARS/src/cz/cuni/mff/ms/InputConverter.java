package cz.cuni.mff.ms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InputConverter {

    public ArrayList<String> manageInput() {

        ArrayList<String> processedInput = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
           String line;

            while((line = br.readLine()) != null){
                processedInput.add(line);
            }
        }catch(
        IOException e){
        e.printStackTrace();
        }

       return processedInput;
    }
}
