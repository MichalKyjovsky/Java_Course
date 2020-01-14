package cz.cuni.mff.java.example02;

public class ConstructorTest2 extends ConstructorTest1 {
    /**
     * When creating instance of the descended class,
     * the parent constructor is called either*/
    public ConstructorTest2() {
        System.out.println("Test2");

    }

    public static void main(String[] argv) {
        System.out.println("Creating first object...");
        ConstructorTest1 t1 = new ConstructorTest1();
        System.out.println("Creating second object...");
        ConstructorTest2 t2 = new ConstructorTest2();
    }
}
