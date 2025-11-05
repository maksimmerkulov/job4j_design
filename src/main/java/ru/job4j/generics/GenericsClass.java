package ru.job4j.generics;

/**
 * Represents a generic pair consisting of a key and a value.
 *
 * <p>Example output:
 * <pre>{@code
 * Console output: GenericsClass{key=First key, value=First value}
 * Console output: GenericsClass{key=12345, value=Second value}
 * }</pre>
 *
 * @param <K> the type of the key
 * @param <V> the type of the value
 * @author Maksim Merkulov
 * @version 1.0
 */
public class GenericsClass<K, V> {

    /**
     * The key of the pair.
     */
    private K key;

    /**
     * The value of the pair.
     */
    private V value;

    /**
     * Creates a new {@code GenericsClass} with the specified key and value.
     *
     * @param key   the key
     * @param value the value
     */
    public GenericsClass(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Returns a string representation of the key-value pair.
     *
     * @return a string representation
     */
    @Override
    public String toString() {
        return "GenericsClass{"
                + "key=" + key
                + ", value=" + value
                + '}';
    }

    /**
     * Entry point of the program.
     *
     * @param args command-line arguments; not used
     */
    public static void main(String[] args) {
        GenericsClass<String, String> first =
                new GenericsClass<>("First key", "First value");
        System.out.println("Console output: " + first);
        GenericsClass<Integer, String> second =
                new GenericsClass<>(12345, "Second value");
        System.out.println("Console output: " + second);
    }
}
