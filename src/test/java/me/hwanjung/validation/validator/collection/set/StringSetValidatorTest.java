package me.hwanjung.validation.validator.collection.set;

import me.hwanjung.validation.exception.ValidationException;
import me.hwanjung.validation.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringSetValidatorTest {

    @DisplayName("notEmpty: Set이 null이거나 비어있다면 예외가 발생한다.")
    @Test
    void notEmpty_whenSetIsEmpty() {
        // given
        Set<String> set1 = null;
        Set<String> set2 = new HashSet<>();

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateStrings(set1).notEmpty()
        );
        assertThrows(ValidationException.class,
            () -> Validator.validateStrings(set2).notEmpty()
        );
    }

    @DisplayName("notEmpty: Set이 비어있지 않다면 아무 일도 일어나지 않는다.")
    @Test
    void notEmpty_whenSetIsNotEmpty() {
        // given
        Set<String> set = Set.of("a", "b", "c");

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateStrings(set).notEmpty()
        );
    }

    @DisplayName("sizeAtLeast: Set이 null이라면 아무 일도 발생하지 않는다.")
    @Test
    void sizeAtLeast_whenSetIsNull() {
        // given
        Set<String> set = null;
        int min = 3;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateStrings(set).sizeAtLeast(min)
        );
    }

    @DisplayName("sizeAtLeast: Set의 크기가 인자보다 작다면 예외가 발생한다.")
    @Test
    void sizeAtLeast_whenSetSizeLessThanMin() {
        // given
        Set<String> set = Set.of("a", "b", "hello");
        int min = 5;

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateStrings(set).sizeAtLeast(min)
        );
    }

    @DisplayName("sizeAtLeast: Set의 크기가 min보다 같거나 크다면 아무 일도 발생하지 않는다.")
    @Test
    void sizeAtLeast_whenSatisfy() {
        // given
        Set<String> set1 = Set.of("a", "b", "hello");
        Set<String> set2 = Set.of("a", "b", "c", "d");
        int min = 3;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateStrings(set1).sizeAtLeast(min)
        );
        assertDoesNotThrow(
            () -> Validator.validateStrings(set2).sizeAtLeast(min)
        );
    }

    @DisplayName("sizeAtMost: Set이 null이라면 아무 일도 발생하지 않는다.")
    @Test
    void sizeAtMost_whenSetIsNull() {
        // given
        Set<String> set = null;
        int max = 3;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateStrings(set).sizeAtMost(max)
        );
    }

    @DisplayName("sizeAtMost: Set이 max보다 크다면 예외가 발생한다.")
    @Test
    void sizeAtMost_whenSetSizeGreaterThanMax() {
        // given
        Set<String> set = Set.of("a", "b", "hello", "c");
        int max = 3;

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateStrings(set).sizeAtMost(max)
        );
    }

    @DisplayName("sizeAtMost: Set이 max보다 같거나 작다면 아무 일도 발생하지 않는다.")
    @Test
    void sizeAtMost_whenSetSizeLessThanMax() {
        // given
        Set<String> set1 = Set.of("a", "b");
        Set<String> set2 = Set.of("a", "b", "c");
        int max = 3;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateStrings(set1).sizeAtMost(max)
        );
        assertDoesNotThrow(
            () -> Validator.validateStrings(set2).sizeAtMost(max)
        );
    }

    @DisplayName("size: Set이 null이면 아무 일도 발생하지 않는다.")
    @Test
    void size_whenSetIsNull() {
        // given
        Set<String> set = null;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateStrings(set).size(1)
        );
    }

    @DisplayName("size: Set의 크기가 size와 같지 않으면 예외가 발생한다.")
    @Test
    void size_whenSetSizeNotEqualsSize() {
        // given
        Set<String> set = Set.of("a", "b", "hello");
        int size = 4;

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateStrings(set).size(size)
        );
    }

    @DisplayName("size: Set의 크기가 size와 같으면 아무 일도 발생하지 않는다.")
    @Test
    void size_whenSetSizeEqualsSize() {
        // given
        Set<String> set = Set.of("a", "b", "hello");
        int size = 3;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateStrings(set).size(size)
        );
    }

    @DisplayName("forEach: Set이 null이면 아무 일도 일어나지 않는다.")
    @Test
    void forEach_whenSetIsNull() {
        // given
        Set<String> set = null;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateStrings(set).forEach(null)
        );
    }

    @DisplayName("forEach: Set의 요소가 지정 조건을 만족하지 않는다면 예외가 발생한다.")
    @Test
    void forEach_whenNotSatisfy() {
        // given
        Set<String> set = Set.of("a", "b", "c");

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateStrings(set)
                .forEach(e -> e
                    .notNull()
                    .minLength(2))
        );
    }

    @DisplayName("forEach: Set의 모든 요소가 조건을 만족한다면 아무 일도 일어나지 않는다.")
    @Test
    void forEach_whenSatisfy() {
        // given
        Set<String> set = Set.of("a", "b", "c");

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateStrings(set)
                .forEach(e -> e
                    .notNull()
                    .minLength(1))
        );
    }
}
