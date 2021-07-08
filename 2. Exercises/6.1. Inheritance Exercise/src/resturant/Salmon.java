package resturant;

import java.math.BigDecimal;

// Error Possible
public class Salmon extends MainDish {

    private final static double SALMON_GRAMS = 22;

    public Salmon(String name, BigDecimal price) {
        super(name, price, SALMON_GRAMS);
    }
}
