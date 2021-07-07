package PizzaCalories;

public enum DoughBakingTechniques {
    CRISPY("Crispy", 0.9),
    CHEWY("Chewy", 1.1),
    HOMEMADE("Homemade", 1.0);

    private final String name;
    private final double calories;

    DoughBakingTechniques(String name, double calories) {
        this.calories = calories;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getCalories() {
        return calories;
    }
}
