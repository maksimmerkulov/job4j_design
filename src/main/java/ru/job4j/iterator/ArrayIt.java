package ru.job4j.iterator;

import java.util.Iterator;

/**
 * Iterator implementation for an integer array.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
public class ArrayIt implements Iterator<Integer> {

    /**
     * The source data array.
     */
    private final int[] data;

    /**
     * Current position in the array.
     */
    private int point = 0;

    /**
     * Creates a new {@code ArrayIt} with the specified data.
     *
     * @param data the array to iterate over
     */
    public ArrayIt(int[] data) {
        this.data = data;
    }

    /**
     * Checks if there are more elements in the array.
     *
     * @return {@code true} if there is a next element, {@code false} otherwise
     */
    @Override
    public boolean hasNext() {
        return point < data.length;
    }

    /**
     * Returns the next element from the array.
     *
     * @return the next integer
     */
    @Override
    public Integer next() {
        return data[point++];
    }
}
