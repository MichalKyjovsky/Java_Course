package cz.cuni.mff.ms;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        InputConverter inputConverter = new InputConverter();
        Calculator calculator = new Calculator();

        ArrayList<String> lines = inputConverter.manageInput();
        String last = "";


        for(int i = 0; i < lines.size(); i++) {
            if(lines.get(i).equals("")){
                continue;
            }else if (lines.get(i).equals("last")){
                System.out.println(last);
            }else {
                last = calculator.calculateInput(lines.get(i));
                System.out.println(last);
            }
        }



    }
}
