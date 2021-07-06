package AnimalFarm;

import java.util.function.Predicate;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private final Predicate<String> nameValidation = e -> e.length() >= 1 && !e.equals("\\s+");

    private void setName(String name) {
        if (!nameValidation.test(name)) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        if (this.age < 6) {
            return 2;
        } else if (this.age <= 11) {
            return 1;
        } else {
            return 0.75;
        }
    }

    public String toString() {
        return String.format("Chicken %s (%d) can produce %.2f eggs per day.", this.name, this.age, this.calculateProductPerDay());
    }
}
