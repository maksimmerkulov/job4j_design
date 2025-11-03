package ru.job4j.assertj;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Provides methods to convert arrays of strings into various collection types.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
public class SimpleConvert {

    /**
     * Returns the input arguments as an array.
     *
     * @param example the strings to include in the array
     * @return an array of strings
     */
    public String[] toArray(String... example) {
        return example;
    }

    /**
     * Converts the input arguments into a {@link List}.
     *
     * @param example the strings to include in the list
     * @return a list of strings
     */
    public List<String> toList(String... example) {
        return Arrays.stream(example).toList();
    }

    /**
     * Converts the input arguments into a {@link Set}.
     *
     * @param example the strings to include in the set
     * @return a set of unique strings
     */
    public Set<String> toSet(String... example) {
        return Arrays.stream(example).collect(Collectors.toSet());
    }

    /**
     * Converts the input arguments into a {@link Map} where keys are strings
     * and values are their first occurrence indices.
     *
     * @param example the strings to include in the map
     * @return a map of strings to indices
     */
    public Map<String, Integer> toMap(String... example) {
        return Stream.iterate(0, i -> i < example.length, i -> i + 1)
                .collect(Collectors.toMap(
                        i -> example[i],
                        i -> i,
                        (s1, s2) -> s1
                ));
    }
}
