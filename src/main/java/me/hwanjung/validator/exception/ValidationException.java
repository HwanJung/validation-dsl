package me.hwanjung.validator.exception;

public class ValidationException extends RuntimeException {

    public ValidationException(String valueName, String message) {
        super("Validation failed on value '" + valueName + "': " + message);
    }
}
