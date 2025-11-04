package ru.job4j.iterator;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests for the {@link CyclicIterator} class.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
class CyclicIteratorTest {

    /**
     * Verifies that {@code hasNext()} is {@code false} for an empty list.
     */
    @Test
    void whenEmptyThenHasNextIsFalse() {
        CyclicIterator<Integer> iterator = new CyclicIterator<>(List.of());
        assertThat(iterator.hasNext()).isFalse();
    }

    /**
     * Verifies that {@code next()} throws {@link NoSuchElementException}
     * when the list is empty.
     */
    @Test
    void whenEmptyAndNextThenThrow() {
        CyclicIterator<Integer> iterator = new CyclicIterator<>(List.of());
        assertThatThrownBy(iterator::next)
                .isInstanceOf(NoSuchElementException.class);
    }

    /**
     * Verifies that {@code hasNext()} is {@code true} for a non-empty list.
     */
    @Test
    void whenNotEmptyThenHasNextIsTrue() {
        CyclicIterator<Integer> iterator = new CyclicIterator<>(List.of(1));
        assertThat(iterator.hasNext()).isTrue();
    }

    /**
     * Verifies that multiple calls to {@code hasNext()}
     * do not change the iterator state.
     */
    @Test
    void whenNotEmptyThenSomeHasNextIsTrue() {
        CyclicIterator<Integer> iterator = new CyclicIterator<>(List.of(1));
        iterator.hasNext();
        assertThat(iterator.hasNext()).isTrue();
    }

    /**
     * Verifies that a single-element list is iterated repeatedly.
     */
    @Test
    void whenOneElementThenNext() {
        CyclicIterator<Integer> iterator = new CyclicIterator<>(List.of(1));
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(1);
    }

    /**
     * Verifies that the iterator cycles back to the start
     * after reaching the end of a multi-element list.
     */
    @Test
    void whenNotEmptyThenNext() {
        CyclicIterator<Integer> iterator =
                new CyclicIterator<>(List.of(1, 2, 3));
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(3);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(3);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.hasNext()).isTrue();
    }
}
