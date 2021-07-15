package WildFarm.entities;

import WildFarm.entities.food.Food;

import java.text.DecimalFormat;

public class Cat extends Felime {

    private final String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        setFoodEaten(getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat pattern = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %s, %d]",
                getClass().getSimpleName(), getAnimalName(), this.breed, pattern.format(getAnimalWeight()), getLivingRegion(), getFoodEaten());
    }
}
