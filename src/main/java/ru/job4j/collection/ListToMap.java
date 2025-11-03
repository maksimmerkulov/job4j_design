package ru.job4j.collection;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Demonstrates converting a stream of integers to a map with square values.
 *
 * <p>Example output:
 * <pre>{@code
 * {1=1, 2=4}
 * }</pre>
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
public class ListToMap {

    /**
     * Entry point of the program.
     *
     * @param args command-line arguments; not used
     */
    public static void main(String[] args) {
        System.out.println(
                Stream.of(1, 1, 2, 2).collect(
                        Collectors.toMap(
                                e -> e,
                                e -> e * e,
                                (existing, replacement) -> existing
                        ))
        );
    }
}
