package ru.job4j.iterator;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests for the {@link FlatMap} class.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
class FlatMapTest {

    /**
     * Verifies that elements from different iterators are returned in order.
     */
    @Test
    void whenDiffNext() {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1).iterator(),
                List.of(2, 3).iterator()
        ).iterator();
        FlatMap<Integer> flatMap = new FlatMap<>(data);
        assertThat(flatMap.next()).isEqualTo(1);
        assertThat(flatMap.next()).isEqualTo(2);
        assertThat(flatMap.next()).isEqualTo(3);
    }

    /**
     * Verifies sequential retrieval from a single inner iterator.
     */
    @Test
    void whenSeqNext() {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1, 2, 3).iterator()
        ).iterator();
        FlatMap<Integer> flatMap = new FlatMap<>(data);
        assertThat(flatMap.next()).isEqualTo(1);
        assertThat(flatMap.next()).isEqualTo(2);
        assertThat(flatMap.next()).isEqualTo(3);
    }

    /**
     * Verifies that multiple calls to {@code hasNext()} do not affect state.
     */
    @Test
    void whenMultiHasNext() {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1).iterator()
        ).iterator();
        FlatMap<Integer> flatMap = new FlatMap<>(data);
        assertThat(flatMap.hasNext()).isTrue();
        assertThat(flatMap.hasNext()).isTrue();
    }

    /**
     * Verifies that {@code hasNext()} returns {@code false}
     * after all elements are read.
     */
    @Test
    void whenHasNextFalse() {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1).iterator()
        ).iterator();
        FlatMap<Integer> flatMap = new FlatMap<>(data);
        assertThat(flatMap.next()).isEqualTo(1);
        assertThat(flatMap.hasNext()).isFalse();
    }

    /**
     * Verifies that {@code next()} throws {@link NoSuchElementException}
     * on empty data.
     */
    @Test
    void whenEmpty() {
        Iterator<Iterator<Object>> data = List.of(
                Collections.emptyIterator()
        ).iterator();
        FlatMap<Object> flatMap = new FlatMap<>(data);
        assertThatThrownBy(flatMap::next)
                .isInstanceOf(NoSuchElementException.class);
    }

    /**
     * Verifies that {@code next()} throws {@link NoSuchElementException}
     * for empty integers.
     */
    @Test
    void whenEmptyInteger() {
        Iterator<Integer> empty = Collections.emptyIterator();
        Iterator<Iterator<Integer>> data = List.of(
                empty
        ).iterator();
        FlatMap<Integer> flatMap = new FlatMap<>(data);
        assertThatThrownBy(flatMap::next)
                .isInstanceOf(NoSuchElementException.class);
    }

    /**
     * Verifies that the iterator skips multiple empty inner iterators
     * to find data.
     */
    @Test
    void whenSeveralEmptyAndNotEmpty() {
        Iterator<Integer> empty = Collections.emptyIterator();
        Iterator<Iterator<Integer>> data = List.of(
                empty,
                empty,
                empty,
                List.of(1).iterator()
        ).iterator();
        FlatMap<Integer> flatMap = new FlatMap<>(data);
        assertThat(flatMap.hasNext()).isTrue();
        assertThat(flatMap.next()).isEqualTo(1);
    }

    /**
     * Verifies that {@code hasNext()} returns {@code false}
     * when all inner iterators are empty.
     */
    @Test
    void whenSeveralEmptyThenReturnFalse() {
        Iterator<Integer> empty = Collections.emptyIterator();
        Iterator<Iterator<Integer>> data = List.of(
                empty,
                empty,
                empty
        ).iterator();
        FlatMap<Integer> flatMap = new FlatMap<>(data);
        assertThat(flatMap.hasNext()).isFalse();
    }
}
