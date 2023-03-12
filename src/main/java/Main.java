import java.util.Scanner;

// dev branch for Y.Practicum
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RubFormatter rubFormatter = new RubFormatter();
        System.out.println("На скольких человек Вы хотите разделить счет?");
        try {
            while (true) {
                int numberOfPersons = scanner.nextInt();
                if (numberOfPersons <= 1) {
                    System.out.println("Введено некорректное количество персон (1 или менее). " +
                            "Введите количество персон снова.");
                } else {
                    Calculator calculator = new Calculator();
                    String checkList = ("Добавленные товары:");
                    while (true) {
                        printMenu();
                        String command = scanner.next();
                        switch (command) {
                            case "1":
                                while (true) {
                                    System.out.println("Введите название продукта. \nДля завершения " +
                                            "ввода продуктов введите слово 'завершить'.");
                                    String name = "";
                                    if (scanner.hasNext()) { // проверка на ввод букв hasNext() работает некорректно
                                        name = scanner.next();
                                    } else {
                                        System.out.println("Неверный ввод! Введите название продукта " +
                                                "строчными буквами.");
                                        continue;
                                    }
                                    if (name.equalsIgnoreCase("завершить")) {
                                        break;
                                    }
                                    System.out.println("Введите стоимость продукта.");
                                    double price;
                                    if (scanner.hasNextDouble()) { // проверка на ввод цифр
                                        price = scanner.nextDouble();
                                        if (price <= 0.0) { // проверка на положительное число}
                                            System.out.println("Неверный ввод! Введите число больше 0.");
                                        } else {
                                            calculator.saveProduct(name.toLowerCase(), price); // сохранить продукт в Мар
                                            System.out.printf("Товар %s стоимостью %.2f " +
                                                    rubFormatter.formatter(price) +
                                                    " успешно сохранен!\n", name, price);
                                            checkList = checkList + "\n" + name + " по цене " + price +
                                                    rubFormatter.formatter(price);
                                        }
                                    } else {
                                        System.out.println("Стоимость указана неверно. " +
                                                "Используйте цифры.");
                                        continue;
                                    }
                                }
                                break;
                            case "2":
                                System.out.println(checkList);
                                calculator.printCheck(numberOfPersons);
                                break;
                            case "0":
                                System.out.println("Программа завершена.");
                                return;
                            default:
                                System.out.println("Извините, такой команды нет. Попробуйте снова");
                                break;
                        }
                    }
                }
            }
        } catch (Exception e) {  // проверка на ввод данных, не соответсвующему типу переменных
            System.out.println("Вы некорректно ввели данные. Попробуйте снова.");
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести название продукта и его стоимость.");
        System.out.println("2 - Напечатать результат заказа.");
        System.out.println("0 - Выход из программы.");
    }
}