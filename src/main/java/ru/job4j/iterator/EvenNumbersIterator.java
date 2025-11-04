package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Represents an iterator that returns only even numbers from an array.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
public class EvenNumbersIterator implements Iterator<Integer> {

    /**
     * The underlying data array.
     */
    private final int[] data;

    /**
     * Current position in the array.
     */
    private int index;

    /**
     * Creates a new {@code EvenNumbersIterator} for the specified array.
     *
     * @param data the array of integers to iterate over
     */
    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    /**
     * Checks if there is an even number from the current position.
     *
     * @return {@code true} if an even number exists, {@code false} otherwise
     */
    @Override
    public boolean hasNext() {
        while (index < data.length && data[index] % 2 != 0) {
            index++;
        }
        return index < data.length;
    }

    /**
     * Returns the next even number in the iteration.
     *
     * @return the next even integer value
     * @throws NoSuchElementException if no more even numbers are available
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }
}
