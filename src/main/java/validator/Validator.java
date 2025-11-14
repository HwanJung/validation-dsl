package validator;

import validator.value.NumberValidator;
import validator.value.StringValidator;
import validator.value.ValueValidator;

public class Validator {

    private Validator() {}

    public static StringValidator value(String valueName, String value) {
        return new StringValidator(valueName, value);
    }

    public static <N extends Number & Comparable<N>> NumberValidator<N> value(String valueName, N value) {
        return new NumberValidator<>(valueName, value);
    }

    public static <T> ValueValidator<T> value(String valueName, T value) {
        return new ValueValidator<>(valueName, value);
    }
}
