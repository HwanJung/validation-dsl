package me.hwanjung.validation.validator.value;

import me.hwanjung.validation.validator.BaseValidator;
import me.hwanjung.validation.exception.ValidationException;

import java.util.function.Predicate;

public class NumberValidator<N extends Number & Comparable<N>> extends BaseValidator<N> {

    public NumberValidator(N field) {
        super(field);
    }

    @Override
    public NumberValidator<N> notNull() {
        if (this.field == null) {
            throw new ValidationException("must not be NULL");
        }
        return this;
    }

    @Override
    public NumberValidator<N> satisfies(Predicate<N> predicate) {
        if (this.field == null) {
            return this;
        }
        if (!predicate.test(this.field)) {
            throw new ValidationException("must satisfies the condition that user set");
        }
        return this;
    }

    public NumberValidator<N> greaterThan(N min) {
        if (min == null) {
            throw new IllegalArgumentException("min must not be null");
        }

        if (field == null) {
            return this;
        }
        if (field.compareTo(min) <= 0) {
            throw new ValidationException("must be greater than " + min);
        }
        return this;
    }

    public NumberValidator<N> lessThan(N max) {
        if (max == null) {
            throw new IllegalArgumentException("max must not be null");
        }

        if (field == null) {
            return this;
        }
        if (field.compareTo(max) >= 0) {
            throw new ValidationException("must be less than " + max);
        }
        return this;
    }

    public NumberValidator<N> greaterThanOrEqualTo(N min) {
        if (min == null) {
            throw new IllegalArgumentException("min must not be null");
        }

        if (field == null) {
            return this;
        }
        if (field.compareTo(min) < 0) {
            throw new ValidationException("must be greater than or equal to " + min);
        }
        return this;
    }

    public NumberValidator<N> lessThanOrEqualTo(N max) {
        if (max == null) {
            throw new IllegalArgumentException("max must not be null");
        }

        if (field == null) {
            return this;
        }
        if (field.compareTo(max) > 0) {
            throw new ValidationException("must be less than or equal to " + max);
        }
        return this;
    }

    public NumberValidator<N> betweenExclusive(N min, N max) {
        if (min == null || max == null) {
            throw new IllegalArgumentException("min and max must not be null");
        }

        if (field == null) {
            return this;
        }
        if (field.compareTo(min) <= 0 || field.compareTo(max) >= 0) {
            throw new ValidationException("must be > " + min + " and < " + max);
        }
        return this;
    }

    public NumberValidator<N> betweenInclusive(N min, N max) {
        if (min == null || max == null) {
            throw new IllegalArgumentException("min and max must not be null");
        }

        if (field == null) {
            return this;
        }
        if (field.compareTo(min) < 0 || field.compareTo(max) > 0) {
            throw new ValidationException("must be between " + min + " and " + max + " (inclusive)");
        }
        return this;
    }


    public NumberValidator<N> multipleOf(long number) {
        if (number == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero");
        }

        if (field == null) {
            return this;
        }
        if (!isIntegralNumber()) {
            throw new ValidationException("must be an integral number");
        }

        long v = field.longValue();
        if (v % number != 0) {
            throw new ValidationException("must be multiple of " + number);
        }
        return this;
    }

    private boolean isIntegralNumber() {
        return field instanceof Integer
            || field instanceof Long
            || field instanceof Byte
            || field instanceof Short;
    }
}
