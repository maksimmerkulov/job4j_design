package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Represents an iterator implementation for an array of integers.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
public class ArrayIterator implements Iterator<Integer> {

    /**
     * The underlying data array.
     */
    private final int[] data;

    /**
     * Current position in the array.
     */
    private int point;

    /**
     * Creates a new {@code ArrayIterator} with the specified data.
     *
     * @param data the array to iterate over
     */
    public ArrayIterator(int[] data) {
        this.data = data;
    }

    /**
     * Checks if there are more elements to iterate.
     *
     * @return {@code true} if there is a next element, {@code false} otherwise
     */
    @Override
    public boolean hasNext() {
        return point < data.length;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next integer value
     * @throws NoSuchElementException if there are no more elements
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }
}
