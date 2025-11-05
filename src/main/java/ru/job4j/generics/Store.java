package ru.job4j.generics;

/**
 * Interface for a generic data store.
 *
 * @param <T> the type of elements in the store, must extend {@link Base}
 * @author Maksim Merkulov
 * @version 1.0
 */
public interface Store<T extends Base> {

    /**
     * Adds the specified model to the store.
     *
     * @param model the model to add
     */
    void add(T model);

    /**
     * Replaces the model with the specified identifier.
     *
     * @param id    unique identifier of the model to replace
     * @param model the new model to store
     * @return {@code true} if the replacement was successful,
     *         {@code false} otherwise
     */
    boolean replace(String id, T model);

    /**
     * Deletes the model with the specified identifier.
     *
     * @param id unique identifier of the model to delete
     */
    void delete(String id);

    /**
     * Finds a model by its unique identifier.
     *
     * @param id unique identifier of the model to find
     * @return the found model, or {@code null} if no such model exists
     */
    T findById(String id);
}
