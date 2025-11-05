package ru.job4j.generics;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for the {@link RoleStore} class.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
class RoleStoreTest {

    /**
     * Verifies that an added role can be found by its identifier.
     */
    @Test
    void whenAddAndFindThenRoleNameIsAdmin() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Admin");
    }

    /**
     * Verifies that searching for a non-existent role returns {@code null}.
     */
    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        Role result = store.findById("10");
        assertThat(result).isNull();
    }

    /**
     * Verifies that adding a role with a duplicate ID does not overwrite
     * the existing one.
     */
    @Test
    void whenAddDuplicateAndFindRoleNameIsAdmin() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        store.add(new Role("1", "User"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Admin");
    }

    /**
     * Verifies that an existing role can be replaced with a new model.
     */
    @Test
    void whenReplaceThenRoleNameIsUser() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        store.replace("1", new Role("1", "User"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("User");
    }

    /**
     * Verifies that replacement fails and does not affect data if the ID
     * is not found.
     */
    @Test
    void whenNoReplaceRoleThenNoChangeRoleName() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        store.replace("10", new Role("10", "User"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Admin");
    }

    /**
     * Verifies that a role is successfully removed from the store.
     */
    @Test
    void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    /**
     * Verifies that deleting a non-existent role does not affect existing data.
     */
    @Test
    void whenNoDeleteRoleThenRoleNameIsAdmin() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Admin");
    }

    /**
     * Verifies that {@code replace} returns {@code true} on success.
     */
    @Test
    void whenReplaceOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        boolean result = store.replace("1", new Role("1", "User"));
        assertThat(result).isTrue();
    }

    /**
     * Verifies that {@code replace} returns {@code false} when ID is not found.
     */
    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        boolean result = store.replace("10", new Role("10", "User"));
        assertThat(result).isFalse();
    }
}
