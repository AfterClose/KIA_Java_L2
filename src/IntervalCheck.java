import java.util.Scanner;

public class IntervalCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите значение n: ");
        double n = scanner.nextDouble();

        System.out.print("Введите значение m: ");
        double m = scanner.nextDouble();

        System.out.print("Введите значение k: ");
        double k = scanner.nextDouble();

        System.out.println("Проверка принадлежности значения k к интервалам:");

        if (k > n && k < m) {
            System.out.println("k принадлежит интервалу (n, m)");
        } else {
            System.out.println("k не принадлежит интервалу (n, m)");
        }

        if (k >= n && k < m) {
            System.out.println("k принадлежит интервалу [n, m)");
        } else {
            System.out.println("k не принадлежит интервалу [n, m)");
        }

        if (k > n && k <= m) {
            System.out.println("k принадлежит интервалу (n, m]");
        } else {
            System.out.println("k не принадлежит интервалу (n, m]");
        }

        if (k >= n && k <= m) {
            System.out.println("k принадлежит интервалу [n, m]");
        } else {
            System.out.println("k не принадлежит интервалу [n, m]");
        }

        scanner.close();
    }
}