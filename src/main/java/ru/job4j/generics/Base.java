package ru.job4j.generics;

/**
 * Represents a base model with a unique identifier.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
public abstract class Base {

    /**
     * Unique identifier of the model.
     */
    private final String id;

    /**
     * Creates a new {@code Base} model with the specified identifier.
     *
     * @param id unique identifier
     */
    public Base(final String id) {
        this.id = id;
    }

    /**
     * Returns the unique identifier of the model.
     *
     * @return unique id
     */
    public String getId() {
        return id;
    }
}
