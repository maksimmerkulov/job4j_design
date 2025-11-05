package ru.job4j.generics;

import java.util.Date;

/**
 * Represents a programmer as a specialized type of {@link Person}.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
public class Programmer extends Person {

    /**
     * Creates a new {@code Programmer} with the specified attributes.
     *
     * @param name     the programmer's name
     * @param age      the programmer's age
     * @param birthday the programmer's birthday
     */
    public Programmer(String name, int age, Date birthday) {
        super(name, age, birthday);
    }
}
