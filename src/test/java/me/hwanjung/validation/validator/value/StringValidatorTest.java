package me.hwanjung.validation.validator.value;

import me.hwanjung.validation.exception.ValidationException;
import me.hwanjung.validation.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringValidatorTest {

    @DisplayName("notBlank: value가 null이면 예외가 발생한다.")
    @Test
    void notBlank_whenValidateIsNull() {
        // given
        String value = null;

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validate("value", value)
                    .notBlank()
        );
    }

    @DisplayName("notBlank: value가 공백 문자열이면 예외가 발생한다.")
    @Test
    void notBlank_whenValidateIsBlank() {
        // given
        String value1 = "";
        String value2 = " ";

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validate("value", value1)
                    .notBlank()
        );
        assertThrows(ValidationException.class,
            () -> Validator.validate("value", value2)
                    .notBlank()
        );
    }

    @DisplayName("notBlank: value가 공백이 아니면 아무 일도 일어나지 않는다.")
    @Test
    void notBlank_whenValidateIsNotBlank() {
        // given
        String value = "hello";

        // when & then
        assertDoesNotThrow(
            () -> Validator.validate("value", value)
                    .notBlank()
        );
    }

    @DisplayName("notEmpty: value가 null이면 예외가 발생한다.")
    @Test
    void notEmpty_whenValidateIsNull() {
        // given
        String value = null;

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validate("value", value)
                .notEmpty()
        );
    }

    @DisplayName("notEmpty: value가 빈 문자열이면 예외가 발생한다.")
    @Test
    void notEmpty_whenValidateIsEmpty() {
        // given
        String value = "";

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validate("value", value)
                    .notEmpty()
        );
    }

    @DisplayName("notEmpty: value가 비어있지 않으면 아무 일도 일어나지 않는다.")
    @Test
    void notEmpty_whenValidateIsNotEmpty() {
        // given
        String value = " ";

        // when & then
        assertDoesNotThrow(
            () -> Validator.validate("value", value)
                    .notEmpty()
        );
    }

    @DisplayName("maxLength: value가 null이면 아무 일도 일어나지 않는다.")
    @Test
    void maxLength_whenValidateIsNull() {
        // given
        int maxLength = 20;
        String value = null;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validate("value", value)
                .maxLength(maxLength)
        );
    }

    @DisplayName("maxLength: value 길이가 maxLength보다 크면 예외가 발생한다.")
    @Test
    void maxLength_whenValidateIsGreaterThanMax() {
        // given
        int maxLength = 5;
        String value = "abcdef";

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validate("value", value)
                .maxLength(maxLength)
        );
    }

    @DisplayName("maxLength: value 길이가 maxLength 이하이면 아무 일도 일어나지 않는다.")
    @Test
    void maxLength_whenValidateIsLessOrEqualToMax() {
        // given
        int maxLength = 5;
        String value = "abc";

        // when & then
        assertDoesNotThrow(
            () -> Validator.validate("value", value)
                    .maxLength(maxLength)
        );
    }

    @DisplayName("minLength: value가 null이면 아무 일도 일어나지 않는다.")
    @Test
    void minLength_whenValidateIsNull() {
        // given
        int minLength = 1;
        String value = null;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validate("value", value)
            .minLength(minLength)
        );
    }

    @DisplayName("minLength: value 길이가 minLength보다 작으면 예외가 발생한다.")
    @Test
    void minLength_whenValidateIsLessThanMin() {
        // given
        int minLength = 5;
        String value = "ab";

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validate("value", value)
                .minLength(minLength));
    }

    @DisplayName("minLength: value 길이가 minLength 이상이면 아무 일도 일어나지 않는다.")
    @Test
    void minLength_whenValidateIsGreaterOrEqualToMin() {
        // given
        int minLength = 5;
        String value1 = "abcde";

        // when & then
        assertDoesNotThrow(() -> new StringValidator("name", value1).minLength(3));
    }
}
