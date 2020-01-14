package cz.cuni.mff.java.example01;

public class Swap {
    /**
     * ^ operator stands for XOR*/
    public static void main(String[] argv) {
        int x = 10;
        int y = 20;

        x ^= y;
        y ^= x;
        x ^= y;

        System.out.println(x);
        System.out.println(y);
    }

}
