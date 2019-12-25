package cz.cuni.mff.java.example02;

class TX1 {
    public void foo() {
        System.out.println("TX1.foo()");
    }
}

class TX2 extends TX1 {
    public void foo() {
        System.out.println("TX2.foo()");
    }
}

public class TX3 extends TX2 {

    public void foo() {
        super.foo();
        //((TX2) this).foo();
        System.out.println("TX3.foo()");
    }

    public static void main(String[] argv) {
        TX3 o = new TX3();

        o.foo();
    }
}
