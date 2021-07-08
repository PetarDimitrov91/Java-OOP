package animals;

public class Kitten extends Animal {
    private final static String GENDER = "Female";

    public Kitten(String name, String age) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
