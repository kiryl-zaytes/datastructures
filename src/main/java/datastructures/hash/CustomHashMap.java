package datastructures.hash;

/**
 * Created by zayetsk on 6/7/17.
 */
public class CustomHashMap<K, V> {

    private double loadFactor = 0.75;
    private int capacity = 0;
    private int treshhold = 0;
    private int bucketOccupied = 0;

    private Node<K, V>[] bucket;

    class Node<K, V> {
        K key;
        V value;
        int h;
        Node next = null;

        public Node(K key, V value, int h) {
            this.key = key;
            this.value = value;
            this.h = h;
        }
    }

    public CustomHashMap() {
        capacity = 5;
        treshhold = (int) (loadFactor * capacity);
        bucket = new Node[capacity];

    }

    public CustomHashMap(int capacity) {
        this.capacity = capacity;
        treshhold = (int) (loadFactor * capacity);
        bucket = new Node[capacity];
    }

    public void put(K key, V value) {
        if (bucketOccupied > treshhold) {
            capacity = capacity * 2;
            treshhold = (int) (loadFactor * capacity);
            Node[] newBucket = new Node[capacity];
            for (int i = 0; i < bucket.length; i++) {
                newBucket[indexOf(bucket[i].h, capacity)] = bucket[i];
            }
            bucket = newBucket;
            newBucket = null;
        }
        int h = getHash(key);

        int bucketNum = indexOf(capacity, h);

        if (bucket[bucketNum] == null) {
            bucket[bucketNum] = new Node<>(key, value, h);
            bucketOccupied++;
        } else {
            Node oldFirst = bucket[bucketNum];
            Node first = new Node<>(key, value, h);

            while (oldFirst != null) {
                if ((h == oldFirst.h) && (key.equals(oldFirst.key))) return;
                oldFirst = oldFirst.next;
            }

            Node old = bucket[bucketNum];
            bucket[bucketNum] = first;
            first.next = old;
        }
    }

    public Node<K, V> get(K key) {
        int h = getHash(key);
        int basket = indexOf(capacity, h);
        if (bucket[basket] == null) return null;
        Node head = bucket[basket];
        while (head != null) {
            if ((h == head.h) && (key.equals(head.key))) return head;
            head = head.next;
        }
        return null;
    }

    public void find(K key) {
        Node n = get(key);
        if (n != null) System.out.print("\nyes");
        else System.out.print("\nno");
    }


    public void check(int i) {
        if (bucket[i] == null) System.out.print("\n");
        else {
            Node head = bucket[i];
            System.out.print("\n");
            while (head != null) {
                System.out.print(head.key + " ");
                head = head.next;
            }
        }
    }

    public void del(K key) {
        int h = getHash(key);
        int basket = indexOf(capacity, h);
        if (bucket[basket] == null) return;
        Node head = bucket[basket];
        Node prev = bucket[basket];

        while (head != null) {
            if ((h == head.h) && (key.equals(head.key))) {
                if (prev == head) {
                    bucket[basket] = bucket[basket].next;
                    head.next = null;
                    head = null;
                } else {
                    prev.next = head.next;
                    head = null;
                    break;
                }

            }
            prev = head;
            if (head != null) head = head.next;
        }
    }

    private int getHash(K key) {
        String sample = key.toString();
        long h = 0;
        for (int i = sample.length() - 1; i >= 0; i--) {
            h = (h * 263 + sample.charAt(i)) % 1000000007;
        }
        return (int) h;
    }

    // should be power of 2 h & (length -1 )
    private int indexOf(int length, int h) {
        return h % length;
    }


    public static void main(String args[]) {
        CustomHashMap<String, String> map = new CustomHashMap<>();

        map.put("world", "");
        map.put("HellO", "");
        map.check(4);
        map.find("World");
        map.find("world");
        map.del("world");
        map.check(4);
        map.del("HellO");
        map.put("luck", "");
        map.put("GooD", "");
        map.check(2);
        map.del("good");


//        map.check(0);
//        map.find("help");
//        map.put("help", "");
//        map.put("del", "");
//        map.put("add", "");
//        map.find("add");
//        map.find("del");
//        map.del("del");
//        map.find("del");
//        map.check(0);
//        map.check(1);
//        map.check(2);
    }


}
