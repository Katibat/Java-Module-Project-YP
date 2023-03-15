public class RubFormatter {
    public String formatter(double input) {
        int price = (int) input;
        String rub;
        if (price > 100) {
            price %= 100;
        }
        if (price > 20) {
            price %= 10;
        }
        if (price == 1) {
            rub  = "рубль";
        } else if (price > 1 && price < 5) {
            rub  = "рубля";
        } else {
            rub  = "рублей";
        }
        return rub;
    }
}