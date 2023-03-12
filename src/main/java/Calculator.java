import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private Map<String, Double> products = new HashMap<>();

    public void saveProduct(String name, double price) {
        if (products.containsKey(name)) {
            System.out.println("Продукт с названием " + name + "уже добавлен.");
            return;
        }
        products.put(name, price);
    }

    private double sumCheck(Map<String, Double> products) {
        double sum = 0.0;
        for (double price : products.values()) {
            sum = sum + price;
        }
        return sum;
    }

    public void printCheck(int numberOfPersons) {
        RubFormatter rubFormatter = new RubFormatter();
        double sum = sumCheck(products);
        double cut = cutCheck(numberOfPersons);
        System.out.printf("Общая сумма заказов составляет %.2f " + rubFormatter.formatter(sum) +
                        ".\n", sum);
        System.out.printf("Стоимость чека для одной из %s персон составляет " +
                "%.2f " + rubFormatter.formatter(sum) + ".\n", numberOfPersons, cut);
    }

    public double cutCheck(int numberOfPersons) {
        return sumCheck(products) / numberOfPersons;
    }
}