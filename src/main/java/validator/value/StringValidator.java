package main.java.validator.value;

import main.java.exception.ValidationException;

public class StringValidator extends ValueValidator<String> {

    public StringValidator(String valueName, String value) {
        super(valueName, value);
    }

    public StringValidator notBlank() {
        if (value == null || value.trim().isEmpty()) {
            throw new ValidationException(valueName, "must not be blank");
        }
        return this;
    }

    public StringValidator notEmpty() {
        if (value == null || value.isEmpty()) {
            throw new ValidationException(valueName, "must not be blank");
        }
        return this;
    }

    public StringValidator maxLength(int maxLength) {
        if (value == null) {
            return this;
        }
        if (value.length() > maxLength) {
            throw new ValidationException(valueName, "must not be greater than " + maxLength);
        }
        return this;
    }

    public StringValidator minLength(int minLength) {
        if (value == null) {
            return this;
        }
        if (value.length() < minLength) {
            throw new ValidationException(valueName, "must not be less than " + minLength);
        }
        return this;
    }
}
