package me.hwanjung.validator.value;

import me.hwanjung.validator.BaseValidator;
import me.hwanjung.validator.exception.ValidationException;

public class StringValidator extends BaseValidator<String> {

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
