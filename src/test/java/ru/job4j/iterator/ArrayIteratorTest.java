package ru.job4j.iterator;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for the {@link ArrayIterator} class.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
class ArrayIteratorTest {

    /**
     * Verifies that multiple calls to {@code hasNext()} do not change
     * the iterator state and consistently return {@code true}.
     */
    @Test
    void whenMultiCallhasNextThenTrue() {
        ArrayIterator iterator = new ArrayIterator(
                new int[]{1, 2, 3}
        );
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
    }

    /**
     * Verifies that the iterator returns elements in the correct order.
     */
    @Test
    void whenReadSequence() {
        ArrayIterator iterator = new ArrayIterator(
                new int[]{1, 2, 3}
        );
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.next()).isEqualTo(3);
    }

    /**
     * Verifies that calling {@code next()} on an empty iterator
     * throws {@link NoSuchElementException}.
     */
    @Test
    void whenNextFromEmpty() {
        ArrayIterator iterator = new ArrayIterator(
                new int[]{}
        );
        assertThatThrownBy(iterator::next)
                .isInstanceOf(NoSuchElementException.class);
    }
}
