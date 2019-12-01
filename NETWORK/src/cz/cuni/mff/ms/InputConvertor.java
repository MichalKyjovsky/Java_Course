
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InputConvertor {

    private ArrayList<Integer> coordinatesX;
    private ArrayList<Integer> coordinatesY;
    private int numberOfTowns = 0;

    public void convertInputToNumArray() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            coordinatesX = new ArrayList<>();
            coordinatesY = new ArrayList<>();

            numberOfTowns = Integer.parseInt(br.readLine());
            String line;
            String[] splittedLine;

            while ((line = br.readLine()) != null) {
                splittedLine = line.split(" ");
                coordinatesX.add(Integer.parseInt(splittedLine[0]));
                coordinatesY.add(Integer.parseInt(splittedLine[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getNumberOfTowns() {
        return numberOfTowns;
    }

    public ArrayList<Integer> getCoordinatesX() {
        return coordinatesX;
    }

    public ArrayList<Integer> getCoordinatesY() {
        return coordinatesY;
    }
}
