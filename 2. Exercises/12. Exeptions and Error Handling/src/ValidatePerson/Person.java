package ValidatePerson;

public class Person {

    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) throws InvalidPersonNameException {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws InvalidPersonNameException {
        if (firstName.trim().isBlank()) {
            throw new InvalidPersonNameException("Invalid First name");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws InvalidPersonNameException {
        if (lastName.trim().isBlank()) {
            throw new InvalidPersonNameException("Invalid Last name");
        }
        this.lastName = lastName;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) throws InvalidPersonAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidPersonAgeException("Age should be between [0 - 120]");
        }
        this.age = age;
    }
}
