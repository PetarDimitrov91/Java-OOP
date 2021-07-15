package WildFarm.entities;

import WildFarm.entities.food.Food;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;


    public Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }

    public void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    protected abstract void makeSound();

    protected abstract void eat(Food food);

    public String getAnimalType() {
        return animalType;
    }

    public Double getAnimalWeight() {
        return animalWeight;
    }

    public String getAnimalName() {
        return animalName;
    }
}
