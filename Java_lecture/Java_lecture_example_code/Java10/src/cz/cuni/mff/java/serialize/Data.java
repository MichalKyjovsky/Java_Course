package cz.cuni.mff.java.serialize;

import java.io.Serializable;

public class Data implements Serializable {
    private int d;

    public Data(int d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return super.toString() + ", d=" + d;
    }
}
