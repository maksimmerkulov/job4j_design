package ru.job4j.iterator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for the {@link ArrayIt} class.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
class ArrayItTest {

    /**
     * Verifies that multiple calls to {@code hasNext()} return {@code true}
     * for a non-empty array.
     */
    @Test
    void whenMultiCallHasNextThenTrue() {
        ArrayIt iterator = new ArrayIt(
                new int[]{1, 2, 3}
        );
        boolean result = iterator.hasNext();
        assertThat(result).isTrue();
        assertThat(iterator.hasNext()).isTrue();
    }

    /**
     * Verifies that the iterator correctly returns all elements in sequence.
     */
    @Test
    void whenReadSequence() {
        ArrayIt iterator = new ArrayIt(
                new int[]{1, 2, 3}
        );
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.next()).isEqualTo(3);
    }
}
