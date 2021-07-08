package animals;

public class Tomcat extends Animal {

    private final static String GENDER = "Male";

    public Tomcat(String name, String age) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound() {
        return "MEOW";
    }
}
