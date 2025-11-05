package ru.job4j.generics;

/**
 * Represents a node in a generic linked structure with comparable data.
 *
 * @param <T> the type of data, must be comparable
 * @author Maksim Merkulov
 * @version 1.0
 */
public class Node<T extends Comparable<T>> {

    /**
     * The data stored in the node.
     */
    private T data;

    /**
     * Reference to the next node.
     */
    private Node<T> next;

    /**
     * Creates a new {@code Node} with the specified data and next node.
     *
     * @param data the data to store
     * @param next the next node in the structure
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Returns the data stored in this node.
     *
     * @return the data
     */
    public T getData() {
        return data;
    }
}
