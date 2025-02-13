package aula09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class CollectionTester {
    public static void main(String[] args) {
        int[] dims = { 1000, 5000, 10000, 20000, 40000, 100000 };
        Collection<Collection<Integer>> collections = new ArrayList<>();
        Collection<Integer> col1 = new ArrayList<>();
        Collection<Integer> col2 = new LinkedList<>();
        Collection<Integer> col3 = new HashSet<>();
        Collection<Integer> col4 = new TreeSet<>();
        collections.add(col1);
        collections.add(col2);
        collections.add(col3);
        collections.add(col4);

        for (Collection<Integer> i : collections) {
            for (int j : dims) {
                checkPerformance(i, j);
            }
        }
    }

    private static void checkPerformance(Collection<Integer> col, int DIM) {
        double start, stop, delta;
        // Add
        System.out.printf("Collection");
        start = System.nanoTime(); // clock snapshot before
        for (int i = 0; i < DIM; i++)
            col.add(i);
        stop = System.nanoTime(); // clock snapshot after
        delta = (stop - start) / 1e6; // convert to milliseconds
        System.out.println();
        // Search
        start = System.nanoTime(); // clock snapshot before
        for (int i = 0; i < DIM; i++) {
            int n = (int) (Math.random() * DIM);
            if (!col.contains(n))
                System.out.println("Not found???" + n);
        }
        stop = System.nanoTime(); // clock snapshot after
        delta = (stop - start) / 1e6; // convert nanoseconds to milliseconds
        System.out.println();
        // Remove
        start = System.nanoTime(); // clock snapshot before
        Iterator<Integer> iterator = col.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        stop = System.nanoTime(); // clock snapshot after
        delta = (stop - start) / 1e6; // convert nanoseconds to milliseconds
        System.out.println();
    }
}
