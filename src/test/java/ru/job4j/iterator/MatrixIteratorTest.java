package ru.job4j.iterator;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests for the {@link MatrixIterator} class.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
class MatrixIteratorTest {

    /**
     * Verifies iteration over a single-element matrix.
     */
    @Test
    void when4El() {
        int[][] input = {
                {1}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        assertThat(iterator.next()).isEqualTo(1);
    }

    /**
     * Verifies that the iterator skips an empty first row.
     */
    @Test
    void whenFirstEmptyThenNext() {
        int[][] input = {
                {}, {1}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        assertThat(iterator.next()).isEqualTo(1);
    }

    /**
     * Verifies {@code hasNext()} when the first row is empty.
     */
    @Test
    void whenFirstEmptyThenHasNext() {
        int[][] input = {
                {}, {1}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        assertThat(iterator.hasNext()).isTrue();
    }

    /**
     * Verifies iteration over a jagged matrix with multiple empty rows.
     */
    @Test
    void whenRowHasDiffSize() {
        int[][] input = {
                {1}, {2, 3}, {}, {}, {4}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.next()).isEqualTo(3);
        assertThat(iterator.next()).isEqualTo(4);
        assertThat(iterator.hasNext()).isFalse();
    }

    /**
     * Verifies skipping several consecutive empty rows.
     */
    @Test
    void whenFewEmpty() {
        int[][] input = {
                {1}, {}, {}, {}, {2}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.hasNext()).isFalse();
    }

    /**
     * Verifies {@code hasNext()} for a matrix with only one empty row.
     */
    @Test
    void whenEmpty() {
        int[][] input = {
                {}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        assertThat(iterator.hasNext()).isFalse();
    }

    /**
     * Verifies that {@code next()} throws {@link NoSuchElementException}
     * for an empty matrix.
     */
    @Test
    void whenEmptyThenNext() {
        int[][] input = {
                {}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        assertThatThrownBy(iterator::next)
                .isInstanceOf(NoSuchElementException.class);
    }

    /**
     * Verifies that multiple {@code hasNext()} calls do not
     * affect the iteration.
     */
    @Test
    void whenMultiHasNext() {
        int[][] input = {
                {}, {1}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.hasNext()).isTrue();
    }

    /**
     * Verifies that a matrix consisting only of empty rows
     * is handled correctly.
     */
    @Test
    void whenNoElements() {
        int[][] input = {
                {}, {}, {}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        assertThat(iterator.hasNext()).isFalse();
    }
}
