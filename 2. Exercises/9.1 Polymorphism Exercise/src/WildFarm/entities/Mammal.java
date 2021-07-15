package WildFarm.entities;

import WildFarm.entities.food.Food;
import WildFarm.entities.food.Vegetable;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    private final String livingRegion;

    public String getLivingRegion() {
        return livingRegion;
    }

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    @Override
    public void eat(Food food) {

        if (food instanceof Vegetable) {
            setFoodEaten(getFoodEaten() + food.getQuantity());
        } else {
            System.out.printf("%ss are not eating that type of food!%n", getAnimalType());
        }
    }

    @Override
    public String toString() {
        DecimalFormat pattern = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %d]",
                getClass().getSimpleName(), getAnimalName(), pattern.format(getAnimalWeight()), this.livingRegion, getFoodEaten());
    }
}
