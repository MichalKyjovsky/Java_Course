package cz.cuni.mff.java.io.ex01;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileInfo {

    public static void printFileInfo(String p) {
        Path path = Path.of(p);
        if (Files.notExists(path)) {
            System.out.println("Given path does not exist");
            return;
        }
        System.out.println(path.toAbsolutePath());
        System.out.println("Directory: " + Files.isDirectory(path));
        try {
            System.out.println("Size: " + Files.size(path) + " B");
        } catch (IOException ex) {
            System.out.println("Cannot get size");
        }

        try(BufferedWriter bfw = new BufferedWriter(new FileWriter(path.toFile()))){
            bfw.append("Hello");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("No path");
            System.exit(1);
        }
        printFileInfo(args[0]);
    }
}
