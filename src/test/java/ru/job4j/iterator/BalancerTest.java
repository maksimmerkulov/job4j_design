package ru.job4j.iterator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for the {@link Balancer} class.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
class BalancerTest {

    /**
     * Verifies distribution when there is only one node and three elements.
     */
    @Test
    void whenSingleAndIteratorThree() {
        List<ArrayList<Integer>> nodes = List.of(
                new ArrayList<>()
        );
        Iterator<Integer> source = List.of(1, 2, 3).iterator();
        Balancer.split(nodes, source);
        assertThat(nodes).isEqualTo(
                List.of(
                        List.of(1, 2, 3)
                )
        );
    }

    /**
     * Verifies that nodes remain empty if the source iterator is empty.
     */
    @Test
    void whenThreeListsAndIteratorEmpty() {
        List<ArrayList<Integer>> nodes = List.of(
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );
        Iterator<Integer> source = Collections.emptyIterator();
        Balancer.split(nodes, source);
        assertThat(nodes).containsExactlyInAnyOrder(
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );
    }

    /**
     * Verifies even distribution across two lists for three elements.
     */
    @Test
    void whenTwoListsAndIteratorThree() {
        List<ArrayList<Integer>> nodes = List.of(
                new ArrayList<>(),
                new ArrayList<>()
        );
        Iterator<Integer> source = List.of(1, 2, 3).iterator();
        Balancer.split(nodes, source);
        assertThat(nodes).containsExactlyInAnyOrder(
                new ArrayList<>(List.of(1, 3)),
                new ArrayList<>(List.of(2))
        );
    }

    /**
     * Verifies one-by-one distribution when element count equals list count.
     */
    @Test
    void whenThreeListsAndIteratorThree() {
        List<ArrayList<Integer>> nodes = List.of(
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );
        Iterator<Integer> source = List.of(1, 2, 3).iterator();
        Balancer.split(nodes, source);
        assertThat(nodes).containsExactlyInAnyOrder(
                new ArrayList<>(List.of(1)),
                new ArrayList<>(List.of(2)),
                new ArrayList<>(List.of(3))
        );
    }

    /**
     * Verifies that some lists may remain empty if elements are few.
     */
    @Test
    void whenThreeListsAndIteratorTwo() {
        List<ArrayList<Integer>> nodes = List.of(
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );
        Iterator<Integer> source = List.of(1, 2).iterator();
        Balancer.split(nodes, source);
        assertThat(nodes).containsExactlyInAnyOrder(
                new ArrayList<>(List.of(1)),
                new ArrayList<>(List.of(2)),
                new ArrayList<>()
        );
    }

    /**
     * Verifies distribution for four elements across three lists.
     */
    @Test
    void whenThreeListsAndIteratorFour() {
        List<ArrayList<Integer>> nodes = List.of(
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );
        Iterator<Integer> source = List.of(1, 2, 3, 4).iterator();
        Balancer.split(nodes, source);
        assertThat(nodes).containsExactlyInAnyOrder(
                new ArrayList<>(List.of(1, 4)),
                new ArrayList<>(List.of(2)),
                new ArrayList<>(List.of(3))
        );
    }

    /**
     * Verifies distribution for five elements across three lists.
     */
    @Test
    void whenThreeListsAndIteratorFive() {
        List<ArrayList<Integer>> nodes = List.of(
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );
        Iterator<Integer> source = List.of(1, 2, 3, 4, 5).iterator();
        Balancer.split(nodes, source);
        assertThat(nodes).containsExactlyInAnyOrder(
                new ArrayList<>(List.of(1, 4)),
                new ArrayList<>(List.of(2, 5)),
                new ArrayList<>(List.of(3))
        );
    }

    /**
     * Verifies distribution for six elements across three lists.
     */
    @Test
    void whenThreeListsAndIteratorSix() {
        List<ArrayList<Integer>> nodes = List.of(
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );
        Iterator<Integer> source = List.of(1, 2, 3, 4, 5, 6).iterator();
        Balancer.split(nodes, source);
        assertThat(nodes).containsExactlyInAnyOrder(
                new ArrayList<>(List.of(1, 4)),
                new ArrayList<>(List.of(2, 5)),
                new ArrayList<>(List.of(3, 6))
        );
    }
}
