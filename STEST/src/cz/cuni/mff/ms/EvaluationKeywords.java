package cz.cuni.mff.ms;

import java.util.ArrayList;

public class EvaluationKeywords {

    ArrayList<Question> exam;

    public EvaluationKeywords(){
        this.exam = new ArrayList<>();
    }

    public void prepareForEvaluation(ArrayList<MultichoiceQuestion> multichoiceQuestions, ArrayList<SinglechoiceQuestion> singlechoiceQuestions,ArrayList<StudentsResponse> studentsResponses ) {
        boolean check1 = false;
        boolean check2 = false;

        for(MultichoiceQuestion iterator : multichoiceQuestions){
            iterator.setCorrectAnswers(iterator.getAnswersInput());
            check1 = iterator.validateCorrectnessOfInput(iterator);
            exam.add(iterator);
        }

        for(SinglechoiceQuestion iterator : singlechoiceQuestions){
            iterator.setCorrectAnswers(iterator.getAnswersInput());
            check2 = iterator.validateCorrectnessOfInput(iterator);
            exam.add(iterator);
        }

        for(StudentsResponse studentsResponse: studentsResponses){
            studentsResponse.processStudentsAnswer();
        }
    }

    public ArrayList<Question> getExam() {
        return exam;
    }
}
