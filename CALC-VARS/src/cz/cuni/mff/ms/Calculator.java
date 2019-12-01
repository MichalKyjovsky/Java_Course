package cz.cuni.mff.ms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

public class Calculator {
    public String calculateInput(String input) {

        ArrayList<Double> numbers = new ArrayList<>();
        ArrayList<String> operators = new ArrayList<>();
        String output = "";

        if(filterBadInput(input)){
            return "ERROR";
        }
        String[] formula = refactorInputLine(input);
        int deepCounter = 0;

        for (int i = 0; i < formula.length; i++){
            if(formula[i].equals("(")){
                deepCounter++;
            }
        }

        return output;
    }



    public String[] refactorInputLine(String input){
        input = input.trim();
        StringBuilder editedInput = new StringBuilder();

        //Input WhiteSpace between all operators if not present
        for(int i = 0; i < input.length(); i++){
            switch (input.charAt(i)){
                case '+' | '/' | '*' |'(' | ')':
                    editedInput.append(" " + input.charAt(i));
                    break;
                case '-':
                    if(i == 0){
                        editedInput.append(input.charAt(i));
                    }else if(input.substring(0,i).matches(".*\\d.*")){
                        editedInput.append(" " + input.charAt(i));
                    }
                    break;
                default:
                    editedInput.append(input.charAt(i));
            }
        }
        return editedInput.toString().split(" ");
    }

    public boolean filterBadInput(String input) {
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.trim().charAt(i) == '+' || input.trim().charAt(i) == '-' || input.trim().charAt(i) == '*' || input.trim().charAt(i) == '/') {
                if (input.trim().charAt(i + 1) == '+' || input.trim().charAt(i + 1) == '-' || input.trim().charAt(i + 1) == '*' || input.trim().charAt(i + 1) == '/') {
                    return true;
                }
            }
        }
        return false;
    }
}
