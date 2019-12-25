package cz.cuni.mff.java.exceptions;

public class MyException extends Exception {
    public MyException() {
        super();
    }

    public MyException(String s) {
        super(s);
    }

    public MyException(String s, Throwable t) {
        super(s, t);
    }

    public MyException(Throwable t) {
        super(t);
    }
}


