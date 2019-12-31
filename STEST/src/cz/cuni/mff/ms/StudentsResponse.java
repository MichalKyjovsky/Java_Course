package cz.cuni.mff.ms;

import java.util.*;

public class StudentsResponse {

    private String fullName;
    ArrayList<String> response;
    private Dictionary<Integer,ArrayList<Character>> studentsAnswer;

    public StudentsResponse(String fullName, ArrayList<String> response){
        this.fullName = fullName;
        this.response = response;
        this.studentsAnswer = new Hashtable<>();
    }

    public void processStudentsAnswer(){
        for (String item : this.response) {
            ArrayList<Character> answers = new ArrayList<>();
            int questionNumber = Integer.parseInt(item.substring(0,item.indexOf('.')));
            for (char character: item.substring(item.indexOf('.') + 1).toUpperCase().toCharArray()){
                if(character >= 'A' && character <= 'Z') {
                    answers.add(character);
                }
            }
            Collections.sort(answers);
            getStudentsAnswer().put(questionNumber,answers);
        }
    }


    public Dictionary<Integer, ArrayList<Character>> getStudentsAnswer() {
        return studentsAnswer;
    }

    public String getFullName() {
        return fullName;
    }
}
