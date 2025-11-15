package me.hwanjung.validation.validator.value;

import me.hwanjung.validation.exception.ValidationException;
import me.hwanjung.validation.validator.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberValidatorTest {

    @DisplayName("넘긴 인자보다 값이 크면 아무일도 일어나지 않는다.")
    @Test
    void greaterThan_whenSatisfied_thenDoNothing() {
        // given
        Integer min = 10;
        Integer number = 20;

        // when & then
        Assertions.assertDoesNotThrow(
            () -> Validator.value("number", number)
                .greaterThan(min)
        );
    }

    @DisplayName("넘긴 인자와 값이 같다면 예외가 발생한다.")
    @Test
    void greaterThan_whenEqualToArgument_thenThrowException() {
        // given
        Integer min = 10;
        Integer number = 10;

        // when & then
        Assertions.assertThrows(ValidationException.class,
            () -> Validator.value("number", number)
                .greaterThan(min)
        );
    }

    @DisplayName("넘긴 인자보다 값이 작다면 예외가 발생한다.")
    @Test
    void greaterThan_whenLessThanArgument_thenThrowException() {
        // given
        Integer min = 20;
        Integer number = 10;

        // when & then
        Assertions.assertThrows(ValidationException.class,
            () -> Validator.value("number", number)
                .greaterThan(min)
        );
    }

    @DisplayName("인자가 null이라면 예외가 발생한다.")
    @Test
    void greaterThan_whenArgumentIsNull_thenThrowException() {
        // given
        Integer arg = null;
        Integer number = 10;

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> Validator.value("number", number)
                .greaterThan(arg)
        );
    }

    @DisplayName("넘긴 인자보다 값이 크면 아무일도 일어나지 않는다.")
    @Test
    void greaterThanOrEqualTo_whenSatisfied_thenDoNothing() {
        // given
        Integer min = 10;
        Integer number = 20;

        // when & then
        Assertions.assertDoesNotThrow(
            () -> Validator.value("number", number)
                .greaterThanOrEqualTo(min)
        );
    }

    @DisplayName("넘긴 인자와 값이 같다면 아무일도 일어나지 않는다.")
    @Test
    void greaterThanOrEqualTo_whenEqualToToArgument_thenDoNoting() {
        // given
        Integer min = 10;
        Integer number = 10;

        // when & then
        Assertions.assertDoesNotThrow(
            () -> Validator.value("number", number)
                .greaterThanOrEqualTo(min)
        );
    }

    @DisplayName("넘긴 인자보다 값이 작다면 예외가 발생한다.")
    @Test
    void greaterThanOrEqualTo_whenLessThanArgumentTo_thenThrowException() {
        // given
        Integer min = 20;
        Integer number = 10;

        // when & then
        Assertions.assertThrows(ValidationException.class,
            () -> Validator.value("number", number)
                .greaterThanOrEqualTo(min)
        );
    }

    @DisplayName("인자가 null이라면 예외가 발생한다.")
    @Test
    void greaterThanOrEqualTo_whenArgumentIsNull_thenThrowException() {
        // given
        Integer arg = null;
        Integer number = 10;

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> Validator.value("number", number)
                .greaterThanOrEqualTo(arg)
        );
    }

    @DisplayName("넘긴 인자보다 값이 작으면 아무일도 일어나지 않는다.")
    @Test
    void lessThan_whenSatisfied_thenDoNothing() {
        // given
        Integer max = 20;
        Integer number = 10;

        // when & then
        Assertions.assertDoesNotThrow(
            () -> Validator.value("number", number)
                .lessThan(max)
        );
    }

    @DisplayName("넘긴 인자와 값이 같다면 예외가 발생한다.")
    @Test
    void lessThan_whenEqualToArgument_thenThrowException() {
        // given
        Integer max = 10;
        Integer number = 10;

        // when & then
        Assertions.assertThrows(ValidationException.class,
            () -> Validator.value("number", number)
                .lessThan(max)
        );
    }

    @DisplayName("넘긴 인자보다 값이 크다면 예외가 발생한다.")
    @Test
    void lessThan_whenLessThanArgument_thenThrowException() {
        // given
        Integer min = 10;
        Integer number = 20;

        // when & then
        Assertions.assertThrows(ValidationException.class,
            () -> Validator.value("number", number)
                .lessThan(min)
        );
    }

    @DisplayName("인자가 null이라면 예외가 발생한다.")
    @Test
    void lessThan_whenArgumentIsNull_thenThrowException() {
        // given
        Integer arg = null;
        Integer number = 10;

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> Validator.value("number", number)
                .lessThan(arg)
        );
    }

    @DisplayName("넘긴 인자보다 값이 작으면 아무일도 일어나지 않는다.")
    @Test
    void lessThanOrEqualTo_whenSatisfied_thenDoNothing() {
        // given
        Integer min = 20;
        Integer number = 10;

        // when & then
        Assertions.assertDoesNotThrow(
            () -> Validator.value("number", number)
                .lessThanOrEqualTo(min)
        );
    }

    @DisplayName("넘긴 인자와 값이 같다면 아무일도 일어나지 않는다.")
    @Test
    void lessThanOrEqualTo_whenEqualToToArgument_thenDoNothing() {
        // given
        Integer min = 10;
        Integer number = 10;

        // when & then
        Assertions.assertDoesNotThrow(
            () -> Validator.value("number", number)
                .lessThanOrEqualTo(min)
        );
    }

    @DisplayName("넘긴 인자보다 값이 크다면 예외가 발생한다.")
    @Test
    void lessThanOrEqualTo_whenLessThanArgumentTo_thenThrowException() {
        // given
        Integer min = 10;
        Integer number = 20;

        // when & then
        Assertions.assertThrows(ValidationException.class,
            () -> Validator.value("number", number)
                .lessThanOrEqualTo(min)
        );
    }

    @DisplayName("인자가 null이라면 예외가 발생한다.")
    @Test
    void lessThanOrEqualTo_whenArgumentIsNull_thenThrowException() {
        // given
        Integer arg = null;
        Integer number = 10;

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> Validator.value("number", number)
                .lessThanOrEqualTo(arg)
        );
    }

    @DisplayName("넘긴 두 인자 사이에 값이 있으면(min < v < max) 아무일도 일어나지 않는다.")
    @Test
    void betweenExclusive_whenSatisfied_thenDoNothing() {
        // given
        Integer min = 10;
        Integer max = 30;
        Integer number = 20;

        // when & then
        Assertions.assertDoesNotThrow(
            () -> Validator.value("number", number)
            .betweenExclusive(min, max)
        );
    }

    @DisplayName("넘긴 인자 중 작은 수와 같다면 예외가 발생한다.")
    @Test
    void betweenExclusive_whenEqualToMin_thenThrowException() {
        // given
        Integer min = 10;
        Integer max = 30;
        Integer number = 10;

        // when & then
        Assertions.assertThrows(ValidationException.class,
            () -> Validator.value("number", number)
                .betweenExclusive(min, max)
        );
    }

    @DisplayName("넘긴 인자 중 큰 수와 같다면 예외가 발생한다.")
    @Test
    void betweenExclusive_whenEqualToMax_thenThrowException() {
        // given
        Integer min = 10;
        Integer max = 30;
        Integer number = 30;

        // when & then
        Assertions.assertThrows(ValidationException.class,
            () -> Validator.value("number", number)
                .betweenExclusive(min, max)
        );
    }

    @DisplayName("넘긴 인자 중 작은 수 보다 작다면 예외가 발생한다.")
    @Test
    void betweenExclusive_whenLessThanMin_thenThrowException() {
        // given
        Integer min = 10;
        Integer max = 30;
        Integer number = 9;

        // when & then
        Assertions.assertThrows(ValidationException.class,
            () -> Validator.value("number", number)
                .betweenExclusive(min, max)
        );
    }

    @DisplayName("넘긴 인자 중 큰 수 보다 크다면 예외가 발생한다.")
    @Test
    void betweenExclusive_whenGreaterThanMax_thenThrowException() {
        // given
        Integer min = 10;
        Integer max = 30;
        Integer number = 31;

        // when & then
        Assertions.assertThrows(ValidationException.class,
            () -> Validator.value("number", number)
                .betweenExclusive(min, max)
        );
    }

    @DisplayName("인자가 모두 null이라면 예외가 발생한다.")
    @Test
    void betweenExclusive_whenArgumentsAreNull_thenThrowException() {
        // given
        Integer min = null;
        Integer max = null;
        Integer number = 10;

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> Validator.value("number", number)
                .betweenExclusive(min, max)
        );
    }

    @DisplayName("인자 하나가 null이라면 예외가 발생한다.")
    @Test
    void betweenExclusive_whenArgumentIsNull_thenThrowException() {
        // given
        Integer min = null;
        Integer max = 20;
        Integer number = 10;

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> Validator.value("number", number)
                .betweenExclusive(min, max)
        );
    }

    @DisplayName("넘긴 두 인자 사이에 값이 있으면(min <= v <= max) 아무일도 일어나지 않는다.")
    @Test
    void betweenInclusive_whenSatisfied_thenDoNothing() {
        // given
        Integer min = 10;
        Integer max = 30;
        Integer number = 20;

        // when & then
        Assertions.assertDoesNotThrow(
            () -> Validator.value("number", number)
                .betweenInclusive(min, max)
        );
    }

    @DisplayName("넘긴 인자 중 작은 수와 같다면 아무일도 일어나지 않는다.")
    @Test
    void betweenInclusive_whenEqualToMin_thenDoNoting() {
        // given
        Integer min = 10;
        Integer max = 30;
        Integer number = 10;

        // when & then
        Assertions.assertDoesNotThrow(
            () -> Validator.value("number", number)
                .betweenInclusive(min, max)
        );
    }

    @DisplayName("넘긴 인자 중 큰 수와 같다면 아무일도 일어나지 않는다.")
    @Test
    void betweenInclusive_whenEqualToMax_thenDoNothing() {
        // given
        Integer min = 10;
        Integer max = 30;
        Integer number = 30;

        // when & then
        Assertions.assertDoesNotThrow(
            () -> Validator.value("number", number)
                .betweenInclusive(min, max)
        );
    }

    @DisplayName("넘긴 인자 중 작은 수 보다 작다면 예외가 발생한다.")
    @Test
    void betweenInclusive_whenLessThanMin_thenThrowException() {
        // given
        Integer min = 10;
        Integer max = 30;
        Integer number = 9;

        // when & then
        Assertions.assertThrows(ValidationException.class,
            () -> Validator.value("number", number)
                .betweenInclusive(min, max)
        );
    }

    @DisplayName("넘긴 인자 중 큰 수 보다 크다면 예외가 발생한다.")
    @Test
    void betweenInclusive_whenGreaterThanMax_thenThrowException() {
        // given
        Integer min = 10;
        Integer max = 30;
        Integer number = 31;

        // when & then
        Assertions.assertThrows(ValidationException.class,
            () -> Validator.value("number", number)
                .betweenInclusive(min, max)
        );
    }

    @DisplayName("인자가 모두 null이라면 예외가 발생한다.")
    @Test
    void betweenInclusive_whenArgumentsAreNull_thenThrowException() {
        // given
        Integer min = null;
        Integer max = null;
        Integer number = 10;

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> Validator.value("number", number)
                .betweenInclusive(min, max)
        );
    }

    @DisplayName("인자 하나가 null이라면 예외가 발생한다.")
    @Test
    void betweenInclusive_whenArgumentIsNull_thenThrowException() {
        // given
        Integer min = 5;
        Integer max = null;
        Integer number = 10;

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> Validator.value("number", number)
                .betweenInclusive(min, max)
        );
    }

    @DisplayName("값이 넘긴 인자의 배수이면 아무일도 발생하지 않는다.")
    @Test
    void multipleOf_whenSatisfied_thenDoNothing() {
        // given
        Integer divisor = 10;
        Integer number = 50;

        // when & then
        Assertions.assertDoesNotThrow(
            () -> Validator.value("number", number)
                .multipleOf(divisor)
        );
    }

    @DisplayName("값이 넘긴 인자의 배수가 아니라면 예외가 발생한다.")
    @Test
    void multipleOf_whenNotSatisfied_thenThrowException() {
        // given
        int divisor = 10;
        Integer number = 55;

        // when & then
        Assertions.assertThrows(ValidationException.class,
            () -> Validator.value("number", number)
                .multipleOf(divisor)
        );
    }

    @DisplayName("value가 정수가 아니라면 예외가 발생한다.")
    @Test
    void multipleOf_whenValueIsNotIntegralNumber_thenThrowException() {
        // given
        int divisor = 10;
        double number = 50;

        // when & then
        Assertions.assertThrows(ValidationException.class,
            () -> Validator.value("number", number)
                .multipleOf(divisor)
        );
    }

    @DisplayName("Divisor로 넘기는 인자가 0이라면 예외가 발생한다.")
    @Test
    void multipleOf_when_thenThrowException() {
        // given
        long divisor = 0;
        Integer number = 50;

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> Validator.value("number", number)
                .multipleOf(divisor)
        );
    }

}
