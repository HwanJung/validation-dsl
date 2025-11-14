package main.java.valueValidator;

import main.java.exception.ValidationException;

public class ValueValidator<T> {

    protected final String valueName;
    protected final T value;

    public ValueValidator(String valueName, T value) {
        this.valueName = valueName;
        this.value = value;
    }

    /**
     * Validate the value is not null
     *
     * @return ValueValidator
     * @throws ValidationException when the value is null
     */
    public ValueValidator<T> notNull() {
        if (this.value == null) {
            throw new ValidationException(valueName, "must not be NULL");
        }
        return this;
    }
}
