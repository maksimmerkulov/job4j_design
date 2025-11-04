package ru.job4j.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests for the {@link NonNullIterator} class.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
class NonNullIteratorTest {

    /**
     * The iterator instance for testing.
     */
    private Iterator<Integer> iterator;

    /**
     * Initializes the iterator before each test.
     */
    @BeforeEach
    void setUp() {
        iterator = new NonNullIterator(
                new Integer[]{
                        null, null, 2, null, null, null, -4, null, 6, null
                }
        );
    }

    /**
     * Verifies that the iterator returns all non-null elements sequentially.
     */
    @Test
    void shouldReturnNotNullElementsSequentially() {
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
     * Verifies that multiple calls to {@code hasNext()} do not affect state.
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
     * Verifies that {@code hasNext()} returns {@code false}
     * if all elements are null.
     */
    @Test
    void shouldReturnFalseIfNoAnyNotNullElements() {
        iterator = new NonNullIterator(new Integer[]{null});
        assertThat(iterator.hasNext()).isFalse();
    }

    /**
     * Verifies that {@code hasNext()} returns {@code false} for an empty array.
     */
    @Test
    void shouldReturnFalseIfNoAnyElements() {
        iterator = new NonNullIterator(new Integer[]{});
        assertThat(iterator.hasNext()).isFalse();
    }

    /**
     * Verifies behavior when the array contains only non-null numbers.
     */
    @Test
    void allNumbersAreNotNull() {
        iterator = new NonNullIterator(new Integer[]{2, 4, 6, 8});
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
     * Verifies that the iterator handles an array containing only null values.
     */
    @Test
    void allNumbersAreNull() {
        iterator = new NonNullIterator(new Integer[]{null, null, null, null});
        assertThat(iterator.hasNext()).isFalse();
        assertThat(iterator.hasNext()).isFalse();
    }
}
