import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество элементов массива: ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        System.out.println("Элементы массива в обратном порядке:");
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}