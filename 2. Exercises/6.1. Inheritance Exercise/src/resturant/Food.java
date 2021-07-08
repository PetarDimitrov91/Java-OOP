package resturant;

import java.math.BigDecimal;

public class Food extends Product {
    private double grams;

    //Exception is possible;
    public Food(String name, BigDecimal price, double grams) {
        super(name, price);
        this.grams = grams;
    }

    public double getGrams() {
        return grams;
    }
}
