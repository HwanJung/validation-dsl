package me.hwanjung.validator.value;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import me.hwanjung.validator.Validator;
import me.hwanjung.validator.exception.ValidationException;

public class BaseValidatorTest {

    @DisplayName("value가 null이면 예외가 발생한다.")
    @Test
    void notNull_whenValueIsNull() {
        // given
        String value = null;

        // when & then
        Assertions.assertThrows(ValidationException.class,
            () -> Validator.value("value", value).notNull()
        );
    }

    @DisplayName("value가 null이 아니라면 아무 일도 일어나지 않는다.")
    @Test
    void notNull_whenValueIsNotNull() {
        // given
        String value = "value";

        // when
        Validator.value("value", value).notNull();

        // then
        Assertions.assertDoesNotThrow(
            () -> Validator.value("value", value).notNull()
        );
    }
}
