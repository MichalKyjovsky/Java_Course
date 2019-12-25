package cz.cuni.mff.ms;

import java.util.ArrayList;

public class Builder {
    private static final String MULTICHOICE = "multichoice";
    private static final String SINGLECHOICE = "singlechoice";
    private static final String EMPTYLINE = "";
    private static final String ANSWER = "Answer";
    private ArrayList<MultichoiceQuestion> multichoiceQuestions;
    private ArrayList<SinglechoiceQuestion> singlechoiceQuestions;
    private ArrayList<StudentsResponse> studentsResponses;
    private InputProcessor ip;

    public Builder(){
        multichoiceQuestions = new ArrayList<>();
        singlechoiceQuestions = new ArrayList<>();
        studentsResponses = new ArrayList<>();
        ip = new InputProcessor();
    }

    public void createExam(String [] input){
        int ID;
        String question;
        String answers;
        ArrayList<String> options;
        String fullname;
        ArrayList<String> response;

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
                        options.add(input[i] + " -" + i);
                        i++;
                    }
                    answers = input[i];
                    getMultichoiceQuestions().add(new MultichoiceQuestion(ID,question.trim(),options,answers));
                    i++;
                    break;
                case SINGLECHOICE:
                    ID = Integer.parseInt(input[++i].trim().substring(0,input[i].indexOf('.')-1));
                    question = (input[i].substring(input[i].indexOf('.') + 1));
                    options = new ArrayList<>();
                    i++;

                    while (!input[i].contains(ANSWER)){
                        options.add(input[i] + " -" + i);
                        i++;
                    }
                    answers = input[i];
                    getSinglechoiceQuestions().add(new SinglechoiceQuestion(ID,question.trim(),options,answers));
                    i++;
                    break;
                default:
                    fullname = input[i];
                    response = new ArrayList<>();
                    i++;
                    while(input[i] != null && !input[i].equals(EMPTYLINE) && ip.startsWithNum(input[i]) ){
                        response.add(input[i]);
                        i++;
                    }
                    getStudentsResponses().add(new StudentsResponse(fullname,response));
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

    public ArrayList<StudentsResponse> getStudentsResponses() {
        return studentsResponses;
    }
}
