package WildFarm.entities;

import WildFarm.entities.food.Food;
import WildFarm.entities.food.Meat;

public class Tiger extends Felime {

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            setFoodEaten(getFoodEaten() + food.getQuantity());
        } else {
            System.out.printf("%ss are not eating that type of food!%n", getAnimalType());
        }
    }
}
