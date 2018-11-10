package datastructures.hash;

/**
 * Created by kiryl_zayets on 11/10/18.
 */
public class MyHashMap {

    class Node<K, V> {

        K key;
        V value;
        Node<K, V> next = null;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    Node<Integer, Integer>[] storage;

    int bucket = 2;

    public MyHashMap() {
        storage = new Node[bucket];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int b = hash(key);
        Node n = storage[b];

        if (n != null) {
            boolean seen = false;

            while (n != null) {
                if (key == (int) n.key) {
                    seen = true;
                    n.key = key;
                    n.value = value;
                    break;
                }
                n = n.next;
            }

            if (!seen) {
                Node t =new Node<>(key, value);
                t.next = storage[b];
                storage[b] = t;
            }
        } else storage[b] = new Node<>(key, value);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this
     * map contains no mapping for the key
     */
    public int get(int key) {
        int b = hash(key);
        Node n = storage[b];

        if (n != null) {
            while (n != null) {
                if (key == (int) n.key) return (int) n.value;
                n = n.next;
            }
        }

        return -1;


    }

    /**
     * Removes the mapping of the specified value key if this map contains a
     * mapping for the key
     */
    public void remove(int key) {
        int b = hash(key);
        Node n = storage[b];
        Node prev = storage[b];

        if (n != null) {
            while (n != null) {
                if ((int) n.key == key && (int) prev.key == key) {
                    storage[b] = storage[b].next;
                    n.next = null;
                    n = null;
                    return;
                } else if ((int) n.key == key) {
                    prev.next = n.next;
                    n.next = null;
                    return;
                }

                prev = n;
                n = n.next;
            }
        }
    }

    private int hash(int k) {
        return k % bucket;
    }


    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.put(3, 2);
        hashMap.put(4, 2);
        hashMap.put(5, 2);
        hashMap.get(1);            // returns 1
        hashMap.get(3);            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        hashMap.get(2);            // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        hashMap.remove(1);          // remove the mapping for 2
        hashMap.get(2);            // returns -1 (not found) .
    }


}
