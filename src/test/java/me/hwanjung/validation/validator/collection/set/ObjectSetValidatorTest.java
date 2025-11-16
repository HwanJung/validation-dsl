package me.hwanjung.validation.validator.collection.set;

import me.hwanjung.validation.exception.ValidationException;
import me.hwanjung.validation.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ObjectSetValidatorTest {

    private static record User(String name) {}

    @DisplayName("notEmpty: Set가 null이거나 비어있다면 예외가 발생한다.")
    @Test
    void notEmpty_whenSetIsEmpty() {
        // given
        Set<ObjectSetValidatorTest.User> set1 = null;
        Set<ObjectSetValidatorTest.User> set2 = new HashSet<>();

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateObjects(set1).notEmpty()
        );
        assertThrows(ValidationException.class,
            () -> Validator.validateObjects(set2).notEmpty()
        );
    }

    @DisplayName("notEmpty: Set가 비어있지 않다면 아무 일도 일어나지 않는다.")
    @Test
    void notEmpty_whenSetIsNotEmpty() {
        // given
        Set<ObjectSetValidatorTest.User> set = Set.of(new ObjectSetValidatorTest.User("John"), new ObjectSetValidatorTest.User("Jane"));

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateObjects(set).notEmpty()
        );
    }

    @DisplayName("sizeAtLeast: Set가 null이라면 아무 일도 발생하지 않는다.")
    @Test
    void sizeAtLeast_whenSetIsNull() {
        // given
        Set<ObjectSetValidatorTest.User> set = null;
        int min = 3;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateObjects(set).sizeAtLeast(min)
        );
    }

    @DisplayName("sizeAtLeast: Set의 크기가 인자보다 작다면 예외가 발생한다.")
    @Test
    void sizeAtLeast_whenSetSizeLessThanMin() {
        // given
        Set<ObjectSetValidatorTest.User> set = Set.of(new ObjectSetValidatorTest.User("John"), new ObjectSetValidatorTest.User("Jane"));
        int min = 3;

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateObjects(set).sizeAtLeast(min)
        );
    }

    @DisplayName("sizeAtLeast: Set의 크기가 min보다 같거나 크다면 아무 일도 발생하지 않는다.")
    @Test
    void sizeAtLeast_whenSatisfy() {
        // given
        Set<ObjectSetValidatorTest.User> set = Set.of(new ObjectSetValidatorTest.User("John"), new ObjectSetValidatorTest.User("Jane"));
        int min = 2;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateObjects(set).sizeAtLeast(min)
        );
    }

    @DisplayName("sizeAtMost: Set가 null이라면 아무 일도 발생하지 않는다.")
    @Test
    void sizeAtMost_whenSetIsNull() {
        // given
        Set<ObjectSetValidatorTest.User> set = null;
        int max = 3;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateObjects(set).sizeAtMost(max)
        );
    }

    @DisplayName("sizeAtMost: Set가 max보다 크다면 예외가 발생한다.")
    @Test
    void sizeAtMost_whenSetSizeGreaterThanMax() {
        // given
        Set<ObjectSetValidatorTest.User> set = Set.of(new ObjectSetValidatorTest.User("John"), new ObjectSetValidatorTest.User("Jane"));
        int max = 1;

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateObjects(set).sizeAtMost(max)
        );
    }

    @DisplayName("sizeAtMost: Set의 크기가 max보다 같거나 작다면 아무 일도 발생하지 않는다.")
    @Test
    void sizeAtMost_whenSatisfy() {
        // given
        Set<ObjectSetValidatorTest.User> set = Set.of(new ObjectSetValidatorTest.User("John"), new ObjectSetValidatorTest.User("Jane"));
        int max = 2;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateObjects(set).sizeAtMost(max)
        );
        assertDoesNotThrow(
            () -> Validator.validateObjects(set).sizeAtMost(max + 1)
        );
    }

    @DisplayName("size: Set가 null이면 아무 일도 발생하지 않는다.")
    @Test
    void size_whenSetIsNull() {
        // given
        Set<ObjectSetValidatorTest.User> set = null;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateObjects(set).size(1)
        );
    }

    @DisplayName("size: Set의 크기가 size와 같지 않으면 예외가 발생한다.")
    @Test
    void size_whenSetSizeNotEqualsSize() {
        // given
        Set<ObjectSetValidatorTest.User> set = Set.of(new ObjectSetValidatorTest.User("John"), new ObjectSetValidatorTest.User("Jane"));
        int size = 4;

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateObjects(set).size(size)
        );
    }

    @DisplayName("size: Set의 크기가 size와 같으면 아무 일도 발생하지 않는다.")
    @Test
    void size_whenSetSizeEqualsSize() {
        // given
        Set<ObjectSetValidatorTest.User> set = Set.of(new ObjectSetValidatorTest.User("John"), new ObjectSetValidatorTest.User("Jane"));
        int size = 2;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateObjects(set).size(size)
        );
    }

    @DisplayName("forEach: Set가 null이면 아무 일도 일어나지 않는다.")
    @Test
    void forEach_whenSetIsNull() {
        // given
        Set<ObjectSetValidatorTest.User> set = null;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateObjects(set).forEach(null)
        );
    }

    @DisplayName("forEach: Set의 요소가 지정 조건을 만족하지 않는다면 예외가 발생한다.")
    @Test
    void forEach_whenNotSatisfy() {
        // given
        Set<ObjectSetValidatorTest.User> set = Set.of(new ObjectSetValidatorTest.User("John"), new ObjectSetValidatorTest.User("Jane"));

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateObjects(set)
                .forEach(e -> e
                    .notNull()
                    .satisfies(
                        s -> s.name().startsWith("K")
                    )
                )
        );
    }

    @DisplayName("forEach: Set의 모든 요소가 조건을 만족한다면 아무 일도 일어나지 않는다.")
    @Test
    void forEach_whenSatisfy() {
        // given
        Set<ObjectSetValidatorTest.User> set = Set.of(new ObjectSetValidatorTest.User("John"), new ObjectSetValidatorTest.User("Jane"));

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateObjects(set)
                .forEach(e -> e
                    .notNull()
                    .satisfies(
                        s -> s.name().startsWith("J")
                    )
                )
        );
    }
}
