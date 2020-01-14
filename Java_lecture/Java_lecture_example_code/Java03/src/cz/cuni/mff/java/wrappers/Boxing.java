package cz.cuni.mff.java.wrappers;


    /**
     *If value of int is in range (-128;127)
     * then the operator == is working as for
     * value types but also for reference*/
public class Boxing {
    public static void main(String[] argv) {
        Integer i1 = 1;
        Integer i2 = 1;

        System.out.println(i1 == i2);

        Integer i3 = 127;
        Integer i4 = 127;

        System.out.println(i3 == i4);
    }
}
