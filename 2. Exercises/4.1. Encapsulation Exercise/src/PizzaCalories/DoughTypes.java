package PizzaCalories;

public enum DoughTypes {
    WHITE("White", 1.5),
    WHOLEGRAIN("Wholegrain", 1.0);

    private final String name;
    private final double calories;

    DoughTypes(String name, double calories) {
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
