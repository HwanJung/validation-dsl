package me.hwanjung.validation.validator.list;

import me.hwanjung.validation.exception.ValidationException;
import me.hwanjung.validation.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringListValidatorTest {

    @DisplayName("notEmpty: 리스트가 null이거나 비어있다면 예외가 발생한다.")
    @Test
    void notEmpty_whenListIsEmpty() {
        // given
        List<String> list = new ArrayList<>();

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateStrings(list).notEmpty()
        );
    }

    @DisplayName("notEmpty: 리스트가 비어있지 않다면 아무 일도 일어나지 않는다.")
    @Test
    void notEmpty_whenListIsNotEmpty() {
        // given
        List<String> list = new ArrayList<>();
        list.add("a");

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateStrings(list).notEmpty()
        );
    }

    @DisplayName("sizeAtLeast: 리스트가 null이라면 아무 일도 발생하지 않는다.")
    @Test
    void sizeAtLeast_whenListIsNull() {
        // given
        List<String> list = null;
        int min = 3;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateStrings(list).sizeAtLeast(min)
        );
    }

    @DisplayName("sizeAtLeast: 리스트의 크기가 인자보다 작다면 예외가 발생한다.")
    @Test
    void sizeAtLeast_whenListSizeLessThanMin() {
        // given
        List<String> list = List.of("a", "b", "hello");
        int min = 5;

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateStrings(list).sizeAtLeast(min)
        );
    }

    @DisplayName("sizeAtLeast: 리스트의 크기가 min보다 크다면 아무 일도 발생하지 않는다.")
    @Test
    void sizeAtLeast_whenSatisfy() {
        // given
        List<String> list1 = List.of("a", "b", "hello");
        List<String> list2 = List.of("a", "b", "c", "d");
        int min = 3;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateStrings(list1).sizeAtLeast(min)
        );
        assertDoesNotThrow(
            () -> Validator.validateStrings(list2).sizeAtLeast(min)
        );
    }

    @DisplayName("sizeAtMost: 리스트가 null이라면 아무 일도 발생하지 않는다.")
    @Test
    void sizeAtMost_whenListIsNull() {
        // given
        List<String> list = null;
        int max = 3;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateStrings(list).sizeAtMost(max)
        );
    }

    @DisplayName("sizeAtMost: 리스트가 max보다 크다면 예외가 발생한다.")
    @Test
    void sizeAtMost_whenListSizeGreaterThanMax() {
        // given
        List<String> list = List.of("a", "b", "hello", "c");
        int max = 3;

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateStrings(list).sizeAtMost(max)
        );
    }

    @DisplayName("size: 리스트가 null이면 아무 일도 발생하지 않는다.")
    @Test
    void size_whenListIsNull() {
        // given
        List<String> list = null;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateStrings(list).size(1)
        );
    }

    @DisplayName("size: 리스트의 크기가 size와 같지 않으면 예외가 발생한다.")
    @Test
    void size_whenListSizeNotEqualsSize() {
        // given
        List<String> list = List.of("a", "b", "hello");
        int size = 4;

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateStrings(list).size(size)
        );
    }

    @DisplayName("size: 리스트의 크기가 size와 같으면 아무 일도 발생하지 않는다.")
    @Test
    void size_whenListSizeEqualsSize() {
        // given
        List<String> list = List.of("a", "b", "hello");
        int size = 3;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateStrings(list).size(size)
        );
    }

    @DisplayName("forEach: 리스트가 null이면 아무 일도 일어나지 않는다.")
    @Test
    void forEach_whenListIsNull() {
        // given
        List<String> list = null;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateStrings(list).forEach(null)
        );
    }

    @DisplayName("forEach: 리스트의 요소가 지정 조건을 만족하지 않는다면 예외가 발생한다.")
    @Test
    void forEach_whenNotSatisfy() {
        // given
        List<String> list = List.of("a", "b", "c");

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateStrings(list)
                .forEach(e -> e
                    .notNull()
                    .minLength(2))
        );
    }

    @DisplayName("forEach: 리스트의 모든 요소가 조건을 만족한다면 아무 일도 일어나지 않는다.")
    @Test
    void forEach_whenSatisfy() {
        // given
        List<String> list = List.of("a", "b", "c");

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateStrings(list)
                .forEach(e -> e
                    .notNull()
                    .minLength(1))
        );
    }
}
