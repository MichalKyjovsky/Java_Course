package cz.cuni.mff.java.enums;

public enum Color {
    RED, GREEN, BLUE;

    public static void main(String[] argv) {
        Color c = RED;
        System.out.println(c);
        for (Color o : Color.values()) {
            System.out.println(o);
        }
    }
}
