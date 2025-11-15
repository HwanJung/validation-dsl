package me.hwanjung.validation.validator;

import me.hwanjung.validation.validator.list.ListValidator;
import me.hwanjung.validation.validator.value.NumberValidator;
import me.hwanjung.validation.validator.value.StringValidator;

import java.util.List;

public class Validator {

    private Validator() {}

    public static StringValidator validate(String valueName, String value) {
        return new StringValidator(valueName, value);
    }

    public static <N extends Number & Comparable<N>> NumberValidator<N> validate(String valueName, N value) {
        return new NumberValidator<>(valueName, value);
    }

    public static <E> ListValidator<E> validate(String valueName, List<E> list) {
        return new ListValidator<>(valueName, list);
    }

    public static <T> BaseValidator<T> validate(String valueName, T value) {
        return new BaseValidator<>(valueName, value);
    }
}
