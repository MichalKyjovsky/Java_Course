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

    protected void setCorrectAnswers(String answers){
        String values = answers.substring(answers.indexOf(':'));
        values = values.toUpperCase();

        for (char item : values.toCharArray()) {
            if(item >= 'A' && item <= 'Z' ){
                answersSplitted.add(item);
            }
        }
    }
}
