package cz.cuni.mff.ms;

import java.util.ArrayList;

public class StudentsResponse {
    private String fullName;
    ArrayList<String> response;
    private char[][] responseSplitted;

    public StudentsResponse(String fullName, ArrayList<String> response){
        this.fullName = fullName;
        this.response = response;
    }


}
