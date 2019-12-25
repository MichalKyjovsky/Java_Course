package cz.cuni.mff.java.example02;

public class LoopTest {

    public static void main(String[] argv) {
        int START = 2000000000;
        int count = 0;

        for (float f = START; f < START + 50; f++) {
            count++;
        }

        System.out.println(count);
    }
}
