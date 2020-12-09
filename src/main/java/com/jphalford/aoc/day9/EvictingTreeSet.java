package com.jphalford.aoc.day9;

import java.util.LinkedList;
import java.util.TreeSet;
import java.util.stream.Stream;

public class EvictingTreeSet<E> {
    private final int maxEntries;
    private final TreeSet<E> treeSet;
    private final LinkedList<E> filoList;

    public EvictingTreeSet(int maxEntries) {
        this.maxEntries = maxEntries;
        this.treeSet = new TreeSet<>();
        this.filoList = new LinkedList<>();
    }

    public int size() {
        return treeSet.size();
    }

    public void add(E element) {
        removeLast();
        treeSet.add(element);
        filoList.add(element);
    }

    public Stream<E> stream() {
        return treeSet.stream();
    }

    private void removeLast() {
        if (maxEntries == size()) {
            E lastElement = filoList.removeFirst();
            treeSet.remove(lastElement);
        }
    }

    public boolean contains(E element) {
        return treeSet.contains(element);
    }
}
