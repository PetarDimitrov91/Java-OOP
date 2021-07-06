package AnimalFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String name = console.nextLine();
        int age = Integer.parseInt(console.nextLine());

        try {
            Chicken chicken = new Chicken(name,age);
            System.out.println(chicken);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
