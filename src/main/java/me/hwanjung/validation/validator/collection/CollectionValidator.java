package me.hwanjung.validation.validator.collection;

import me.hwanjung.validation.exception.ValidationException;
import me.hwanjung.validation.validator.BaseValidator;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class CollectionValidator<E, C extends Collection<E>, V extends BaseValidator<E>>
    extends BaseValidator<C> {

    protected final Function<E, V> elementValidatorFactory;

    public CollectionValidator(C field, Function<E, V> elementValidatorFactory) {
        super(field);
        this.elementValidatorFactory = elementValidatorFactory;
    }

    @Override
    public CollectionValidator<E, C, V> notNull() {
        if (this.field == null) {
            throw new ValidationException("must not be NULL");
        }
        return this;
    }

    @Override
    public CollectionValidator<E, C, V> satisfies(Predicate<C> predicate) {
        if (this.field == null) {
            return this;
        }
        if (!predicate.test(this.field)) {
            throw new ValidationException("must satisfies the condition that user set");
        }
        return this;
    }

    public CollectionValidator<E, C, V> notEmpty() {
        if (field == null || field.isEmpty()) {
            throw new ValidationException("must not be empty");
        }
        return this;
    }

    public CollectionValidator<E, C, V> sizeAtLeast(int min) {
        if (field == null) {
            return this;
        }
        if (field.size() < min) {
            throw new ValidationException("must have at least " + min + " elements");
        }
        return this;
    }

    public CollectionValidator<E, C, V> sizeAtMost(int max) {
        if (field == null) {
            return this;
        }
        if (field.size() > max) {
            throw new ValidationException("must have at most " + max + " elements");
        }
        return this;
    }

    public CollectionValidator<E, C, V> size(int size) {
        if (field == null) {
            return this;
        }
        if (field.size() != size) {
            throw new ValidationException("must have " + size + " elements");
        }
        return this;
    }

    public CollectionValidator<E, C, V> forEach(Consumer<V> validator) {
        if (field == null) {
            return this;
        }
        for (E element : field) {
            validator.accept(elementValidatorFactory.apply(element));
        }
        return this;
    }
}
