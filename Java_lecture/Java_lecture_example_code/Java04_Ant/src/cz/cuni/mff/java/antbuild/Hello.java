package cz.cuni.mff.java.antbuild;
import cz.cuni.mff.java.anotherpackage.AClass;

/**
 * Hello world.
 *
 * @author Petr
 */
public class Hello {

    /**
     * Main program. Prints out a hello world string.
     *
     * @param argv command line arguments
     * @throws Exception something bad happened
     */
    public static void main(String[] argv) throws Exception {
        Msg.print("Hello world");
        AClass.print("Henlo world");

    }
}
