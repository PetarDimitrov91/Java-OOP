package defineInterfacePerson;

public class Pet implements Birthable {

    private String name;
    private String birthDate;

    public Pet(String name, String birtDate) {
        this.name = name;
        this.birthDate = birtDate;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }


    public String getName() {
        return name;
    }
}
