package datastructures;

import java.util.Iterator;

/**
 * Stack implementation with open boundaries
 * PA:
 * a. Java historical way to create array of type T
 * b.[N++] store then ++
 * c. [--N] first -- then get object
 */
public class _Stack<T> implements Iterable<T> {
    private T[] storage;
    private int N = 0;


    public _Stack(int size) {
        storage = (T[]) new Object[size];
    }

    public void push(T item) {
        if (N == storage.length) resize(storage.length * 2);
        storage[N++] = item;
    }

    public T pop() {
        T item = storage[--N];
        storage[N] = null;
        if (N == storage.length / 4) resize(storage.length / 2);
        return item;
    }

    private void resize(int size) {
        T[] copy = (T[]) new Object[size];

        for (int i = 0; i < N; i++) {
            copy[i] = storage[i];
        }
        storage = copy;
    }


    public static void main(String[] args) {
        _Stack<String> x = new _Stack<String>(10);
        x.push("1");
        x.pop();
    }

    public Iterator<T> iterator() {
        return new ReversedIterator();
    }

    private class ReversedIterator implements Iterator<T>{
        int i = N;
        public boolean hasNext() {
            return i > 0;
        }

        public T next() {
            return storage[--i];
        }
    }
}
