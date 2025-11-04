package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Returns only non-null elements from an array of integers.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
public class NonNullIterator implements Iterator<Integer> {

    /**
     * Source array containing integers and nulls.
     */
    private final Integer[] data;

    /**
     * Current index in the array.
     */
    private int index;

    /**
     * Creates a new {@code NonNullIterator} with the specified data.
     *
     * @param data source array
     */
    public NonNullIterator(Integer[] data) {
        this.data = data;
    }

    /**
     * Checks if there is a non-null element from the current position.
     *
     * @return {@code true} if a non-null element exists,
     *         {@code false} otherwise
     */
    @Override
    public boolean hasNext() {
        while (index < data.length && data[index] == null) {
            index++;
        }
        return index < data.length;
    }

    /**
     * Returns the next non-null element.
     *
     * @return next non-null integer
     * @throws NoSuchElementException if no more non-null elements exist
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }
}
