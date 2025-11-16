package me.hwanjung.validation.validator.collection.list;

import me.hwanjung.validation.validator.BaseValidator;
import me.hwanjung.validation.validator.collection.CollectionValidator;

import java.util.List;
import java.util.function.Function;

public class ListValidator<E, V extends BaseValidator<E>>
    extends CollectionValidator<E, List<E>, V> {

    public ListValidator(List<E> field, Function<E, V> elementValidatorFactory) {
        super(field, elementValidatorFactory);
    }

    // Additional specific implement for list
}
