package cz.cuni.mff.ms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InputParser {

    public ArrayList<String> processInput(){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String line;
            ArrayList<String> lines = new ArrayList<>();
            int lineCounter = 0;

            while((line = br.readLine()) != null){
                lines.add(line);
            }
            return lines;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
