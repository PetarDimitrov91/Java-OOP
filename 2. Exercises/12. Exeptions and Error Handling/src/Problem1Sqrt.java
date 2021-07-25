import java.util.Scanner;

public class Problem1Sqrt {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        while (true) {
            try {
                int n = Integer.parseInt(console.nextLine());
                double sqrt = calculateSqrt(n);
                System.out.println(sqrt);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            } finally {
            System.out.println("Good bye!");
            }
        }
    }

    private static double calculateSqrt(int n) {
        return Math.sqrt(n);
    }
}
