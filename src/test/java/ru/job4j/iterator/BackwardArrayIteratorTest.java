package ru.job4j.iterator;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests for the {@link BackwardArrayIterator} class.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
class BackwardArrayIteratorTest {

    /**
     * Verifies that multiple calls to {@code hasNext()} consistently return
     * {@code true} and do not advance the iterator position.
     */
    @Test
    void whenMultiCallHasNextThenTrue() {
        BackwardArrayIterator iterator = new BackwardArrayIterator(
                new int[]{1, 2, 3, 4}
        );
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(4);
        assertThat(iterator.next()).isEqualTo(3);
        assertThat(iterator.hasNext()).isTrue();
    }

    /**
     * Verifies {@code hasNext()} stability before calling {@code next()}.
     */
    @Test
    void whenMultiCallHasNextThenNext() {
        BackwardArrayIterator iterator = new BackwardArrayIterator(
                new int[]{1, 2, 3}
        );
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(3);
    }

    /**
     * Verifies that the iterator returns elements in the correct
     * reverse sequence.
     */
    @Test
    void whenReadSequence() {
        BackwardArrayIterator iterator = new BackwardArrayIterator(
                new int[]{1, 2, 3}
        );
        assertThat(iterator.next()).isEqualTo(3);
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.hasNext()).isFalse();
    }

    /**
     * Verifies that calling {@code next()} on an empty iterator
     * throws {@link NoSuchElementException}.
     */
    @Test
    void whenNextFromEmpty() {
        BackwardArrayIterator iterator = new BackwardArrayIterator(
                new int[]{}
        );
        assertThatThrownBy(iterator::next)
                .isInstanceOf(NoSuchElementException.class);
    }
}
