package com.standalone.restapi.patterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class Iterator<E> {

    List<E> list = new ArrayList<>();
    int size = 0;

    Iterate<E> iterate() {
        return new IterateImpl();
    }

    void add(E data) {
        size++;
        list.add(data);
    }

    private class IterateImpl implements Iterate<E> {

        int pos = 0;

        public boolean hasNext() {
            return pos != size;
        }

        public E next() {
            var data = list.get(pos);
            pos++;
            return (E) data;
        }
    }

    public static void main(String[] args) {
        var iterator = new Iterator<Integer>();
        iterator.add(1);
        iterator.add(2);
        var iterate = iterator.iterate();
        while (iterate.hasNext()) {
            System.out.println(iterate.next());
        }
    }

}

interface Iterate<E> {
    boolean hasNext();

    E next();
}
