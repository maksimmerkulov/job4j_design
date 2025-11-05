package ru.job4j.generics;

/**
 * Represents a user entity extending {@link Base}.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
public class User extends Base {

    /**
     * The name of the user.
     */
    private final String username;

    /**
     * Creates a new {@code User} with the specified identifier and name.
     *
     * @param id   unique identifier
     * @param name user name
     */
    public User(String id, String name) {
        super(id);
        this.username = name;
    }

    /**
     * Returns the name of the user.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }
}
