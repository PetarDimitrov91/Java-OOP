package ValidatePerson;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        while (true) {
            try {
                Person person = new Person(console.nextLine(),
                        console.nextLine(),
                        Integer.parseInt(console.nextLine()));
                break;
            } catch (InvalidPersonAgeException | InvalidPersonNameException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
}
