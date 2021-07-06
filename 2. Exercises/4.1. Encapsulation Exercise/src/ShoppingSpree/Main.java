package ShoppingSpree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] namesInput = console.nextLine().split("[;=]");

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < namesInput.length; i += 2) {
            try {
                Person person = new Person(namesInput[i], Double.parseDouble(namesInput[i + 1]));
                people.add(person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String[] productsInput = console.nextLine().split("[;=]");

        List<Product> products = new ArrayList<>();

        for (int i = 0; i < productsInput.length; i += 2) {
            try {
                Product product = new Product(productsInput[i], Double.parseDouble(productsInput[i + 1]));
                products.add(product);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        String command = console.nextLine();

        while (!command.equals("END")) {
            try {
                String[] nameAndProduct = command.split("\\s+");
                String name = nameAndProduct[0];
                String productToAdd = nameAndProduct[1];

                Product product = null;

                for (Product value : products) {
                    if (value.getName().equals(productToAdd)) {
                        product = value;
                    }
                }

                for (Person person : people) {
                    if (person.getName().equals(name)) {
                        assert product != null;
                        person.buyProduct(product);
                    }
                }
                command = console.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        for (Person person : people) {
            if (!person.getProducts().isEmpty()) {
                System.out.println(person.getName() + " - " + person.getProducts().stream()
                        .map(Product::getName)
                        .collect(Collectors.joining(", ")));
            } else {
                System.out.println(person.getName() + " - " + "Nothing bought");
            }
        }


    }
}
