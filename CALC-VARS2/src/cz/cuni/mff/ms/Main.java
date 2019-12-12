package cz.cuni.mff.ms;

public class Main {

    public static void main(String[] args) {
        InputParser inputParser = new InputParser();
        Calculator calculator = new Calculator();
	    try{
            for (String item:inputParser.processInput()){
                if(!item.strip().equals("")){
                    System.out.println(calculator.giveResults(item));
                }
            }
        }catch(Exception e){
	        System.out.println("ERROR");
        }
    }
}
