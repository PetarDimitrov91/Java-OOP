package WildFarm.entities;

import WildFarm.entities.food.Food;
import WildFarm.entities.food.Vegetable;

public class Mouse extends Mammal {

    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {

        if (food instanceof Vegetable) {
            setFoodEaten(getFoodEaten() + food.getQuantity());
        } else {
            System.out.printf("Mice are not eating that type of food!%n");
        }
    }

}
