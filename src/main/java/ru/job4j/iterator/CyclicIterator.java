package ru.job4j.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Iterates over a list repeatedly in a circular manner.
 *
 * @param <T> element type
 * @author Maksim Merkulov
 * @version 1.0
 */
public class CyclicIterator<T> implements Iterator<T> {

    /**
     * Source list of elements.
     */
    private final List<T> data;

    /**
     * Current position in the list.
     */
    private int index;

    /**
     * Creates a new {@code CyclicIterator} with the specified data.
     *
     * @param data source list
     */
    public CyclicIterator(List<T> data) {
        this.data = data;
    }

    /**
     * Checks if the iterator has more elements.
     *
     * @return {@code true} if the list is not empty, {@code false} otherwise
     */
    @Override
    public boolean hasNext() {
        return !data.isEmpty();
    }

    /**
     * Returns the next element, cycling back to the start if needed.
     *
     * @return next element in cycle
     * @throws NoSuchElementException if the list is empty
     */
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (index == data.size()) {
            index = 0;
        }
        return data.get(index++);
    }
}
