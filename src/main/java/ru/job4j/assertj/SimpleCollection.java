package ru.job4j.assertj;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Represents a simple fixed-size collection for testing purposes.
 *
 * @param <T> the type of elements in this collection
 * @author Maksim Merkulov
 * @version 1.0
 */
public class SimpleCollection<T> implements Iterable<T> {

    /**
     * Internal storage for elements.
     */
    private final T[] container = (T[]) new Object[5];

    /**
     * Creates a new {@code SimpleCollection} with the specified values.
     *
     * @param v0 the first element
     * @param v1 the second element
     * @param v2 the third element
     * @param v3 the fourth element
     * @param v4 the fifth element
     */
    public SimpleCollection(T v0, T v1, T v2, T v3, T v4) {
        this.container[0] = v0;
        this.container[1] = v1;
        this.container[2] = v2;
        this.container[3] = v3;
        this.container[4] = v4;
    }

    /**
     * Returns an iterator over the elements in this collection.
     *
     * @return an {@link Iterator} instance
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < container.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[index++];
            }
        };
    }
}
