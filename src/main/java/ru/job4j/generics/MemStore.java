package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;

/**
 * Provides in-memory storage for {@link Base} objects using a hash map.
 *
 * @param <T> the type of elements in the store
 * @author Maksim Merkulov
 * @version 1.0
 */
public final class MemStore<T extends Base> implements Store<T> {

    /**
     * Internal storage map where the key is the model identifier.
     */
    private final Map<String, T> storage = new HashMap<>();

    /**
     * Adds the specified model to the storage if it doesn't already exist.
     *
     * @param model the model to add
     */
    @Override
    public void add(T model) {
        storage.putIfAbsent(model.getId(), model);
    }

    /**
     * Replaces the model with the specified identifier.
     *
     * @param id    unique identifier of the model to replace
     * @param model the new model to store
     * @return {@code true} if the replacement was successful,
     * {@code false} otherwise
     */
    @Override
    public boolean replace(String id, T model) {
        return storage.replace(id, model) != null;
    }

    /**
     * Deletes the model from the storage by its identifier.
     *
     * @param id unique identifier of the model to delete
     */
    @Override
    public void delete(String id) {
        storage.remove(id);
    }

    /**
     * Finds a model by its unique identifier.
     *
     * @param id unique identifier of the model to find
     * @return the found model, or {@code null} if no such model exists
     */
    @Override
    public T findById(String id) {
        return storage.get(id);
    }
}
