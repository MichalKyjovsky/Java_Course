package cz.cuni.mff.ms;

import java.util.ArrayList;

public class Builder {
    private static final String MULTICHOICE = "multichoice";
    private static final String SINGLECHOICE = "singlechoice";
    private static final String EMPTYLINE = "";
    private static final String ANSWER = "Answer";
    private ArrayList<MultichoiceQuestion> multichoiceQuestions;
    private ArrayList<SinglechoiceQuestion> singlechoiceQuestions;

    public Builder(){
        multichoiceQuestions = new ArrayList<>();
        singlechoiceQuestions = new ArrayList<>();
    }

    public void createExam(String [] input){
        int ID;
        String question;
        String answers;
        ArrayList<String> options;

        for (int i = 0; i < input.length; i++) {
            if(input[i] == null){
                break;
            }
            switch (input[i].trim()){
                case MULTICHOICE:
                    ID = Integer.parseInt(input[++i].trim().substring(0,input[i].indexOf('.')-1));
                    question = (input[i].substring(input[i].indexOf('.') + 1));
                    options = new ArrayList<>();
                    i++;

                    while (!input[i].contains(ANSWER)){
                        options.add(input[i]);
                        i++;
                    }
                     answers = input[i];
                    getMultichoiceQuestions().add(new MultichoiceQuestion(ID,question.trim(),options,answers));
                    break;
                case SINGLECHOICE:
                    ID = Integer.parseInt(input[++i].trim().substring(0,input[i].indexOf('.')-1));
                    question = (input[i].substring(input[i].indexOf('.') + 1));
                    options = new ArrayList<>();
                    i++;

                    while (!input[i].contains(ANSWER)){
                        options.add(input[i]);
                        i++;
                    }
                    answers = input[i];
                    getSinglechoiceQuestions().add(new SinglechoiceQuestion(ID,question.trim(),options,answers));
                    break;

            }
        }
    }


    public ArrayList<MultichoiceQuestion> getMultichoiceQuestions() {
        return multichoiceQuestions;
    }

    public ArrayList<SinglechoiceQuestion> getSinglechoiceQuestions() {
        return singlechoiceQuestions;
    }
}
