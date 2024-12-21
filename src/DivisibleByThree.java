public class DivisibleByThree {
    public static void main(String[] args) {
        System.out.println("Числа от 1 до 100, которые делятся на 3:");

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}