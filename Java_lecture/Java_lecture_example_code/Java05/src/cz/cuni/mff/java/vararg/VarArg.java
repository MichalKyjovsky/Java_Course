package cz.cuni.mff.java.vararg;

public class VarArg {

    public static void vararg(Object... args) {
        for (Object o : args) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        vararg("Hello", "world", "!");
    }
}
