package cz.cuni.mff.java.collections;

import java.util.*;

public class Print {

    static Collection fill(Collection<String> c) {
        c.add("cat");
        c.add("dog");
        c.add("dog");
        return c;
    }

    static Map fill(Map<String, String> m) {
        m.put("dog", "Bosco");
        m.put("dog", "Spot");
        m.put("cat", "Rags");
        return m;
    }

    public static void main(String[] args) {
        System.out.println(fill(new ArrayList<>()));
        System.out.println(fill(new HashSet<>()));
        System.out.println(fill(new HashMap<>()));
    }
}
