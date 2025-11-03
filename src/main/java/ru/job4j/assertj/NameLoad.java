package ru.job4j.assertj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Loads and parses names from strings into a key-value map.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
public class NameLoad {

    /**
     * Storage for parsed key-value pairs.
     */
    private final Map<String, String> values = new HashMap<>();

    /**
     * Parses the specified names and adds them to the map.
     *
     * @param names the array of strings to parse
     * @throws IllegalArgumentException if names array is empty
     *                                  or format is invalid
     */
    public void parse(String... names) {
        if (names.length == 0) {
            throw new IllegalArgumentException("Names array is empty");
        }
        values.putAll(Arrays.stream(names)
                .map(String::trim)
                .filter(this::validate)
                .map(line -> line.split("=", 2))
                .collect(Collectors.toMap(
                        e -> e[0],
                        e -> e[1],
                        (first, second) -> "%s+%s".formatted(first, second)
                )));
    }

    /**
     * Validates the format of a single name string.
     *
     * @param name the string to validate
     * @return {@code true} if valid
     * @throws IllegalArgumentException if format validation fails
     */
    private boolean validate(String name) {
        if (!name.contains("=")) {
            throw new IllegalArgumentException(
                    "this name: %s does not contain the symbol '='"
                            .formatted(name));
        }
        if (name.startsWith("=")) {
            throw new IllegalArgumentException(
                    "this name: %s does not contain a key".formatted(name));
        }
        if (name.indexOf("=") == name.length() - 1) {
            throw new IllegalArgumentException(
                    "this name: %s does not contain a value".formatted(name));
        }
        return true;
    }

    /**
     * Returns the map of parsed values.
     *
     * @return the values map
     * @throws IllegalStateException if the map is empty
     */
    public Map<String, String> getMap() {
        if (values.isEmpty()) {
            throw new IllegalStateException("collection contains no data");
        }
        return values;
    }
}
