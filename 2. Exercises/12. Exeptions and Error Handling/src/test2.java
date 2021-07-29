import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        while (true) {
            String str = console.nextLine();

            if (str.isBlank()) {
                System.out.println("Exception!");
            } else {
                System.out.println(str);
            }
        }
    }

}
