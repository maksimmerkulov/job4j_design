package ru.job4j.generics;

/**
 * Provides storage for {@link User} objects by delegating to {@link MemStore}.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
public class UserStore implements Store<User> {

    /**
     * Internal storage implementation.
     */
    private final Store<User> store = new MemStore<>();

    /**
     * Adds the specified user to the store.
     *
     * @param model the user to add
     */
    @Override
    public void add(User model) {
        store.add(model);
    }

    /**
     * Replaces the user with the specified identifier.
     *
     * @param id    unique identifier
     * @param model the new user model
     * @return {@code true} if the user was replaced, {@code false} otherwise
     */
    @Override
    public boolean replace(String id, User model) {
        return store.replace(id, model);
    }

    /**
     * Deletes the user from the store by identifier.
     *
     * @param id unique identifier
     */
    @Override
    public void delete(String id) {
        store.delete(id);
    }

    /**
     * Finds a user by unique identifier.
     *
     * @param id unique identifier
     * @return the found user, or {@code null} if not found
     */
    @Override
    public User findById(String id) {
        return store.findById(id);
    }
}
