package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Represents an iterator for a two-dimensional array (matrix).
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
public class MatrixIterator implements Iterator<Integer> {

    /**
     * The underlying matrix data.
     */
    private final int[][] data;

    /**
     * Current row index.
     */
    private int row;

    /**
     * Current column index.
     */
    private int column;

    /**
     * Creates a new {@code MatrixIterator} for the specified matrix.
     *
     * @param data the two-dimensional array to iterate over
     */
    public MatrixIterator(int[][] data) {
        this.data = data;
    }

    /**
     * Checks if there are more elements in the matrix, skipping empty rows.
     *
     * @return {@code true} if there is a next element, {@code false} otherwise
     */
    @Override
    public boolean hasNext() {
        while (row < data.length && column == data[row].length) {
            row++;
            column = 0;
        }
        return row < data.length;
    }

    /**
     * Returns the next element from the matrix.
     *
     * @return the next integer value
     * @throws NoSuchElementException if there are no more elements
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }
}
