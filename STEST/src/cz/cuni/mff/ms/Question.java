package cz.cuni.mff.ms;

import java.util.ArrayList;

public abstract class Question {
    protected int ID;
    protected String question;
    protected ArrayList<String> options;
    protected String answersInput;
    protected ArrayList<Character> answersSplitted;

    public Question(int ID, String question, ArrayList<String> options, String answersInput){
        this.ID = ID;
        this.question = question;
        this.options = options;
        this.answersInput = answersInput;
    }

    protected  void setCorrectAnswers(String answers){
        this.answersSplitted = new ArrayList<>();
        String values = answers.substring(answers.indexOf(':') + 1);
        values = values.toUpperCase();

        for (char item : values.toCharArray()) {
            if(item >= 'A' && item <= 'Z' ){
                this.answersSplitted.add(item);
            }
        }
    }

    protected int validateAnsers(){
        return 0;
    }

    protected boolean validateCorrectnessOfInput(Question question){
        int countCheck = 0;
        int last = 0;
        for(String item: this.options) {
            for (char character : this.answersSplitted){
                if(item.startsWith(Character.toString(character))){
                    countCheck++;
                    break;
                }
            }
            if (last == countCheck){
                System.out.printf("ERROR - line %s\n", item.substring(item.indexOf('-')));
            }
        }
        return countCheck == this.answersSplitted.size();
    }

    public String getAnswersInput(){
        return this.answersInput;
    }
}
