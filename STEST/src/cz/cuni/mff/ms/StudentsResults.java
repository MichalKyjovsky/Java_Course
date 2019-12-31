package cz.cuni.mff.ms;

import java.util.ArrayList;

public class StudentsResults {
    private String studentName;
    private ArrayList<Integer> pointPerQuestion;
    private int pointObtained;
    private int grade;

    public StudentsResults(String studentName, ArrayList<Integer> pointPerQuestion, int pointObtained,int grade){
        this.studentName = studentName;
        this.pointPerQuestion = pointPerQuestion;
        this.pointObtained = pointObtained;
        this.grade = grade;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(studentName + "\n");
        for (int i = 1; i <= pointPerQuestion.size(); i++){
            output.append(String.format("%d. %d\n",i,pointPerQuestion.get(i - 1)));
        }
        output.append(String.format("Result: %d (%d)",grade, pointObtained));
        return output.toString();
    }
}
