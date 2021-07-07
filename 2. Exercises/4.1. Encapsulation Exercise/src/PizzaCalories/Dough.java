package PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private void setFlourType(String flourType) {
        switch (flourType) {
            case "White":
            case "Wholegrain":
                this.flourType = flourType;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }

    }

    private void setBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique) {
            case "Crispy":
            case "Chewy":
            case "Homemade":
                this.bakingTechnique = bakingTechnique;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public double calculateCalories() {
        double flourType;
        double backingTechnique;
        switch (this.bakingTechnique) {
            case "Crispy":
                backingTechnique = 0.9;
                break;
            case "Chewy":
                backingTechnique = 1.1;
                break;
            case "Homemade":
                backingTechnique = 1.0;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.bakingTechnique);
        }

        switch (this.flourType) {
            case "White":
                flourType = 1.5;
                break;
            case "Wholegrain":
                flourType = 1.0;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.bakingTechnique);
        }
        return (2 * weight) * flourType * backingTechnique;
    }
}
