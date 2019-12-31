package cz.cuni.mff.ms;

import java.util.ArrayList;

public class MultichoiceQuestion extends Question{

    public MultichoiceQuestion(int ID, String question, ArrayList<String> options, String answersInput,int queueNumber){
        super(ID,question,options,answersInput,queueNumber);
    }

}
