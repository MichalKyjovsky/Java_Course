import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        InputConvertor inputConvertor = new InputConvertor();
        ArrayList<Integer> coordX;
        ArrayList<Integer> coordY;
        ArrayList<City> cities = new ArrayList<>();
        try{
            inputConvertor.convertInputToNumArray();
            coordX = inputConvertor.getCoordinatesX();
            coordY = inputConvertor.getCoordinatesY();


            for (int i = 0; i < coordX.size(); i++){
                cities.add(new City(i,coordX.get(i),coordY.get(i)));
            }
            Collections.sort(cities);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        switch (cities.size()){
            case 1:
                System.exit(2);
            break;

            case 2:
                System.out.printf("Minimal length of the network is: %.2f",cities.get(0).distanceTo(cities.get(1)));
            break;

            case 3:
                double minDist = Integer.MAX_VALUE;
                double actualVal;
                double valueA = 0;
                double valueB = 0;
                for (City city1:cities) {
                    for (City city2:cities) {
                        if (city2.equals(city1))
                            continue;
                        valueA = city1.distanceTo(city2);
                        for (City city3:cities) {
                                if (city3.equals(city1) || city3.equals(city2))
                                    continue;
                                valueB = city2.distanceTo(city3);

                            actualVal = valueA + valueB;
                            if (actualVal < minDist)
                                minDist = actualVal;
                        }
                    }
                }
                System.out.printf("Minimal length of the network is: %.2f",minDist);
            break;

            case 4:
                double minDist1 = Integer.MAX_VALUE;
                double actualVal1;
                double valueA1 = 0;
                double valueB1 = 0;
                double valueC1 = 0;
                for (City city1:cities) {
                    for (City city2:cities) {
                        if (city2.equals(city1))
                            continue;
                        valueA1 = city1.distanceTo(city2);
                        for (City city3:cities) {
                            if (city3.equals(city1) || city3.equals(city2))
                                continue;
                            valueB1 = city2.distanceTo(city3);

                            for (City city4:cities) {
                                if (city4.equals(city1) || city4.equals(city2)|| city4.equals(city3))
                                    continue;
                                valueC1 = city4.distanceTo(city3);

                                actualVal1 = valueA1 + valueB1 + valueC1;
                                if (actualVal1 < minDist1)
                                    minDist1 = actualVal1;
                            }
                        }
                    }
                }
                System.out.printf("Minimal length of the network is: %.2f",minDist1);
                break;

            case 5:
                double minDist2 = Integer.MAX_VALUE;
                double actualVal2;
                double valueA2 = 0;
                double valueB2 = 0;
                double valueC2 = 0;
                double valueD2 = 0;

                for (City city1:cities) {
                    for (City city2:cities) {
                        if (city2.equals(city1))
                            continue;
                        valueA2 = city1.distanceTo(city2);
                        for (City city3:cities) {
                            if (city3.equals(city1) || city3.equals(city2))
                                continue;
                            valueB2 = city2.distanceTo(city3);

                            for (City city4:cities) {
                                if (city4.equals(city1) || city4.equals(city2)|| city4.equals(city3))
                                    continue;
                                valueC2 = city4.distanceTo(city3);

                                for (City city5:cities) {
                                    if (city5.equals(city1) || city5.equals(city2) || city5.equals(city3) || city5.equals(city4))
                                        continue;
                                    valueD2 = city5.distanceTo(city4);

                                    actualVal2 = valueA2 + valueB2 + valueC2 + valueD2;
                                    if (actualVal2 < minDist2)
                                        minDist2 = actualVal2;
                                }
                            }
                        }
                    }
                }
                System.out.printf("Minimal length of the network is: %.2f",minDist2);
            break;

            case 6:
            double minDist3 = Integer.MAX_VALUE;
            double actualVal3;
            double valueA3 = 0;
            double valueB3 = 0;
            double valueC3 = 0;
            double valueD3 = 0;
            double valueE3 = 0;

            for (City city1:cities) {
                for (City city2:cities) {
                    if (city2.equals(city1))
                        continue;
                    valueA3 = city1.distanceTo(city2);
                    for (City city3:cities) {
                        if (city3.equals(city1) || city3.equals(city2))
                            continue;
                        valueB3 = city2.distanceTo(city3);

                        for (City city4:cities) {
                            if (city4.equals(city1) || city4.equals(city2)|| city4.equals(city3))
                                continue;
                            valueC3 = city4.distanceTo(city3);

                            for (City city5:cities) {
                                if (city5.equals(city1) || city5.equals(city2) || city5.equals(city3) || city5.equals(city4))
                                    continue;
                                valueD3 = city5.distanceTo(city4);

                                for (City city6:cities) {
                                    if (city6.equals(city1) || city6.equals(city2) || city6.equals(city3) || city6.equals(city4) || city6.equals(city5))
                                        continue;
                                    valueE3 = city6.distanceTo(city5);

                                    actualVal3 = valueA3 + valueB3 + valueC3 + valueD3 + valueE3;
                                    if (actualVal3 < minDist3)
                                        minDist3 = actualVal3;
                                }
                            }
                        }
                    }
                }
            }
            System.out.printf("Minimal length of the network is: %.2f",minDist3);
            break;
        }

    }
}


