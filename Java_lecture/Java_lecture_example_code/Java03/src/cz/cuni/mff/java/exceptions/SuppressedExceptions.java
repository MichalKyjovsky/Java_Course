/* $Id$ */
package cz.cuni.mff.java.exceptions;

public class SuppressedExceptions {

    static class MyResource1 implements AutoCloseable {
        public void close() throws Exception {
            System.out.println("MyResource1 was closed!");
        }
    }

    static class MyResource2 implements AutoCloseable {
        public void close() throws Exception {
            throw new Exception("Resource 2");
        }
    }

    public static void main(String[] args) throws Exception {
        try (MyResource1 myResource1 = new MyResource1();
             MyResource2 myResource2 = new MyResource2()) {
            throw new Exception("try exception");
        }
    }
}

