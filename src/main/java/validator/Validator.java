package main.java.validator;

import main.java.valueValidator.StringValidator;
import main.java.valueValidator.ValueValidator;

public class Validator {

    private Validator() {}

    public static ValueValidator<String> value(String valueName, String value) {
        return new StringValidator(valueName, value);
    }

    public static <T> ValueValidator<T> value(String valueName, T value) {
        return new ValueValidator<>(valueName, value);
    }
}
