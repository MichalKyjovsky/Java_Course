package cz.cuni.mff.ms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

public class Calculator {
    public String calculateInput(String input) {

        Stack<Double> numbers = new Stack<>();
        Stack<String> operators = new Stack<>();
        StringBuilder output = new StringBuilder();
        boolean first = false;

        if(filterBadInput(input)){
            return "ERROR";
        }
        String[] formula = refactorInputLine(input);
        double number;

        for (String item : formula) {
            try {
                number = Double.parseDouble(item);
                output.append(number + " ");
            }catch (Exception e) {

                if (!first){
                    operators.push(item);
                    first = true;
                }else {
                    switch (item.strip()) {
                        case "+":
                            if (operators.empty() || operators.peek().equals("(")) {
                                operators.push("+");
                            } else {
                                output.append(operators.pop() + " ");
                            }
                            break;
                        case "-":
                            if (operators.empty() || operators.peek().equals("(")) {
                                operators.push("-");
                            } else {
                                output.append(operators.pop() + " ");
                            }
                            break;
                        case "*":
                            if (operators.peek().equals("+") || operators.peek().equals("-") || operators.empty()) {
                                operators.push("*");
                            } else {
                                while (operators.peek().equals("+") || operators.peek().equals("-") || operators.empty()) {
                                    output.append(operators.pop() + " ");
                                }
                            }
                            break;
                        case "/":
                            if (operators.peek().equals("+") || operators.peek().equals("-")) {
                                operators.push("/");
                            } else {
                                while (operators.peek().equals("+") || operators.peek().equals("-")) {
                                    output.append(operators.pop() + " ");
                                }
                            }
                            break;
                        case "(":
                            operators.push("(");
                            break;
                        case ")":
                            while (!operators.peek().equals("(")) {
                                output.append(operators.pop() + " ");
                            }
                            operators.pop();
                            break;
                    }
                }
            }
        }
        if(!operators.empty()){
            output.append(operators.pop());
        }


        System.out.println(output.toString());
        return output.toString();
    }



    public String[] refactorInputLine(String input){
        input = input.trim();
        StringBuilder editedInput = new StringBuilder();

        //Input WhiteSpace between all operators if not present
        for(int i = 0; i < input.length(); i++){
            switch (input.charAt(i)){
                case '+':
                case '/':
                case '*':
                    editedInput.append(" " + input.charAt(i) + " ");
                    break;
                case '(':
                case ')':
                    int len = editedInput.length();
                    if(i > 0 && editedInput.toString().charAt(len-1) != ' '){
                        editedInput.append(" " + input.charAt(i) + " ");
                    }else {
                        editedInput.append(input.charAt(i) + " ");
                    }
                    break;
                case '-':
                    if(i == 0){
                        editedInput.append(input.charAt(i));
                    }else if(input.substring(0,i).matches(".*\\d.*")){
                        editedInput.append(" " + input.charAt(i) + " ");
                    }
                    break;
                case ' ':
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
