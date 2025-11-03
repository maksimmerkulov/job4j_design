package ru.job4j.assertj;

/**
 * Represents a simple model used to demonstrate exception handling in tests.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
public class SimpleModel {

    /**
     * The name of the model.
     */
    private String name = "";

    /**
     * Returns the name of the model.
     *
     * @return the name string
     * @throws IllegalArgumentException if the name length is zero
     */
    public String getName() {
        if (name.length() == 0) {
            throw new IllegalArgumentException();
        }
        return name;
    }

    /**
     * Sets the name of the model with length validation.
     *
     * @param word   the new name
     * @param number the expected length of the word
     * @throws IllegalArgumentException if the word length does
     *                                  not match the number
     */
    public void setName(String word, int number) {
        if (word.length() != number) {
            throw new IllegalArgumentException(
                    String.format(
                            "this word: %s has length not equal to : %s",
                            word,
                            number
                    )
            );
        }
        this.name = word;
    }
}
