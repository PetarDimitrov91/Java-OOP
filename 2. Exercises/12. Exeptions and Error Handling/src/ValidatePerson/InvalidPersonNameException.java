package ValidatePerson;

import javax.naming.InvalidNameException;

public class InvalidPersonNameException extends InvalidNameException {
    public InvalidPersonNameException(String message) {
        super(message);
    }
}
