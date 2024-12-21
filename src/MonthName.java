import java.util.Scanner;

public class MonthName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите номер месяца (от 1 до 12): ");
        int month = scanner.nextInt();

        String[] months = {
                "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
                "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"
        };

        if (month < 1 || month > 12) {
            System.out.println("Некорректный ввод. Введите число от 1 до 12.");
        } else {
            System.out.println("Месяц: " + months[month - 1]);
        }

        scanner.close();
    }
}