package ru.job4j.generics;

/**
 * Represents a role entity extending {@link Base}.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
public class Role extends Base {

    /**
     * The name of the role.
     */
    private final String roleName;

    /**
     * Creates a new {@code Role} with the specified identifier and name.
     *
     * @param id   unique identifier
     * @param name role name
     */
    public Role(String id, String name) {
        super(id);
        this.roleName = name;
    }

    /**
     * Returns the name of the role.
     *
     * @return the roleName
     */
    public String getRoleName() {
        return roleName;
    }
}
