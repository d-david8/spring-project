package ro.ddavid.springproject.exceptions;

public class UserCreateException extends RuntimeException {

    public UserCreateException(String message) {
        super(message);
    }
}
