package ru.job4j.iterator;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Flattens an iterator of iterators into a single sequential iteration.
 *
 * <p>Example output:
 * <pre>{@code
 * 1
 * 2
 * ...
 * 9
 * }</pre>
 *
 * @param <T> element type
 * @author Maksim Merkulov
 * @version 1.0
 */
public class FlatMap<T> implements Iterator<T> {

    /**
     * Source of nested iterators.
     */
    private final Iterator<Iterator<T>> data;

    /**
     * Current element provider.
     */
    private Iterator<T> cursor = Collections.emptyIterator();

    /**
     * Creates a new {@code FlatMap} with the specified data.
     *
     * @param data source iterators
     */
    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
    }

    /**
     * Checks if more elements are available.
     *
     * @return {@code true} if elements remain, {@code false} otherwise
     */
    @Override
    public boolean hasNext() {
        while (data.hasNext() && !cursor.hasNext()) {
            cursor = data.next();
        }
        return cursor.hasNext();
    }

    /**
     * Returns the next element.
     *
     * @return next element
     * @throws NoSuchElementException if no more elements exist
     */
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return cursor.next();
    }

    /**
     * Entry point of the program.
     *
     * @param args command-line arguments; not used
     */
    public static void main(String[] args) {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1, 2, 3).iterator(),
                List.of(4, 5, 6).iterator(),
                List.of(7, 8, 9).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        while (flat.hasNext()) {
            System.out.println(flat.next());
        }
    }
}
