package cz.cuni.mff.ms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InputProcessor {

    public ArrayList<String> manageInput(){
        ArrayList<String> lines = new ArrayList<>();

        try(BufferedReader br  = new BufferedReader(new InputStreamReader(System.in))){
            String line;

            while((line = br.readLine()) != null){
                lines.add(line);
            }

            String[] output = new String[lines.size()];

            for (int i = 0; i < lines.size(); i++) {
                output[i] = lines.get(i);
            }

            lines = filterMultipleEmptyLines(output);


        }catch(Exception e){
            e.printStackTrace();
        }
        return lines;
    }

    private ArrayList<String> filterMultipleEmptyLines(String[] args){
        ArrayList<String> output = new ArrayList<>();

        if(!args[0].strip().equals("")){
            output.add(args[0]);
        }

        for(int i = 1; i < args.length; i++){
            if(args[i-1].strip().equals("") && args[i].strip().equals("")){
                continue;
            }
            else {
                output.add(args[i]);
            }
        }
        return output;
    }

    public String[] repairFormatting(String[] input){
        String[] output = new String[input.length];
        StringBuilder buffer = new StringBuilder();
        char item;
        char check;

        for (int i = 0; i < input.length; i++){
            try {
                item = input[i].trim().charAt(0);
                if (item >= '0' && item <= '9') {
                    int j = i;
                    check = input[j].trim().charAt(0);
                    while (!(check >= 'A' && check <= 'Z')) {
                        buffer.append(" " + input[j]);
                        check = input[++j].trim().charAt(0);
                    }
                    output[i] = buffer.toString();
                    buffer.delete(0,buffer.length());
                    i = j - 1;
                }else if(item >= 'A' && item <= 'Z' && !input[i].contains("Answer")){
                    int j = i;
                    check = input[j+1].trim().charAt(1);
                    while (check != '.'){
                        buffer.append(" " + input[j]);
                        j++;
                        check = input[j].trim().charAt(1);
                    }
                    if(buffer.length() > 0) {
                        output[i] = buffer.toString();
                        buffer.delete(0,buffer.length());
                        i = j - 1;
                    }
                    else{
                        output[i] = input[i];
                    }
                }
                else {
                    output[i] = input[i];
                }
            }catch (Exception e){
                output[i] = input[i];
                buffer.delete(0,buffer.length());
            }
        }

        return output;
    }
}
