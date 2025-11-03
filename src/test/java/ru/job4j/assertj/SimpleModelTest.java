package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests for the {@link SimpleModel} class focusing on exception handling.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
class SimpleModelTest {

    /**
     * Verifies that {@code getName()} throws {@code IllegalArgumentException}
     * when the name is empty.
     */
    @Test
    void checkGetName() {
        SimpleModel simpleModel = new SimpleModel();
        assertThatThrownBy(simpleModel::getName)
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * Verifies that {@code setName()} throws {@code IllegalArgumentException}
     * when the word length does not match the expected number.
     */
    @Test
    void checkName() {
        SimpleModel simpleModel = new SimpleModel();
        assertThatThrownBy(() -> simpleModel.setName("name", 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * Verifies that the exception thrown by {@code setName()} contains
     * a non-empty message.
     */
    @Test
    void checkMessage() {
        SimpleModel simpleModel = new SimpleModel();
        String word = "name";
        int number = 5;
        assertThatThrownBy(() -> simpleModel.setName(word, number))
                .isInstanceOf(IllegalArgumentException.class)
                .message()
                .isNotEmpty();
    }

    /**
     * Verifies the specific content and format of the exception message
     * thrown by {@code setName()}.
     */
    @Test
    void checkWordMessage() {
        SimpleModel simpleModel = new SimpleModel();
        String word = "name";
        int number = 5;
        assertThatThrownBy(() -> simpleModel.setName(word, number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(word, Integer.toString(number))
                .hasMessageContaining("name");
    }
}
