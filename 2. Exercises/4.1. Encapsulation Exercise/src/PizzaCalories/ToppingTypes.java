package PizzaCalories;

public enum ToppingTypes {
    MEAT("Meat", 1.2),
    VEGGIES("Veggies", 0.8),
    CHEESE("Cheese",1.1),
    SAUCE("Sauce",0.9);

    private final String name;
    private final double calories;

    ToppingTypes(String name, double calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public double getCalories() {
        return calories;
    }
}
