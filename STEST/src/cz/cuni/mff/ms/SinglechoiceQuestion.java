package cz.cuni.mff.ms;

import java.util.ArrayList;

public class SinglechoiceQuestion extends Question {

    public SinglechoiceQuestion(int ID, String question, ArrayList<String> options, String answersInput,int queueNumber){
        super(ID,question,options,answersInput,queueNumber);
    }
}
