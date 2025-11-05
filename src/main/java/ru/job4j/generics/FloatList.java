package ru.job4j.generics;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

/**
 * Represents a specialized list of {@link Float} elements that preserves
 * generic type info.
 *
 * <p>Example output:
 * <pre>{@code
 * java.util.ArrayList<java.lang.Float>
 * class java.lang.Float
 * }</pre>
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
public class FloatList extends ArrayList<Float> {

    /**
     * Entry point of the program.
     *
     * @param args command-line arguments; not used
     */
    public static void main(String[] args) {
        ArrayList<Float> listOfNumbers = new FloatList();
        Class actual = listOfNumbers.getClass();
        ParameterizedType type =
                (ParameterizedType) actual.getGenericSuperclass();
        System.out.println(type);
        Class parameter = (Class) type.getActualTypeArguments()[0];
        System.out.println(parameter);
    }
}
