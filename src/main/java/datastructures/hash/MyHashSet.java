package datastructures.hash;

import java.util.LinkedList;

/**
 * Created by kiryl_zayets on 11/10/18.
 */
public class MyHashSet {

    int bucket = 1000;
    LinkedList[] storage;

    public MyHashSet() {
        storage = new LinkedList[bucket];
    }

    public void add(int key) {
        int b = hash(key);
        if (storage[b] != null) {
            boolean sean = false;
            for (Object x : storage[b]) {
                if (x.equals(key)) {
                    sean = true;
                    break;
                }
            }
            if (!sean) storage[b].add(key);
        } else {
            storage[b] = new LinkedList<Integer>();
            storage[b].add(key);
        }
    }

    public void remove(int key) {
        int b = hash(key);
        LinkedList<Integer> tmp = storage[b];
        if (tmp != null) tmp.remove((Object)key);
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int b = hash(key);
        LinkedList<Integer> tmp = storage[b];

        if (tmp != null) return tmp.contains(key);
        return false;
    }

    private int hash(int k) {
        return k % bucket;
    }


    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.contains(1);    // returns true
        hashSet.contains(3);    // returns false (not found)
        hashSet.add(2);
        hashSet.contains(2);    // returns true
        hashSet.remove(2);
        hashSet.contains(2);    // returns false (already removed)
    }


}
