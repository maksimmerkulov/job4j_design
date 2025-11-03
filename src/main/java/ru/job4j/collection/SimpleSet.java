package ru.job4j.collection;

import java.util.Arrays;
import java.util.Objects;

/**
 * Represents a simple set implementation for strings.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
public class SimpleSet {

    /**
     * Internal storage for elements.
     */
    private String[] container = new String[2];

    /**
     * Current number of elements in the set.
     */
    private int size;

    /**
     * Adds the specified value to the set if it is not already present.
     *
     * @param value the string to add
     * @return {@code true} if the value was added, {@code false} otherwise
     */
    public boolean add(String value) {
        if (size == container.length) {
            grow();
        }
        boolean result = !contains(value);
        if (result) {
            container[size++] = value;
        }
        return result;
    }

    /**
     * Checks if the set contains the specified value.
     *
     * @param value the string to check
     * @return {@code true} if the value exists, {@code false} otherwise
     */
    private boolean contains(String value) {
        boolean result = false;
        for (String element : container) {
            if (Objects.equals(value, element)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Increases the capacity of the internal storage.
     */
    private void grow() {
        container = Arrays.copyOf(container, container.length * 2);
    }
}
