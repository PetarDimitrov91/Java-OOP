package bakery.entities.drinks;

public class Tea extends BaseDrink {
    private static final double TEA_PRICE = 1.50;

    public Tea(String name, double portion, String brand) {
        super(name, portion, TEA_PRICE, brand);
    }
}
