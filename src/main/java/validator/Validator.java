package main.java.validator;

import main.java.validator.value.NumberValidator;
import main.java.validator.value.StringValidator;
import main.java.validator.value.ValueValidator;

public class Validator {

    private Validator() {}

    public static ValueValidator<String> value(String valueName, String value) {
        return new StringValidator(valueName, value);
    }

    public static <N extends Number & Comparable<N>> ValueValidator<N> value(String valueName, N value) {
        return new NumberValidator<>(valueName, value);
    }

    public static <T> ValueValidator<T> value(String valueName, T value) {
        return new ValueValidator<>(valueName, value);
    }
}
