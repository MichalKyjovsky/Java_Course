package cz.cuni.mff.java.example01;

public class Overflow {
    /**
     * Example of two's complement overflow
     * shows that arithmetic overflow does not
     * have to result in exception*/
    public static void main(String[] argv) {
        int b = 2147483647;
        System.out.println(b);
        b = b + 1;
        System.out.println(b);
    }
}
