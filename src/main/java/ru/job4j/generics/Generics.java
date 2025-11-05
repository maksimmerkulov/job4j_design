package ru.job4j.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Demonstrates the usage of different types of wildcards in Generics.
 *
 * <p>Example output:
 * <pre>{@code
 * Current element: Animal
 * Current element: Predator
 * Current element: Tiger
 *
 * Current element: Predator
 * Current element: Tiger
 *
 * Current element: Animal
 * Current element: Predator
 * }</pre>
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
public class Generics {

    /**
     * Prints elements of a list without any type restrictions.
     *
     * @param list source list with any type
     */
    public void printObject(List<?> list) {
        for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println("Current element: " + next);
        }
    }

    /**
     * Prints elements using an upper bounded wildcard for {@link Predator}.
     *
     * @param list collection of {@link Predator} or its subclasses
     */
    public void printBoundedWildCard(List<? extends Predator> list) {
        for (Iterator<? extends Predator> iterator = list.iterator();
             iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println("Current element: " + next);
        }
    }

    /**
     * Prints elements using a lower bounded wildcard for {@link Predator}.
     *
     * @param list list that can accept {@link Predator} or its superclasses
     */
    public void printLowerBoundedWildCard(List<? super Predator> list) {
        for (Iterator<? super Predator> iterator = list.iterator();
             iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println("Current element: " + next);
        }
    }

    /**
     * Entry point of the program.
     *
     * @param args command-line arguments; not used
     */
    public static void main(String[] args) {
        Generics generics = new Generics();
        List<Animal> first = new ArrayList<>();
        List<Predator> second = new ArrayList<>();
        List<Tiger> third = new ArrayList<>();
        first.add(new Animal());
        second.add(new Predator());
        third.add(new Tiger());
        generics.printObject(first);
        generics.printObject(second);
        generics.printObject(third);
        System.out.println();
        /*generics.printBoundedWildCard(first);*/
        generics.printBoundedWildCard(second);
        generics.printBoundedWildCard(third);
        System.out.println();
        generics.printLowerBoundedWildCard(first);
        generics.printLowerBoundedWildCard(second);
        /*generics.printLowerBoundedWildCard(third);*/
    }
}
