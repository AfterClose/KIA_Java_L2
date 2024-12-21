import java.util.Scanner;

public class ConvertBase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число в начальной системе счисления: ");
        String number = scanner.nextLine();

        System.out.print("Введите основание начальной системы (например, 2 для двоичной): ");
        int fromBase = scanner.nextInt();

        System.out.print("Введите основание конечной системы (например, 16 для шестнадцатеричной): ");
        int toBase = scanner.nextInt();

        int decimalValue = Integer.parseInt(number, fromBase);
        String convertedValue = Integer.toString(decimalValue, toBase);

        System.out.println("Число " + number + " из системы " + fromBase + " в систему " + toBase + ": " + convertedValue);

        scanner.close();
    }
}