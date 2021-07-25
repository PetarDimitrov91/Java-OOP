import java.util.Scanner;
import java.util.stream.IntStream;

public class EnterNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        while (true) {
            try {
                int start = Integer.parseInt(console.nextLine());
                int end = Integer.parseInt(console.nextLine());
                printNumbersInRange(start, end);
                break;
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void printNumbersInRange(int start, int end) {

        if (start < 1 || start > end || end > 100) {
            throw new NumberFormatException("invalid number");
        }
        IntStream.rangeClosed(start, end)
                .forEach(System.out::println);

    }

}
