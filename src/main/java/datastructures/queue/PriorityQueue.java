package datastructures.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * PQ could be Max and Min.
 * When inserting new node insert at the end and swim it up while it is no
 * longer less than parent.
 * When deleteMax - get root element, swap last and root and make new root
 * sink until it greater then
 * both child. Compare child to each other to find greatest and than compare
 * root to greatest.
 * In both cases change k (index) twice as low or high depending or swim or
 * sink procedure.
 */

public class PriorityQueue<T extends Comparable<T>> {

    ArrayList<T> binaryHeap;
    int N = 0;

    public PriorityQueue() {
        binaryHeap = new ArrayList<>();
    }

    public PriorityQueue(List<T> list) {
        list.add(list.get(0));
        list.remove(0);
        bottomUp(list);
        this.N = list.size();
        this.binaryHeap = (ArrayList<T>) list;
    }

    public boolean isEmpty() {
        return (N == 0);
    }


    public void bottomUp(List<T> list) {
        int k = list.size();
        for (k = k / 2; k > 0; k--) {
            sink(k);
        }
    }


    public void insert(T val) {
        if (isEmpty()) N++;
        binaryHeap.add(++N, val);
        swim(N);
    }

    public T delMax() {
        if (isEmpty()) return null;
        T max = binaryHeap.get(1);
        swap(1, N--);
        sink(1);
        binaryHeap.add(N + 1, null);
        return max;
    }

    public void swim(int k) {
        while (k / 2 > 1) {
            if (less(k, k / 2)) swap(k, k / 2);
            k = k / 2;
        }
    }

    public void sink(int k) {

        while (k * 2 <= N) {
            int j = 2 * k;
            if (k < N && less(j, j + 1))
                j++; // get max of two as main properrty of heap to be
            // greater or less of both elements
            if (!less(k, j)) break;
            swap(k, j);
            k = j;
        }

    }

    private boolean less(int i, int j) {
        return (binaryHeap.get(i).compareTo(binaryHeap.get(j)) < 0);
    }

    private void swap(int i, int j) {
        T b = binaryHeap.get(i);
        binaryHeap.add(i, binaryHeap.get(j));
        binaryHeap.add(j, b);
    }

}
