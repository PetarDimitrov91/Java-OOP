package animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String animalType = console.nextLine();

        while (!animalType.equals("Beast!")) {

            String[] commandData = console.nextLine().split(" ");
            if (commandData[1].equals("")) {
                System.out.println("Invalid input!");
                continue;
            }

            try {
                Animal animal = createAnimal(animalType, commandData);
                animals.add(animal);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            animalType = console.nextLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    private static Animal createAnimal(String animalType, String[] commandData) {
        String animalName = commandData[0];
        int animalAge = Integer.parseInt(commandData[1]);
        String gender = commandData[2];

        switch (animalType) {
            case "Dog":
                return new Dog(animalName, animalAge, gender);
            case "Cat":
                return new Cat(animalName, animalAge, gender);
            case "Frog":
                return new Frog(animalName, animalAge, gender);
            case "Tomcat":
                return new Tomcat(animalName, animalAge);
            default:
                return new Kitten(animalName, animalAge);
        }
    }
}
