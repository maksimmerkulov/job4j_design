package ru.job4j.generics;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for the {@link UserStore} class.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
class UserStoreTest {

    /**
     * Verifies that an added user can be found by their identifier.
     */
    @Test
    void whenAddAndFindThenUsernameIsPetr() {
        UserStore store = new UserStore();
        store.add(new User("1", "Petr"));
        User result = store.findById("1");
        assertThat(result.getUsername()).isEqualTo("Petr");
    }

    /**
     * Verifies that searching for a non-existent user returns {@code null}.
     */
    @Test
    void whenAddAndFindThenUserIsNull() {
        UserStore store = new UserStore();
        store.add(new User("1", "Petr"));
        User result = store.findById("10");
        assertThat(result).isNull();
    }

    /**
     * Verifies that adding a user with a duplicate ID does not overwrite
     * the existing one.
     */
    @Test
    void whenAddDuplicateAndFindUsernameIsPetr() {
        UserStore store = new UserStore();
        store.add(new User("1", "Petr"));
        store.add(new User("1", "Maxim"));
        User result = store.findById("1");
        assertThat(result.getUsername()).isEqualTo("Petr");
    }

    /**
     * Verifies that an existing user can be replaced with a new model.
     */
    @Test
    void whenReplaceThenUsernameIsMaxim() {
        UserStore store = new UserStore();
        store.add(new User("1", "Petr"));
        store.replace("1", new User("1", "Maxim"));
        User result = store.findById("1");
        assertThat(result.getUsername()).isEqualTo("Maxim");
    }

    /**
     * Verifies that replacement fails and does not affect data if the ID
     * is not found.
     */
    @Test
    void whenNoReplaceUserThenNoChangeUsername() {
        UserStore store = new UserStore();
        store.add(new User("1", "Petr"));
        store.replace("10", new User("10", "Maxim"));
        User result = store.findById("1");
        assertThat(result.getUsername()).isEqualTo("Petr");
    }

    /**
     * Verifies that a user is successfully removed from the store.
     */
    @Test
    void whenDeleteUserThenUserIsNull() {
        UserStore store = new UserStore();
        store.add(new User("1", "Petr"));
        store.delete("1");
        User result = store.findById("1");
        assertThat(result).isNull();
    }

    /**
     * Verifies that deleting a non-existent user does not affect existing data.
     */
    @Test
    void whenNoDeleteUserThenUsernameIsPetr() {
        UserStore store = new UserStore();
        store.add(new User("1", "Petr"));
        store.delete("10");
        User result = store.findById("1");
        assertThat(result.getUsername()).isEqualTo("Petr");
    }

    /**
     * Verifies that {@code replace} returns {@code true} on success.
     */
    @Test
    void whenReplaceOkThenTrue() {
        UserStore store = new UserStore();
        store.add(new User("1", "Petr"));
        boolean result = store.replace("1", new User("1", "Maxim"));
        assertThat(result).isTrue();
    }

    /**
     * Verifies that {@code replace} returns {@code false} when ID is not found.
     */
    @Test
    void whenReplaceNotOkThenFalse() {
        UserStore store = new UserStore();
        store.add(new User("1", "Petr"));
        boolean result = store.replace("10", new User("10", "Maxim"));
        assertThat(result).isFalse();
    }
}
