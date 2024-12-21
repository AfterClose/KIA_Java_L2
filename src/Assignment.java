import java.util.*;
import java.text.SimpleDateFormat;

public class Assignment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод фамилии разработчика
        System.out.print("Введите фамилию разработчика: ");
        String developerSurname = scanner.nextLine();

        // Ввод даты и времени получения задания
        System.out.print("Введите дату и время получения задания (в формате ГГГГ-ММ-ДД ЧЧ:ММ): ");
        String assignmentReceived = scanner.nextLine();

        // Ввод даты и времени сдачи задания
        System.out.print("Введите дату и время сдачи задания (в формате ГГГГ-ММ-ДД ЧЧ:ММ): ");
        String assignmentSubmitted = scanner.nextLine();

        // Ввод количества чисел
        System.out.print("Введите количество чисел n: ");
        int n = scanner.nextInt();
        scanner.nextLine();  // Очищаем буфер

        // Ввод чисел
        String[] numbers = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Введите число " + (i + 1) + ": ");
            numbers[i] = scanner.nextLine();
        }

        // Вывод информации о разработчике и датах
        System.out.println("\nФамилия разработчика: " + developerSurname);
        System.out.println("Дата и время получения задания: " + assignmentReceived);
        System.out.println("Дата и время сдачи задания: " + assignmentSubmitted);

        // Выполнение заданий
        findShortestAndLongest(numbers);
        sortByLength(numbers);
        printNumbersByAverageLength(numbers);
        findMinUniqueDigitCount(numbers);
        countEvenDigitNumbers(numbers);
        findAscendingOrderDigits(numbers);
        findDistinctDigits(numbers);
        findPalindrome(numbers);
        solveQuadraticEquation(args);

        // Ввод пользовательских комментариев
        System.out.print("Введите комментарий к программе: ");
        String userComment = scanner.nextLine();
        System.out.println("/** " + userComment + " */");

        scanner.close();
    }

    /**
     * 1. Найдите самое короткое и самое длинное число и выведите их.
     */
    static void findShortestAndLongest(String[] numbers) {
        String shortest = numbers[0];
        String longest = numbers[0];

        for (String number : numbers) {
            if (number.length() < shortest.length()) {
                shortest = number;
            }
            if (number.length() > longest.length()) {
                longest = number;
            }
        }

        System.out.println("Самое короткое число: " + shortest + " (длина: " + shortest.length() + ")");
        System.out.println("Самое длинное число: " + longest + " (длина: " + longest.length() + ")");
    }

    /**
     * 2. Упорядочите числа по возрастанию (убыванию) значений их длины.
     */
    static void sortByLength(String[] numbers) {
        Arrays.sort(numbers, Comparator.comparingInt(String::length));

        System.out.println("Числа в порядке возрастания длины:");
        for (String number : numbers) {
            System.out.println(number);
        }
    }

    /**
     * 3. Вывод чисел с длиной меньше (больше) средней.
     */
    static void printNumbersByAverageLength(String[] numbers) {
        double averageLength = Arrays.stream(numbers)
                .mapToInt(String::length)
                .average().orElse(0);

        System.out.println("Числа с длиной меньше средней: ");
        for (String number : numbers) {
            if (number.length() < averageLength) {
                System.out.println(number + " (длина: " + number.length() + ")");
            }
        }
        System.out.println("Числа с длиной больше средней: ");
        for (String number : numbers) {
            if (number.length() > averageLength) {
                System.out.println(number + " (длина: " + number.length() + ")");
            }
        }
    }

    /**
     * 4. Найдите число с минимальным количеством различных цифр.
     */
    static void findMinUniqueDigitCount(String[] numbers) {
        int minUniqueCount = Integer.MAX_VALUE;
        String result = "";

        for (String number : numbers) {
            Set<Character> uniqueDigits = new HashSet<>();
            for (char digit : number.toCharArray()) {
                uniqueDigits.add(digit);
            }
            int uniqueCount = uniqueDigits.size();
            if (uniqueCount < minUniqueCount) {
                minUniqueCount = uniqueCount;
                result = number;
            }
        }

        System.out.println("Число с минимальным количеством различных цифр: " + result);
    }

    /**
     * 5. Подсчитайте количество чисел с четными цифрами.
     */
    static void countEvenDigitNumbers(String[] numbers) {
        int evenCount = 0;
        int equalCount = 0;

        for (String number : numbers) {
            boolean allEven = true;
            int evenDigits = 0;
            int oddDigits = 0;

            for (char digit : number.toCharArray()) {
                if ((digit - '0') % 2 == 0) {
                    evenDigits++;
                } else {
                    oddDigits++;
                    allEven = false;
                }
            }

            if (allEven) {
                evenCount++;
            }
            if (evenDigits == oddDigits) {
                equalCount++;
            }
        }

        System.out.println("Количество чисел, содержащих только четные цифры: " + evenCount);
        System.out.println("Количество чисел с равным числом четных и нечетных цифр: " + equalCount);
    }

    /**
     * 6. Найдите число, в котором цифры идут в строгом порядке возрастания.
     */
    static void findAscendingOrderDigits(String[] numbers) {
        for (String number : numbers) {
            boolean isAscending = true;
            for (int i = 0; i < number.length() - 1; i++) {
                if (number.charAt(i) >= number.charAt(i + 1)) {
                    isAscending = false;
                    break;
                }
            }
            if (isAscending) {
                System.out.println("Первое число с цифрами в строгом порядке возрастания: " + number);
                return;
            }
        }
    }

    /**
     * 7. Найдите число, состоящее только из различных цифр.
     */
    static void findDistinctDigits(String[] numbers) {
        for (String number : numbers) {
            Set<Character> uniqueDigits = new HashSet<>();
            for (char digit : number.toCharArray()) {
                uniqueDigits.add(digit);
            }
            if (uniqueDigits.size() == number.length()) {
                System.out.println("Первое число с различными цифрами: " + number);
                return;
            }
        }
        System.out.println("Число с различными цифрами не найдено.");
    }

    /**
     * 8. Найдите палиндром.
     */
    static void findPalindrome(String[] numbers) {
        int palindromeCount = 0;
        for (String number : numbers) {
            String reversed = new StringBuilder(number).reverse().toString();
            if (number.equals(reversed)) {
                palindromeCount++;
                if (palindromeCount == 2) {
                    System.out.println("Второй палиндром: " + number);
                    return;
                }
            }
        }
        System.out.println("Палиндромов не найдено.");
    }

    /**
     * 9. Найдите корни квадратного уравнения.
     */
    static void solveQuadraticEquation(String[] args) {
        if (args.length != 3) {
            System.out.println("Неправильное количество параметров. Необходимо ввести a, b и c.");
            return;
        }

        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);

        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Корни квадратного уравнения: " + root1 + ", " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("Единственный корень квадратного уравнения: " + root);
        } else {
            System.out.println("Корней нет, дискриминант меньше нуля.");
        }
    }
}
