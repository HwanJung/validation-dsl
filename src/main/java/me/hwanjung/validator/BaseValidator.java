package me.hwanjung.validator;

import me.hwanjung.validator.exception.ValidationException;

import java.util.function.Predicate;

public class BaseValidator<T> {

    protected final String valueName;
    protected final T value;

    public BaseValidator(String valueName, T value) {
        this.valueName = valueName;
        this.value = value;
    }

    /**
     * Validate the value is not null
     *
     * @return ValueValidator
     * @throws ValidationException when the value is null
     */
    public BaseValidator<T> notNull() {
        if (this.value == null) {
            throw new ValidationException(valueName, "must not be NULL");
        }
        return this;
    }

    public BaseValidator<T> satisfies(Predicate<T> predicate) {
        if (!predicate.test(this.value)) {
            throw new ValidationException(valueName, "must satisfies " + predicate.);
        }
    }
}
