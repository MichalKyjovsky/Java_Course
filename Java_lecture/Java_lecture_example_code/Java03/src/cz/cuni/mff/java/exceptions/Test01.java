/* $Id$ */
package cz.cuni.mff.java.exceptions;

public class Test01 {

    public static void main(String[] argv) {
        System.out.println(test());
    }

    public static boolean test() {
        try {
            return true;
        } finally {
            return false;
        }
    }

}
