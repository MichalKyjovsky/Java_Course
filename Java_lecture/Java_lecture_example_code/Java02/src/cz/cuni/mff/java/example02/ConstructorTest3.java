package cz.cuni.mff.java.example02;

public class ConstructorTest3 extends ConstructorTest2 {

    /**
     * This non-static initialization syntax is necessary
     * for initialization of abstract class */
    {
        int ac = 0;
    }
    public ConstructorTest3(int a) {
        //super(a);
        System.out.println("Test3(int)");
    }

    public ConstructorTest3() {
        this(0);
        System.out.println("Test3()");
    }

    public static void main(String[] argv) {
        ConstructorTest3 t3 = new ConstructorTest3();
    }
}
