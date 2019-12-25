package cz.cuni.mff.java.annotations;

class SuperClass {
    public void foo() {
    }

    public void bar(String s) {
    }
}

public class OverrideExample1 extends SuperClass {

    @Override
    public void foo() {
    }    // OK

    //@Override   // the compiler will not compile it
    public void bar(Object o) {
    }

}
