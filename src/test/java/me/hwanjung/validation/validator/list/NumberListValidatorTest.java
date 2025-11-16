package me.hwanjung.validation.validator.list;

import me.hwanjung.validation.exception.ValidationException;
import me.hwanjung.validation.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class NumberListValidatorTest {

    @DisplayName("notEmpty: 리스트가 null이거나 비어있다면 예외가 발생한다.")
    @Test
    void notEmpty_whenListIsEmpty() {
        // given
        List<Integer> list = new ArrayList<>();

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateNumbers(list).notEmpty()
        );
    }

    @DisplayName("notEmpty: 리스트가 비어있지 않다면 아무 일도 일어나지 않는다.")
    @Test
    void notEmpty_whenListIsNotEmpty() {
        // given
        List<Integer> list = new ArrayList<>();
        list.add(1);

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateNumbers(list).notEmpty()
        );
    }

    @DisplayName("sizeAtLeast: 리스트가 null이라면 아무 일도 발생하지 않는다.")
    @Test
    void sizeAtLeast_whenListIsNull() {
        // given
        List<Integer> list = null;
        int min = 3;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateNumbers(list).sizeAtLeast(min)
        );
    }

    @DisplayName("sizeAtLeast: 리스트의 크기가 인자보다 작다면 예외가 발생한다.")
    @Test
    void sizeAtLeast_whenListSizeLessThanMin() {
        // given
        List<Integer> list = List.of(1, 2, 3);
        int min = 5;

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateNumbers(list).sizeAtLeast(min)
        );
    }

    @DisplayName("sizeAtLeast: 리스트의 크기가 min보다 크다면 아무 일도 발생하지 않는다.")
    @Test
    void sizeAtLeast_whenSatisfy() {
        // given
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(4, 5, 6, 7);
        int min = 3;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateNumbers(list1).sizeAtLeast(min)
        );
        assertDoesNotThrow(
            () -> Validator.validateNumbers(list2).sizeAtLeast(min)
        );
    }

    @DisplayName("sizeAtMost: 리스트가 null이라면 아무 일도 발생하지 않는다.")
    @Test
    void sizeAtMost_whenListIsNull() {
        // given
        List<Integer> list = null;
        int max = 3;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateNumbers(list).sizeAtMost(max)
        );
    }

    @DisplayName("sizeAtMost: 리스트가 max보다 크다면 예외가 발생한다.")
    @Test
    void sizeAtMost_whenListSizeGreaterThanMax() {
        // given
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        int max = 3;

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateNumbers(list).sizeAtMost(max)
        );
    }

    @DisplayName("size: 리스트가 null이면 아무 일도 발생하지 않는다.")
    @Test
    void size_whenListIsNull() {
        // given
        List<Integer> list = null;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateNumbers(list).size(1)
        );
    }

    @DisplayName("size: 리스트의 크기가 size와 같지 않으면 예외가 발생한다.")
    @Test
    void size_whenListSizeNotEqualsSize() {
        // given
        List<Integer> list = List.of(1, 2, 3);
        int size = 4;

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateNumbers(list).size(size)
        );
    }

    @DisplayName("size: 리스트의 크기가 size와 같으면 아무 일도 발생하지 않는다.")
    @Test
    void size_whenListSizeEqualsSize() {
        // given
        List<Integer> list = List.of(1, 2, 3);
        int size = 3;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateNumbers(list).size(size)
        );
    }

    @DisplayName("forEach: 리스트가 null이면 아무 일도 일어나지 않는다.")
    @Test
    void forEach_whenListIsNull() {
        // given
        List<Integer> list = null;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateNumbers(list).forEach(null)
        );
    }

    @DisplayName("forEach: 리스트의 요소가 지정 조건을 만족하지 않는다면 예외가 발생한다.")
    @Test
    void forEach_whenNotSatisfy() {
        // given
        List<Integer> list = List.of(1, 2, 3);

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateNumbers(list)
                    .forEach(e -> e.greaterThan(2))
            );
    }

    @DisplayName("forEach: 리스트의 모든 요소가 조건을 만족한다면 아무 일도 일어나지 않는다.")
    @Test
    void forEach_whenSatisfy() {
        // given
        List<Integer> list = List.of(1, 2, 3);

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateNumbers(list)
                .forEach(e -> e
                    .notNull()
                    .lessThan(10)
                )
        );
    }
}