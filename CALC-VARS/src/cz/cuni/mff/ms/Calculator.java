import java.util.HashMap;
import java.util.Stack;

public class Calculator {

    HashMap<String,Double> variables;
    double last;

    public Calculator(){
        this.variables = new HashMap();
        this.last = 0;
        variables.put("last",(double)0);
    }

    public String calculateInput(String input) {

        if (input.equals("last")){
            return String.format("%.5f",last);
        }

        String inputLine = input;
        String variable = "";

        boolean varIsPresent = false;

        if(filterBadInput(input)){
            last = 0;
            return "ERROR";
        }

        if (input.contains("=") && !containsNumbers(input.substring(0,input.indexOf('='))) && !containsOperand(input.substring(0,input.indexOf('=')))){
            inputLine = input.substring(input.indexOf('=') + 1);
            variable = input.substring(0, input.indexOf('=')).trim();
            varIsPresent = true;
        }

            String[] formula = refactorInputLine(inputLine);
            String expr = postfixConversion(formula);
            String[] expression = expr.split(" ");

            if(expression.length == 1 && !containsNumbers(expression[0]) && !containsOperand(expression[0])){
                if(variables.containsKey(expression[0])){
                    return String.format("%.5f",variables.get(expression[0]));
                }else {
                    variables.put(expression[0],(double)0);
                    return String.format("%.5f",(double)0);
                }
            }

            Stack<Double> stack = new Stack<>();
            double number;
            double numA;
            double numB;


            for (String item : expression) {
                try {
                    if(!containsNumbers(item) && !containsOperand(item)){
                        if(variables.containsKey(item)) {
                            number = variables.get(item);
                            stack.push(number);
                        }else{
                            variables.put(item,(double)0);
                            stack.push((double)0);
                        }
                    }else {
                        number = Double.parseDouble(item);
                        stack.push(number);
                    }
                } catch (Exception e) {
                    if (stack.size() > 1){
                    switch (item) {
                        case "+":
                            numA = stack.pop();
                            numB = stack.pop();
                            stack.push(numA + numB);
                            break;
                        case "-":
                            numA = stack.pop();
                            numB = stack.pop();
                            stack.push(numB - numA);
                            break;
                        case "*":
                            numA = stack.pop();
                            numB = stack.pop();
                            stack.push(numA * numB);
                            break;
                        case "/":
                            numA = stack.pop();
                            numB = stack.pop();
                            stack.push(numB / numA);
                            break;
                    }
                    }else {
                        last = 0;
                        return "ERROR";
                    }
                }
            }


            if (varIsPresent && !stack.empty()) {
                variables.put(variable, stack.peek());
                varIsPresent = false;
            }

        last = stack.peek();

        return String.format("%.5f",stack.pop());
    }

    public boolean containsOperand(String input){
        boolean containsOper = false;
        for (char item:input.toCharArray()){
            switch (item){
                case '+':
                case '/':
                case '-':
                case '*':
                case '(':
                case ')':
                case 'e':
                case '=':
                    return true;
            }
        }
        return false;
    }


    public boolean containsChars(String input){
        boolean charIsPresent = false;
        for (char item : input.toCharArray()){
            if ((item > 'a' && item < 'z') || (item > 'A' && item < 'Z')){
                charIsPresent = true;
                break;
            }else {
                charIsPresent = false;
            }
        }
        return charIsPresent;
    }

    public boolean containsNumbers(String input){
        boolean numIsPresent = false;
        for (char item : input.toCharArray()){
            if (item > '0' && item < '9'){
                numIsPresent = true;
                break;
            }else {
                numIsPresent = false;
            }
        }
        return numIsPresent;
    }


    public String postfixConversion(String[] formula) {
        Stack<Double> numbers = new Stack<>();
        Stack<String> operators = new Stack<>();
        StringBuilder output = new StringBuilder();
        boolean first = false;
        double number;


        for (String item : formula) {
            try {
                if (!containsOperand(item)){
                    output.append(item + " ");
                    continue;
                }
                number = Double.parseDouble(item);
                output.append(number + " ");
            } catch (Exception e) {
                if (!first) {
                    operators.push(item);
                    first = true;
                } else {
                    switch (item.strip()) {
                        case "+":
                            if (operators.empty() || operators.peek().equals("(")) {
                                operators.push("+");
                            } else {
                                while (!(operators.empty())) {
                                    output.append(operators.pop() + " ");
                                }
                                operators.push(item);
                            }
                            break;
                        case "-":
                            if (operators.empty() || operators.peek().equals("(")) {
                                operators.push("-");
                            } else {
                                while (!(operators.empty())) {
                                    output.append(operators.pop() + " ");
                                }
                                operators.push(item);
                            }
                            break;
                        case "*":
                            if (operators.peek().equals("+") || operators.peek().equals("-") || operators.empty() || operators.peek().equals("(")) {
                                operators.push("*");
                            } else {
                                while (operators.peek().equals("*") || operators.peek().equals("/") || operators.empty()) {
                                    output.append(operators.pop() + " ");
                                }
                                operators.push(item);
                            }
                            break;
                        case "/":
                            if (operators.peek().equals("+") || operators.peek().equals("-") || operators.empty() ||operators.peek().equals("(")) {
                                operators.push("/");
                            } else {
                                while (operators.peek().equals("*") || operators.peek().equals("/") || operators.empty()) {
                                    output.append(operators.pop() + " ");
                                }
                                operators.push(item);
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
        while (!operators.empty()) {
            output.append(operators.pop() + " ");
        }
        return  output.toString();
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
                    if(i == 0) {
                        editedInput.append(input.charAt(i));
                    }else if(input.charAt(i-1) == 'e'){
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

        if (!containsChars(input) && !containsNumbers(input)){
            return true;
        }else if(containsNumbers(input) && !containsOperand(input) && input.contains(" ")){
            return true;
        }else if(containsChars(input) && input.contains(" ") && !containsOperand(input)){
            return true;
        }


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
