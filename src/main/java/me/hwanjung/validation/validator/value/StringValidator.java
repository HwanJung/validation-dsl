package me.hwanjung.validation.validator.value;

import me.hwanjung.validation.validator.BaseValidator;
import me.hwanjung.validation.exception.ValidationException;

import java.util.function.Predicate;

public class StringValidator extends BaseValidator<String> {

    public StringValidator(String field) {
        super(field);
    }

    @Override
    public StringValidator notNull() {
        if (this.field == null) {
            throw new ValidationException("must not be NULL");
        }
        return this;
    }

    @Override
    public StringValidator satisfies(Predicate<String> predicate) {
        if (this.field == null) {
            return this;
        }
        if (!predicate.test(this.field)) {
            throw new ValidationException("must satisfies the condition that user set");
        }
        return this;
    }

    public StringValidator notBlank() {
        if (field == null || field.trim().isEmpty()) {
            throw new ValidationException("must not be blank");
        }
        return this;
    }

    public StringValidator notEmpty() {
        if (field == null || field.isEmpty()) {
            throw new ValidationException("must not be blank");
        }
        return this;
    }

    public StringValidator maxLength(int maxLength) {
        if (field == null) {
            return this;
        }
        if (field.length() > maxLength) {
            throw new ValidationException("must not be greater than " + maxLength);
        }
        return this;
    }

    public StringValidator minLength(int minLength) {
        if (field == null) {
            return this;
        }
        if (field.length() < minLength) {
            throw new ValidationException("must not be less than " + minLength);
        }
        return this;
    }
}
