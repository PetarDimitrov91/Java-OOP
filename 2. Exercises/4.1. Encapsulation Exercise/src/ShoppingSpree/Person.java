package ShoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    // protected static final Predicate<String> nameValidator = e -> !e.equals("//s+") && e.length() >= 1;

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (product.getCost() <= money) {
            this.products.add(product);
            this.money -= product.getCost();
            System.out.printf("%s bought %s%n", name, product.getName());
        } else {
           String message = String.format("%s can't afford %s%n", this.name, product.getName());
           throw new IllegalArgumentException(message);
        }
    }

    public String getName() {
        return this.name;
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(this.products);
    }
}
