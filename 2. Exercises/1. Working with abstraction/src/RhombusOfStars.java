import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        //  Scanner console = new Scanner(System.in);

        int size = readInput();

        String rhombusOfStars = buildRhombus0fStars(size);

        printOutput(rhombusOfStars);

    }

    private static void printOutput(String rhombusOfStars) {
        System.out.println(rhombusOfStars);
    }

    private static String buildRhombus0fStars(int size) {
        StringBuilder out = new StringBuilder();
        for (int r = 0; r <= size; r++) {
            out.append(printLine(size -r,r)).append(System.lineSeparator());
        }
        return out.toString();
    }

    private static String printLine(int spaces, int stars) {
return null;
    }

    private static int readInput() {
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }
}
