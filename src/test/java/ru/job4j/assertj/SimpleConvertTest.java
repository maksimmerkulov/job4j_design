package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for the {@link SimpleConvert} class demonstrating collection assertions.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
class SimpleConvertTest {

    /**
     * Verifies array assertions including size, element existence,
     * and indexing.
     */
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray(
                "first", "second", "three", "four", "five"
        );
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    /**
     * Verifies list assertions such as requirements for specific elements
     * and order.
     */
    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList(
                "java", "kotlin", "spring", "docker"
        );
        assertThat(list).hasSize(4)
                .contains("java")
                .containsExactly("java", "kotlin", "spring", "docker")
                .startsWith("java")
                .endsWith("docker")
                .containsAnyOf("c#", "spring")
                .allSatisfy(s -> assertThat(s.length()).isGreaterThan(3));
    }

    /**
     * Verifies set assertions ensuring uniqueness and presence of elements.
     */
    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("red", "green", "blue", "red");
        assertThat(set).hasSize(3)
                .contains("red")
                .containsOnly("red", "green", "blue")
                .doesNotContain("yellow")
                .anyMatch(s -> s.startsWith("g"));
    }

    /**
     * Verifies map assertions including keys, values, and specific entries.
     */
    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap(
                "first", "second", "third"
        );
        assertThat(map).hasSize(3)
                .containsKeys("first", "third")
                .containsValues(0, 1, 2)
                .containsEntry("second", 1)
                .doesNotContainKey("fourth")
                .doesNotContainValue(5);
    }
}
