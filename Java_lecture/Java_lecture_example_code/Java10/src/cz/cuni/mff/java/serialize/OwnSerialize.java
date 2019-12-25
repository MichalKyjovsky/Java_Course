package cz.cuni.mff.java.serialize;

import java.io.*;

public class OwnSerialize {
    public static void main(String[] argv) {
        Data4 data1 = new Data4();
        Data4 data2 = new Data4();

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("file.dat"))) {
            out.writeObject(data1);
            out.writeObject(data2);
        } catch (IOException ex) {
            System.out.println(ex);
            System.exit(1);
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.dat"))) {
            Data4 data3 = (Data4) in.readObject();
            Data4 data4 = (Data4) in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
            System.exit(1);
        }

    }
}
