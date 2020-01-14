package cz.cuni.mff.java.stream;

import java.util.Arrays;

public class Integers {
    public static void main(String[] args) {
        int[] arr = {};

        Arrays.stream(arr).max().ifPresentOrElse(System.out::println, () -> System.out.println("No maximum"));
    }
}
