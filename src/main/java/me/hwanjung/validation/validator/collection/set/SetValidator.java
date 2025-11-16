package me.hwanjung.validation.validator.collection.set;

import me.hwanjung.validation.validator.BaseValidator;
import me.hwanjung.validation.validator.collection.CollectionValidator;

import java.util.Set;
import java.util.function.Function;

public class SetValidator<E, V extends BaseValidator<E>>
    extends CollectionValidator<E, Set<E>, V> {

    public SetValidator(Set<E> field, Function<E, V> elementValidatorFactory) {
        super(field, elementValidatorFactory);
    }

    // Additional specific implement for set
}