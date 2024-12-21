public class SignificantZerosInBinary {
    public static void main(String[] args) {
        int number = 129;
        String binaryString = Integer.toBinaryString(number);
        String paddedBinaryString = String.format("%8s", binaryString).replace(' ', '0'); // Паддинг до 8 бит
        System.out.println("Двоичная запись числа 129: " + paddedBinaryString);

        int significantZeros = (int) paddedBinaryString.chars().filter(ch -> ch == '0').count();
        System.out.println("Количество значащих нулей: " + significantZeros);
    }
}
