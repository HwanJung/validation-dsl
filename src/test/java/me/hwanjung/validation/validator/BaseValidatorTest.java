package me.hwanjung.validation.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import me.hwanjung.validation.exception.ValidationException;

public class BaseValidatorTest {

    @DisplayName("notNull: value가 null이면 예외가 발생한다.")
    @Test
    void notNull_whenValidateIsNull_thenThrowException() {
        // given
        Object value = null;

        // when & then
        Assertions.assertThrows(ValidationException.class,
            () -> Validator.validate("value", value).notNull()
        );
    }

    @DisplayName("notNull: value가 null이 아니라면 아무 일도 일어나지 않는다.")
    @Test
    void notNull_whenValidateIsNotNull_thenDoNothing() {
        // given
        Object value = "value";

        // when & then
        Assertions.assertDoesNotThrow(
            () -> Validator.validate("value", value).notNull()
        );
    }

    @DisplayName("satisfies: 사용자가 정한 조건에 만족한다면 아무 일도 일어나지 않는다.")
    @Test
    void satisfies_whenSatisfies_thenDoNothing() {
        Object value = "value";

        Assertions.assertDoesNotThrow(
            () -> Validator.validate("value", value)
                .satisfies(v -> true)
        );
    }

    @DisplayName("satisfies: 사용자가 정한 조건에 만족하지 않는다면 예외가 발생한다.")
    @Test
    void satisfies_whenNotSatisfies_thenThrowException() {
        Object value = "value";

        Assertions.assertThrows(ValidationException.class,
            () -> Validator.validate("value", value)
                .satisfies(v -> false)
        );
    }
}
