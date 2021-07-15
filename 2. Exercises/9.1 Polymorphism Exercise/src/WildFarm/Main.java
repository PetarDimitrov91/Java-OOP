package WildFarm;

import WildFarm.entities.*;
import WildFarm.entities.food.Food;
import WildFarm.entities.food.Meat;
import WildFarm.entities.food.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Food food;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<Mammal> animals = new ArrayList<>();

        String command = console.nextLine();


        while (!command.equals("End")) {

            String[] commandData = command.trim().split("\\s+");
            String animalType = commandData[0];
            String animalName = commandData[1];
            Double animalWeight = Double.parseDouble(commandData[2]);
            String livingRegion = commandData[3];

            String breed;

            String[] secondCommand = console.nextLine().trim().split("\\s+");

            String foodType = secondCommand[0];
            Integer foodAmount = Integer.parseInt(secondCommand[1]);

            switch (foodType) {
                case "Vegetable":
                    food = new Vegetable(foodAmount);
                    break;
                case "Meat":
                    food = new Meat(foodAmount);
                    break;
            }

            switch (animalType) {
                case "Cat":
                    breed = commandData[4];
                    Cat cat = new Cat(animalName, animalType, animalWeight, livingRegion, breed);
                    animals.add(cat);
                    cat.makeSound();
                    cat.eat(food);

                    break;
                case "Tiger":
                    Tiger tiger = new Tiger(animalName, animalType, animalWeight, livingRegion);
                    animals.add(tiger);
                    tiger.makeSound();
                    tiger.eat(food);

                    break;
                case "Zebra":
                    Zebra zebra = new Zebra(animalName, animalType, animalWeight, livingRegion);
                    animals.add(zebra);
                    zebra.makeSound();
                    zebra.eat(food);

                    break;
                case "Mouse":
                    Mouse mouse = new Mouse(animalName, animalType, animalWeight, livingRegion);
                    animals.add(mouse);
                    mouse.makeSound();
                    mouse.eat(food);

                    break;
            }
            command = console.nextLine();
        }

        for (Mammal animal : animals) {
            System.out.println(animal);
        }


    }
}
