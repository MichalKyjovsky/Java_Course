package cz.cuni.mff.ms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EvaluationKeywords {

    ArrayList<Question> exam;
    ArrayList<StudentsResponse> studentsResponses;

    public EvaluationKeywords(){
        this.exam = new ArrayList<>();
    }

    public void prepareForEvaluation(ArrayList<MultichoiceQuestion> multichoiceQuestions, ArrayList<SinglechoiceQuestion> singlechoiceQuestions,ArrayList<StudentsResponse> studentsResponses ) {

        removeDuplicity(multichoiceQuestions, singlechoiceQuestions);

        for(MultichoiceQuestion iterator : multichoiceQuestions){
            iterator.setCorrectAnswers(iterator.getAnswersInput());
            exam.add(iterator);
        }

        for(SinglechoiceQuestion iterator : singlechoiceQuestions){
            iterator.setCorrectAnswers(iterator.getAnswersInput());
            exam.add(iterator);
        }

        for(StudentsResponse studentsResponse: studentsResponses){
            studentsResponse.processStudentsAnswer();
            this.studentsResponses = studentsResponses;
        }
    }

    private void removeDuplicity(ArrayList<MultichoiceQuestion> multichoiceQuestions, ArrayList<SinglechoiceQuestion> singlechoiceQuestions){
        for (MultichoiceQuestion mq : multichoiceQuestions){
            for(MultichoiceQuestion mq2 : multichoiceQuestions){
                if((mq != mq2) && (mq.ID == mq2.ID)){
                    if(mq.queueNumber > mq2.queueNumber){
                        multichoiceQuestions.remove(mq2);
                        break;
                    }
                    else {
                        multichoiceQuestions.remove(mq);
                        break;
                    }
                }
            }
        }
        for (SinglechoiceQuestion sq : singlechoiceQuestions){
            for(SinglechoiceQuestion sq2 : singlechoiceQuestions){
                if((sq != sq2) && (sq.ID == sq2.ID)){
                    if(sq.queueNumber > sq2.queueNumber){
                        singlechoiceQuestions.remove(sq2);
                        break;
                    }
                    else {
                        singlechoiceQuestions.remove(sq);
                        break;
                    }
                }
            }
        }
    }

    public ArrayList<StudentsResults> evaluateExams(){
        ArrayList<StudentsResults> studentsResults = new ArrayList<>();
        int grade;
        int pointsInTotalPerQuestion = 0;
        Collections.sort(exam, Comparator.comparingInt(question -> question.ID));

        ArrayList<String> correctAnswers = new ArrayList<>();
        for(Question q : exam){
            correctAnswers.add(q.answersSplitted.toString());
        }

        for(StudentsResponse studentsResponse: studentsResponses) {

            ArrayList<String> studentAnswers = new ArrayList<>();
            ArrayList<Integer> pointsPerQuestion = new ArrayList<>();
            for (int i = 1; i <= studentsResponse.getStudentsAnswer().size(); i++) {
                studentAnswers.add(studentsResponse.getStudentsAnswer().get(i).toString());
            }

            for(int i = 0; i < correctAnswers.size(); i++){
                for(int j = 0; j < studentAnswers.get(i).length(); j++) {
                    String check = Character.toString(studentAnswers.get(i).charAt(j));
                    if (!correctAnswers.get(i).contains(check) && !check.equals(" ") && !check.equals(",")){
                        pointsInTotalPerQuestion++;
                    }
                }
                pointsPerQuestion.add(pointsInTotalPerQuestion);
                pointsInTotalPerQuestion = 0;
            }

            int pointsInTotal = 0;
            for (Integer points: pointsPerQuestion) {
                pointsInTotal += points;
            }
            switch(pointsInTotal){
                case 0:
                case 1:
                case 2: grade = 1;
                    break;
                case 3:
                case 4:
                case 5: grade = 2;
                    break;
                case 6:
                case 7:
                case 8: grade = 3;
                    break;
                default: grade = 4;
                    break;
            }
            studentsResults.add(new StudentsResults(studentsResponse.getFullName(), pointsPerQuestion, pointsInTotal, grade));
        }
        return studentsResults;
    }
}
