import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private final Map<String, Double> products = new HashMap<>(); // хранить продукты
    private final StringBuilder sb = new StringBuilder(); // формировать список продуктов
    private final RubFormatter rubFormatter = new RubFormatter(); // форматировать окончание рублей

    public void saveProduct(String name, double price) { // добавить продукт в Мар
        if (products.containsKey(name)) {
            System.out.println("Продукт с названием " + name + "уже добавлен.");
            return;
        }
        products.put(name, price);
        sb.append("\n").append(name).append(" стоимостью ").append(price).append(" ")
                .append(rubFormatter.formatter(price));
        System.out.printf("Продукт с названием %s стоимостью %.2f " +
                rubFormatter.formatter(price) + " успешно сохранен!\n", name, price);
    }

    private double sumCheck(Map<String, Double> products) { // считать сумму чека
        double sum = 0;
        for (double price : products.values()) {
            sum += price;
        }
        return sum;
    }

    public void printCheck(int numberOfPersons) { // печать чека
        RubFormatter rubFormatter = new RubFormatter();
        double sum = sumCheck(products);
        double cut = cutCheck(numberOfPersons);
        System.out.println("Добавленные товары:" + sb);
        System.out.printf("Общая сумма заказов составляет %.2f " + rubFormatter.formatter(sum) +
                        ".\n", sum);
        System.out.printf("Стоимость чека для одной из %s персон составляет " +
                "%.2f " + rubFormatter.formatter(sum) + ".\n", numberOfPersons, cut);
    }

    public double cutCheck(int numberOfPersons) { // разделить чек
        return sumCheck(products) / numberOfPersons;
    }
}