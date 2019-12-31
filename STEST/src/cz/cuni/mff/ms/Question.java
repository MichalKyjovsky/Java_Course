package cz.cuni.mff.ms;

import java.util.ArrayList;
import java.util.Comparator;

public class Question implements Comparator<Question> {
    protected int queueNumber;
    protected int ID;
    protected String question;
    protected ArrayList<String> options;
    protected String answersInput;
    protected ArrayList<Character> answersSplitted;

    public Question(int ID, String question, ArrayList<String> options, String answersInput,int queueNumber){
        this.ID = ID;
        this.question = question;
        this.options = options;
        this.answersInput = answersInput;
        this.queueNumber = queueNumber;
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

    public String getAnswersInput(){
        return this.answersInput;
    }

    @Override
    public int compare(Question q1, Question q2) {
        return q1.ID - q2.ID;
    }
}
