package ValidatePerson;

public class InvalidPersonAgeException extends NumberFormatException {

    public InvalidPersonAgeException(String message) {
        super(message);
    }
}
