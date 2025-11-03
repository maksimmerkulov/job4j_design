package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests for the {@link NameLoad} class focusing on exception validation.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
class NameLoadTest {

    /**
     * Verifies that {@code getMap()} throws {@code IllegalStateException}
     * when no data has been parsed.
     */
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    /**
     * Verifies that {@code parse()} throws {@code IllegalArgumentException}
     * when the input array is empty.
     */
    @Test
    void checkParseEmptyArray() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("array is empty");
    }

    /**
     * Verifies that validation fails if the string does not contain '='.
     */
    @Test
    void checkValidateNoSymbol() {
        NameLoad nameLoad = new NameLoad();
        String name = "key:value";
        assertThatThrownBy(() -> nameLoad.parse(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(name)
                .hasMessageContaining("symbol '='");
    }

    /**
     * Verifies that validation fails if the string starts with '=' (no key).
     */
    @Test
    void checkValidateNoKey() {
        NameLoad nameLoad = new NameLoad();
        String name = "=value";
        assertThatThrownBy(() -> nameLoad.parse(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(name)
                .hasMessageContaining("does not contain a key");
    }

    /**
     * Verifies that validation fails if the string ends with '=' (no value).
     */
    @Test
    void checkValidateNoValue() {
        NameLoad nameLoad = new NameLoad();
        String name = "key=";
        assertThatThrownBy(() -> nameLoad.parse(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(name)
                .hasMessageContaining("does not contain a value");
    }
}
