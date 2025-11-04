package ru.job4j.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests for the {@link EvenNumbersIterator} class.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
class EvenNumbersIteratorTest {

    /**
     * The iterator instance for testing.
     */
    private Iterator<Integer> iterator;

    /**
     * Initializes the iterator before each test.
     */
    @BeforeEach
    void setUp() {
        iterator = new EvenNumbersIterator(
                new int[]{1, -3, 2, 3, 5, 5, -4, 5, 6, 7}
        );
    }

    /**
     * Verifies that the iterator returns all even numbers sequentially
     * and throws an exception at the end.
     */
    @Test
    void shouldReturnEvenNumbersSequentially() {
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(-4);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(6);
        assertThat(iterator.hasNext()).isFalse();
        assertThatThrownBy(iterator::next)
                .isInstanceOf(NoSuchElementException.class);
    }

    /**
     * Verifies that multiple calls to {@code hasNext()} do not affect
     * the retrieval order of elements.
     */
    @Test
    void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.next()).isEqualTo(-4);
        assertThat(iterator.next()).isEqualTo(6);
    }

    /**
     * Verifies that {@code hasNext()} returns {@code false} if there
     * are no even numbers.
     */
    @Test
    void shouldReturnFalseIfNoAnyEvenNumbers() {
        iterator = new EvenNumbersIterator(new int[]{1});
        assertThat(iterator.hasNext()).isFalse();
    }

    /**
     * Verifies that {@code hasNext()} returns {@code false} for an empty array.
     */
    @Test
    void shouldReturnFalseIfNoAnyNumbers() {
        iterator = new EvenNumbersIterator(new int[]{});
        assertThat(iterator.hasNext()).isFalse();
    }

    /**
     * Verifies the iterator behavior when all numbers in the array are even.
     */
    @Test
    void allNumbersAreEven() {
        iterator = new EvenNumbersIterator(new int[]{2, 4, 6, 8});
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(4);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(6);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(8);
        assertThat(iterator.hasNext()).isFalse();
    }

    /**
     * Verifies that the iterator correctly handles an array containing
     * only odd numbers.
     */
    @Test
    void allNumbersAreOdd() {
        iterator = new EvenNumbersIterator(new int[]{1, 3, 5, 7});
        assertThat(iterator.hasNext()).isFalse();
        assertThat(iterator.hasNext()).isFalse();
    }
}
