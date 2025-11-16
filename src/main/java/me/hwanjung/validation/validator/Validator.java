package me.hwanjung.validation.validator;

import me.hwanjung.validation.validator.collection.list.ListValidator;
import me.hwanjung.validation.validator.value.NumberValidator;
import me.hwanjung.validation.validator.value.StringValidator;

import java.util.List;

public class Validator {

    private Validator() {}

    public static StringValidator validate(String field) {
        return new StringValidator(field);
    }

    public static <N extends Number & Comparable<N>> NumberValidator<N> validate(N field) {
        return new NumberValidator<>(field);
    }

    public static <T> BaseValidator<T> validate(T field) {
        return new BaseValidator<>(field);
    }

    public static ListValidator<String, StringValidator> validateStrings(List<String> list) {
        return new ListValidator<>(list, StringValidator::new);
    }

    public static <N extends Number & Comparable<N>> ListValidator<N, NumberValidator<N>> validateNumbers(List<N> list) {
        return new ListValidator<>(list, NumberValidator::new);
    }

    public static <E> ListValidator<E, BaseValidator<E>> validateObjects(List<E> list) {
        return new ListValidator<>(list, BaseValidator::new);
    }

}
