package cz.cuni.mff.java.example02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class TX1 {
    public void foo() {
        System.out.println("TX1.foo()");
    }
    public void voo(){
        Object[] oa = new Object[] {"a","ab"};
        int j = 0x12_ab_12;
        System.out.println(j);
        Collection<?> co = new ArrayList<Object>();

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
interface A {
    void log(String msg);
}
interface B {
    void log(String msg);
}

class C implements A, B {public void log(String msg) {System.out.println(msg);}}
