package ru.job4j.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Demonstrates the application of generic wildcards in collection processing.
 *
 * <p>Example output for {@link #printResult(Collection)}:
 * <pre>{@code
 * Current element: 1
 * Current element: 2
 * ...
 * Current element: 5
 * }</pre>
 *
 * <p>Example output for {@link #printInfo(Collection)}:
 * <pre>{@code
 * Person{name='name', age=21, birthday=Tue Dec 15 15:00:00 YEKT 1998}
 * Person{name='name123', age=23, birthday=Tue Dec 15 15:00:00 YEKT 1998}
 * }</pre>
 *
 * <p>Example output for {@link #addAll(List)}:
 * <pre>{@code
 * Current element: 1
 * Current element: 2
 * ...
 * Current element: 5
 * }</pre>
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
public class GenericUsage {

    /**
     * Prints all elements of a collection using an unbounded wildcard.
     *
     * @param collection source collection
     */
    public void printResult(Collection<?> collection) {
        for (Iterator<?> iterator = collection.iterator();
             iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println("Current element: " + next);
        }
    }

    /**
     * Prints info about people using an upper bounded wildcard.
     *
     * @param collection collection of {@link Person} or its subclasses
     */
    public void printInfo(Collection<? extends Person> collection) {
        for (Iterator<? extends Person> iterator = collection.iterator();
             iterator.hasNext();) {
            Person next = iterator.next();
            System.out.println(next);
        }
    }

    /**
     * Adds integers to a list using a lower bounded wildcard.
     *
     * @param list list that can accept {@link Integer}
     */
    public void addAll(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        for (Object line : list) {
            System.out.println("Current element: " + line);
        }
    }

    /**
     * Entry point of the program.
     *
     * @param args command-line arguments; not used
     */
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        new GenericUsage().printResult(list);
        System.out.println();
        List<Person> per = List.of(
                new Person("name", 21, new Date(913716000000L))
        );
        new GenericUsage().printInfo(per);
        List<Programmer> pro = List.of(
                new Programmer("name123", 23,
                        new Date(913716000000L))
        );
        new GenericUsage().printInfo(pro);
        System.out.println();
        List<? super Integer> list2 = new ArrayList<>();
        new GenericUsage().addAll(list2);
    }
}
