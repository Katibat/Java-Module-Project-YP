import java.util.Scanner;

// dev branch for Y.Practicum
public class Main {
    static Calculator calculator = new Calculator();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = getCountOfPersons();
        while (true) {
            printMenu();
            String command = scanner.next();
            switch (command) {
                case "1":
                    addProduct();
                    break;
                case "2":
                    calculator.printCheck(count);
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

    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести название продукта и его стоимость.");
        System.out.println("2 - Напечатать чек.");
        System.out.println("0 - Выход из программы."); // для корректного выхода из приложения
    }

    private static int getCountOfPersons() {
        Scanner scanner = new Scanner(System.in);
        int countOfPersons;
        System.out.println("На скольких человек Вы хотите разделить счет?");
        while (true) {
            if (scanner.hasNextInt()) { // проверка на ввод цифр
                countOfPersons = scanner.nextInt();
                if (countOfPersons <= 1) {
                    System.out.println("Введено некорректное количество персон (1 или менее). " +
                            "Введите количество персон снова.");
                } else {
                    System.out.println("Количество указанных Вами персон: " + countOfPersons + ".");
                    break;
                }
            } else {
                System.out.println("Вы некорректно ввели данные. Введите целое число.");
                scanner.next();
            }
        }
        return countOfPersons;
    }

    private static void addProduct() { // добавить продукт и напечатать чек
        Scanner scanner = new Scanner(System.in);
        String name;
        double price;

        while (true) {
            System.out.println("Введите название продукта. Для завершения ввода продуктов " +
                    "введите слово 'завершить'.");
            if (scanner.hasNext()) {
                name = scanner.next();
            } else {
                System.out.println("Неверный ввод! Введите название продукта строчными буквами.");
                continue;
            }
            if (name.equalsIgnoreCase("завершить")) {
                break;
            }
            System.out.println("Введите стоимость продукта.");
            if (scanner.hasNextDouble()) { // проверка на ввод цифр
                price = scanner.nextDouble();
                if (price <= 0.0) { // проверка на положительное число}
                    System.out.println("Неверный ввод! Стоимость продукта должна быть больше 0.");
                } else {
                    calculator.saveProduct(name.toLowerCase(), price); // сохранить продукт в Мар
                    continue;
                }
            } else {
                System.out.println("Стоимость указана неверно. Попробуйте снова.");
                scanner.next();
                continue;
            }
        }
    }
}