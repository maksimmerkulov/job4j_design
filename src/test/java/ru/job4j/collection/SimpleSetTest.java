package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for the {@link SimpleSet} class.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
class SimpleSetTest {

    /**
     * Verifies that adding a duplicate element returns {@code false}
     * after several successful additions.
     */
    @Test
    void when4AddAndAddFirstThenFalse() {
        SimpleSet set = new SimpleSet();
        set.add("first");
        set.add("second");
        set.add("third");
        set.add("four");
        assertThat(set.add("first")).isFalse();
    }
}
