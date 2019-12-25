package cz.cuni.mff.java.asserts;

public class SimpleAssert {
    public static final int MAX_INTERVAL = 10;

    private int interval;

    private void setInterval(int i) {
//    assert i>0 && i<=MAX_INTERVAL;
        assert i > 0 && i <= MAX_INTERVAL : "Bad interval: " + i;
        interval = i;
    }

    public static void main(String[] args) {
        SimpleAssert sa = new SimpleAssert();
        sa.setInterval(5);
        sa.setInterval(20);
    }
}
