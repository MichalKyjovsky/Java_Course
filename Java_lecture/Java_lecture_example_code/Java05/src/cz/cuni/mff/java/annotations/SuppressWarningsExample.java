package cz.cuni.mff.java.annotations;

public class SuppressWarningsExample {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        DeprecationExample.foo();                // no warning here
    }
}
