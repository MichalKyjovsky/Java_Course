package cz.cuni.mff.ms;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        InputConverter inputConverter = new InputConverter();
        Calculator calculator = new Calculator();

        ArrayList<String> lines = inputConverter.manageInput();


        for(int i = 0; i < lines.size(); i++) {
            if(lines.get(i).equals("")){
                continue;
            }
             System.out.println(calculator.calculateInput(lines.get(i)));
        }



    }
}
