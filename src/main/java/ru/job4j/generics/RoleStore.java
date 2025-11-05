package ru.job4j.generics;

/**
 * Provides storage for {@link Role} objects by delegating to {@link MemStore}.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
public class RoleStore implements Store<Role> {

    /**
     * Internal storage implementation.
     */
    private final Store<Role> store = new MemStore<>();

    /**
     * Adds the specified role to the store.
     *
     * @param model the role to add
     */
    @Override
    public void add(Role model) {
        store.add(model);
    }

    /**
     * Replaces the role with the specified identifier.
     *
     * @param id    unique identifier
     * @param model the new role model
     * @return {@code true} if the role was replaced, {@code false} otherwise
     */
    @Override
    public boolean replace(String id, Role model) {
        return store.replace(id, model);
    }

    /**
     * Deletes the role from the store by identifier.
     *
     * @param id unique identifier
     */
    @Override
    public void delete(String id) {
        store.delete(id);
    }

    /**
     * Finds a role by unique identifier.
     *
     * @param id unique identifier
     * @return the found role, or {@code null} if not found
     */
    @Override
    public Role findById(String id) {
        return store.findById(id);
    }
}
