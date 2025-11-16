package me.hwanjung.validation.validator.collection.list;

import me.hwanjung.validation.exception.ValidationException;
import me.hwanjung.validation.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ObjectsListValidatorTest {

    private static record User(String name) {}

    @DisplayName("notEmpty: 리스트가 null이거나 비어있다면 예외가 발생한다.")
    @Test
    void notEmpty_whenListIsEmpty() {
        // given
        List<User> list1 = null;
        List<User> list2 = new ArrayList<>();

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateObjects(list1).notEmpty()
        );
        assertThrows(ValidationException.class,
            () -> Validator.validateObjects(list2).notEmpty()
        );
    }

    @DisplayName("notEmpty: 리스트가 비어있지 않다면 아무 일도 일어나지 않는다.")
    @Test
    void notEmpty_whenListIsNotEmpty() {
        // given
        List<User> list = List.of(new User("John"), new User("Jane"));

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateObjects(list).notEmpty()
        );
    }

    @DisplayName("sizeAtLeast: 리스트가 null이라면 아무 일도 발생하지 않는다.")
    @Test
    void sizeAtLeast_whenListIsNull() {
        // given
        List<User> list = null;
        int min = 3;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateObjects(list).sizeAtLeast(min)
        );
    }

    @DisplayName("sizeAtLeast: 리스트의 크기가 인자보다 작다면 예외가 발생한다.")
    @Test
    void sizeAtLeast_whenListSizeLessThanMin() {
        // given
        List<User> list = List.of(new User("John"), new User("Jane"));
        int min = 3;

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateObjects(list).sizeAtLeast(min)
        );
    }

    @DisplayName("sizeAtLeast: 리스트의 크기가 min보다 같거나 크다면 아무 일도 발생하지 않는다.")
    @Test
    void sizeAtLeast_whenSatisfy() {
        // given
        List<User> list = List.of(new User("John"), new User("Jane"));
        int min = 2;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateObjects(list).sizeAtLeast(min)
        );
    }

    @DisplayName("sizeAtMost: 리스트가 null이라면 아무 일도 발생하지 않는다.")
    @Test
    void sizeAtMost_whenListIsNull() {
        // given
        List<User> list = null;
        int max = 3;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateObjects(list).sizeAtMost(max)
        );
    }

    @DisplayName("sizeAtMost: 리스트가 max보다 크다면 예외가 발생한다.")
    @Test
    void sizeAtMost_whenListSizeGreaterThanMax() {
        // given
        List<User> list = List.of(new User("John"), new User("Jane"));
        int max = 1;

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateObjects(list).sizeAtMost(max)
        );
    }

    @DisplayName("sizeAtMost: 리스트의 크기가 max보다 같거나 작다면 아무 일도 발생하지 않는다.")
    @Test
    void sizeAtMost_whenSatisfy() {
        // given
        List<User> list = List.of(new User("John"), new User("Jane"));
        int max = 2;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateObjects(list).sizeAtMost(max)
        );
        assertDoesNotThrow(
            () -> Validator.validateObjects(list).sizeAtMost(max + 1)
        );
    }

    @DisplayName("size: 리스트가 null이면 아무 일도 발생하지 않는다.")
    @Test
    void size_whenListIsNull() {
        // given
        List<User> list = null;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateObjects(list).size(1)
        );
    }

    @DisplayName("size: 리스트의 크기가 size와 같지 않으면 예외가 발생한다.")
    @Test
    void size_whenListSizeNotEqualsSize() {
        // given
        List<User> list = List.of(new User("John"), new User("Jane"));
        int size = 4;

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateObjects(list).size(size)
        );
    }

    @DisplayName("size: 리스트의 크기가 size와 같으면 아무 일도 발생하지 않는다.")
    @Test
    void size_whenListSizeEqualsSize() {
        // given
        List<User> list = List.of(new User("John"), new User("Jane"));
        int size = 2;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateObjects(list).size(size)
        );
    }

    @DisplayName("forEach: 리스트가 null이면 아무 일도 일어나지 않는다.")
    @Test
    void forEach_whenListIsNull() {
        // given
        List<User> list = null;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateObjects(list).forEach(null)
        );
    }

    @DisplayName("forEach: 리스트의 요소가 지정 조건을 만족하지 않는다면 예외가 발생한다.")
    @Test
    void forEach_whenNotSatisfy() {
        // given
        List<User> list = List.of(new User("John"), new User("Jane"));

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateObjects(list)
                .forEach(e -> e
                    .notNull()
                    .satisfies(
                        s -> s.name().startsWith("K")
                    )
                )
        );
    }

    @DisplayName("forEach: 리스트의 모든 요소가 조건을 만족한다면 아무 일도 일어나지 않는다.")
    @Test
    void forEach_whenSatisfy() {
        // given
        List<User> list = List.of(new User("John"), new User("Jane"));

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateObjects(list)
                .forEach(e -> e
                    .notNull()
                    .satisfies(
                        s -> s.name().startsWith("J")
                    )
                )
        );
    }
}
