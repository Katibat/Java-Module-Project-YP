public class RubFormatter {
    public String formatter(double input) {
        int ending = (int) input;
        String rub;
        if (ending % 10 == 1) {
            rub  = "рубль";
        } else if ((ending % 10 >= 2) && (ending % 10 <= 4)) {
            rub  = "рубля";
        } else if ((ending % 100 >= 11) && (ending % 100 <= 20)) {
            rub  = "рублей";
        } else {
            rub  = "рублей";
        }
        return rub;
    }
}