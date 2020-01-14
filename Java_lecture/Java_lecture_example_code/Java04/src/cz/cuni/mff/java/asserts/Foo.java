package cz.cuni.mff.java.asserts;

public class Foo {
    public static void main(String args[]) {
        Baz.testAsserts();
        Bar.test();
    }
}

class Bar {
    static void test(){
        Baz.testAsserts();
    }
}

class Baz extends Bar {
    static void testAsserts() {
        boolean enabled = false;
        assert enabled = true;
        System.out.println("Asserts " + (enabled ? "enabled" : "disabled"));
    }
}
