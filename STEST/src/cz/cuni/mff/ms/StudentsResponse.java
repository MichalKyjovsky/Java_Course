package cz.cuni.mff.ms;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class StudentsResponse {
    private String fullName;
    private int pointGained;
    ArrayList<String> response;
    private Dictionary<Integer,ArrayList<Character>> studentsAnswer;

    public StudentsResponse(String fullName, ArrayList<String> response){
        this.fullName = fullName;
        this.response = response;
        this.studentsAnswer = new Hashtable<>();
        this.pointGained = 0;
    }

    public void processStudentsAnswer(){
        ArrayList<Character> answers = new ArrayList<>();
        for (String item : this.response) {
            int questionNumber = Integer.parseInt(item.substring(0,item.indexOf('.')));
            for (char character: item.substring(item.indexOf('.') + 1).toUpperCase().toCharArray()){
                if(character >= 'A' && character <= 'Z') {
                    answers.add(character);
                }
            }
            studentsAnswer.put(questionNumber,answers);
        }
    }


}
