package cz.cuni.mff.ms;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        InputProcessor ip = new InputProcessor();
        Builder builder = new Builder();
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

        builder.createExam(processedInput);
        ArrayList<MultichoiceQuestion> multichoiceQuestions = builder.getMultichoiceQuestions();
        ArrayList<SinglechoiceQuestion> singlechoiceQuestions = builder.getSinglechoiceQuestions();
        System.out.println();
    }
}
