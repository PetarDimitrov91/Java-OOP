package animals;

public class Animal {
    private String name;
    private String age;
    private String gender;

    public Animal(String name, String age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.trim().length() > 0) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        if (age.trim().length() <= 0) {
            throw new IllegalArgumentException("Invalid input!");

        } else if (Integer.parseInt(age) < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender.trim().length() > 0) {
            this.gender = gender;
        } else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public String produceSound() {
        return "Missing kind of an Animal";
    }

    @Override
    public String toString() {
        return String.format("%s%n%s %s %s%n%s",
                getClass().getSimpleName(), this.name, this.age,
                this.getGender(), produceSound()).trim();
    }
}
