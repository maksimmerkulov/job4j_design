package ru.job4j.collection;

/**
 * Demonstrates a simple loop and arithmetic summation.
 *
 * <p>Example output:
 * <pre>{@code
 * sum = 105
 * }</pre>
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
public class Loop {

    /**
     * Entry point of the program.
     *
     * @param args command-line arguments; not used
     */
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 15; i++) {
            sum += i;
        }
        System.out.println("sum = " + sum);
    }
}
