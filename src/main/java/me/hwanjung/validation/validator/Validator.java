package me.hwanjung.validation.validator;

import me.hwanjung.validation.validator.collection.CollectionValidator;import me.hwanjung.validation.validator.collection.list.ListValidator;
import me.hwanjung.validation.validator.value.NumberValidator;
import me.hwanjung.validation.validator.value.StringValidator;

import java.util.Collection;import java.util.List;

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

    public static <C extends Collection<String>> CollectionValidator<String, C, StringValidator> validateStrings(C collection) {
        return new CollectionValidator<>(collection, StringValidator::new);
    }

    public static <N extends Number & Comparable<N>, C extends Collection<N>> CollectionValidator<N, C, NumberValidator<N>> validateNumbers(C collection) {
        return new CollectionValidator<>(collection, NumberValidator::new);
    }

    public static <E, C extends Collection<E>> CollectionValidator<E, C, BaseValidator<E>> validateObjects(C collection) {
        return new CollectionValidator<>(collection, BaseValidator::new);
    }

}
