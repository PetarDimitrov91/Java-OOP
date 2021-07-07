package PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        switch (toppingType) {
            case "Meat":
            case "Veggies":
            case "Cheese":
            case "Sauce":
                this.toppingType = toppingType;
            default:
                throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
        this.weight = weight;

    }

    public double calculateCalories() {
        double value;
        switch (this.toppingType) {
            case "Meat":
                value = 1.2;
                break;
            case "Veggies":
                value = 0.8;
                break;
            case "Cheese":
                value = 1.1;
                break;
            case "Sauce":
                value = 0.9;
                break;
            default:
                throw new ArithmeticException();
        }
        return (2 + weight) * value;
    }
}