import java.util.Scanner;

public class DecimalToOtherBase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите десятичное число: ");
        int decimalNumber = scanner.nextInt();

        System.out.print("Введите основание системы счисления (2-16): ");
        int base = scanner.nextInt();

        String result = Integer.toString(decimalNumber, base);

        System.out.println("Число " + decimalNumber + " в системе счисления с основанием " + base + ": " + result);

        scanner.close();
    }
}