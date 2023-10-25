package ro.ddavid.springproject.exceptions.homework;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String errorMessage) {
        super(errorMessage);
    }
}
