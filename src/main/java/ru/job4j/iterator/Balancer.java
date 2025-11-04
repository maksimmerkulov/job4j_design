package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Distributes data from an iterator across multiple lists evenly.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
public class Balancer {

    /**
     * Splits elements from the source iterator into the provided nodes.
     *
     * <p>Distribution follows a round-robin pattern: the first element
     * goes to the first list, the second to the second, and so on.
     *
     * @param nodes  list of lists to store the distributed elements
     * @param source source of elements to distribute
     */
    public static void split(List<ArrayList<Integer>> nodes,
                             Iterator<Integer> source) {
        int index = 0;
        while (source.hasNext()) {
            nodes.get(index++).add(source.next());
            if (index >= nodes.size()) {
                index = 0;
            }
        }
    }
}
