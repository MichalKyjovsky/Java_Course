package cz.cuni.mff.java.exceptions;

public class TryTest {

    public static void main(String[] argv) {

        try {
            throw new MyException("Exception occurred");
        } catch (MyException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("Always executes");
        }
    }
}
