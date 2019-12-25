package cz.cuni.mff.ms;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Builder builder = new Builder();
        EvaluationKeywords evaluationKeywords = new EvaluationKeywords();
        builder.createExam(refactorInput());
        ArrayList<MultichoiceQuestion> multichoiceQuestions = builder.getMultichoiceQuestions();
        ArrayList<SinglechoiceQuestion> singlechoiceQuestions = builder.getSinglechoiceQuestions();
        ArrayList<StudentsResponse> studentsResponses = builder.getStudentsResponses();
        evaluationKeywords.prepareForEvaluation(multichoiceQuestions,singlechoiceQuestions,studentsResponses);

        System.out.println();
    }

    public static String[] refactorInput(){
        InputProcessor ip = new InputProcessor();
        ArrayList<String> lines = ip.manageInput();
        String[] input = new String[lines.size()];

        for (int i = 0; i < lines.size(); i++){
            input[i] = lines.get(i);
        }

        input = ip.repairFormatting(input);
        String[] processedInput = new String[input.length];

        int j = 0;
        for (int i = 0; i < input.length; i++){
            if(input[j] != null) {
                processedInput[i] = input[j];
                j++;
                if(j == input.length){
                    break;
                }
            }
            else{
                j++;
                i--;
            }
        }
        return processedInput;
    }
}
