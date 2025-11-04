package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Represents an iterator that traverses an array in reverse order.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
public class BackwardArrayIterator implements Iterator<Integer> {

    /**
     * The underlying data array.
     */
    private final int[] data;

    /**
     * Current position in the array (starts from the last index).
     */
    private int point;

    /**
     * Creates a new {@code BackwardArrayIterator} for the specified array.
     *
     * @param data the array to iterate over in reverse
     */
    public BackwardArrayIterator(int[] data) {
        this.data = data;
        this.point = data.length - 1;
    }

    /**
     * Checks if there are more elements in the reverse iteration.
     *
     * @return {@code true} if there is a next element, {@code false} otherwise
     */
    @Override
    public boolean hasNext() {
        return point >= 0;
    }

    /**
     * Returns the next element in the reverse iteration.
     *
     * @return the next integer value from the end
     * @throws NoSuchElementException if no more elements are available
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point--];
    }
}
