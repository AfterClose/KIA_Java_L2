import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Ввод размерности матрицы
        System.out.print("Введите размерность матрицы n: ");
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        // Заполнение матрицы случайными числами от -n до n
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(2 * n + 1) - n; // случайные числа от -n до n
            }
        }

        // Вывод исходной матрицы
        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        int choice;
        do {
            System.out.println("\nВыберите опцию:");
            System.out.println("1. Упорядочить строки или столбцы матрицы");
            System.out.println("2. Циклический сдвиг матрицы");
            System.out.println("3. Найти наибольшее число подряд идущих возрастающих и убывающих элементов");
            System.out.println("4. Выход");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    sortMatrix(matrix, scanner);
                    break;
                case 2:
                    shiftMatrix(matrix, scanner);
                    break;
                case 3:
                    findLongestSequence(matrix);
                    break;
                case 4:
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неверный ввод. Пожалуйста, выберите правильный номер опции.");
            }

            // Постоянный вывод матрицы после каждой операции
            if (choice != 4) {
                System.out.println("Текущая матрица:");
                printMatrix(matrix);
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static void sortMatrix(int[][] matrix, Scanner scanner) {
        System.out.print("Введите 1 для сортировки строк или 2 для сортировки столбцов: ");
        int option = scanner.nextInt();
        System.out.print("Введите номер строки/столбца (начиная с 0): ");
        int k = scanner.nextInt();

        if (option == 1) {
            Arrays.sort(matrix[k]);
            System.out.println("Строка " + k + " отсортирована.");
        } else if (option == 2) {
            int[] column = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                column[i] = matrix[i][k];
            }
            Arrays.sort(column);
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][k] = column[i];
            }
            System.out.println("Столбец " + k + " отсортирован.");
        } else {
            System.out.println("Неверный выбор.");
        }
    }

    private static void shiftMatrix(int[][] matrix, Scanner scanner) {
        System.out.print("Введите направление сдвига (1 - вправо, 2 - влево, 3 - вверх, 4 - вниз): ");
        int direction = scanner.nextInt();
        System.out.print("Введите количество позиций для сдвига: ");
        int k = scanner.nextInt() % matrix.length; // Сдвиг по модулю

        if (direction == 1) { // Вправо
            for (int i = 0; i < matrix.length; i++) {
                int[] newRow = new int[matrix[i].length];
                for (int j = 0; j < matrix[i].length; j++) {
                    newRow[(j + k) % matrix[i].length] = matrix[i][j];
                }
                matrix[i] = newRow;
            }
            System.out.println("Матрица сдвинута вправо на " + k + " позиций.");
        } else if (direction == 2) { // Влево
            for (int i = 0; i < matrix.length; i++) {
                int[] newRow = new int[matrix[i].length];
                for (int j = 0; j < matrix[i].length; j++) {
                    newRow[(j - k + matrix[i].length) % matrix[i].length] = matrix[i][j];
                }
                matrix[i] = newRow;
            }
            System.out.println("Матрица сдвинута влево на " + k + " позиций.");
        } else if (direction == 3) { // Вверх
            for (int j = 0; j < matrix.length; j++) {
                int temp = matrix[0][j];
                for (int i = 0; i < matrix.length - 1; i++) {
                    matrix[i][j] = matrix[i + 1][j];
                }
                matrix[matrix.length - 1][j] = temp;
            }
            System.out.println("Матрица сдвинута вверх на " + k + " позиций.");
        } else if (direction == 4) { // Вниз
            for (int j = 0; j < matrix.length; j++) {
                int temp = matrix[matrix.length - 1][j];
                for (int i = matrix.length - 1; i > 0; i--) {
                    matrix[i][j] = matrix[i - 1][j];
                }
                matrix[0][j] = temp;
            }
            System.out.println("Матрица сдвинута вниз на " + k + " позиций.");
        } else {
            System.out.println("Неверный выбор.");
        }
    }

    private static void findLongestSequence(int[][] matrix) {
        int maxLengthInc = 0;
        int maxLengthDec = 0;

        // Поиск возрастающих последовательностей
        for (int[] row : matrix) {
            int currentLength = 1;
            for (int j = 1; j < row.length; j++) {
                if (row[j] > row[j - 1]) {
                    currentLength++;
                } else {
                    maxLengthInc = Math.max(maxLengthInc, currentLength);
                    currentLength = 1;
                }
            }
            maxLengthInc = Math.max(maxLengthInc, currentLength);
        }

        // Поиск убывающих последовательностей
        for (int[] row : matrix) {
            int currentLength = 1;
            for (int j = 1; j < row.length; j++) {
                if (row[j] < row[j - 1]) {
                    currentLength++;
                } else {
                    maxLengthDec = Math.max(maxLengthDec, currentLength);
                    currentLength = 1;
                }
            }
            maxLengthDec = Math.max(maxLengthDec, currentLength);
        }

        // Универсальный поиск в столбцах
        for (int j = 0; j < matrix.length; j++) {
            int currentLengthInc = 1;
            int currentLengthDec = 1;

            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][j] > matrix[i - 1][j]) {
                    currentLengthInc++;
                } else {
                    maxLengthInc = Math.max(maxLengthInc, currentLengthInc);
                    currentLengthInc = 1;
                }

                if (matrix[i][j] < matrix[i - 1][j]) {
                    currentLengthDec++;
                } else {
                    maxLengthDec = Math.max(maxLengthDec, currentLengthDec);
                    currentLengthDec = 1;
                }
            }
            maxLengthInc = Math.max(maxLengthInc, currentLengthInc);
            maxLengthDec = Math.max(maxLengthDec, currentLengthDec);
        }

        System.out.println("Наибольшее число подряд идущих возрастающих элементов: " + maxLengthInc);
        System.out.println("Наибольшее число подряд идущих убывающих элементов: " + maxLengthDec);
    }
}
