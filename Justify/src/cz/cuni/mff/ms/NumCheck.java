public class NumCheck {
    public int isInt(String str) {
        try {
            Integer.parseInt(str);
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
