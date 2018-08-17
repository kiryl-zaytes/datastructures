package datastructures.queue;

/**
 * Custom Queue implementation based on LinkedList
 */
public class _Queue<T> {

    private int N = 0;

    class Node<T> {
        Node next;
        T value;
    }

    Node<T> first = null;
    Node last = null;

    public _Queue() {

    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void enqueue(T value) {
        Node n = new Node();
        n.value = value;
        if (isEmpty()) {
            first = n;
            last = n;
        } else {
            last.next = n;
            last = n;
        }
        N++;

    }

    public T dequeue() {
        T value = null;
        if (N > 0) {
            value = first.value;
            first = first.next;
        }
        N--;
        if (isEmpty()) last = null;
        return value;
    }


    public static void main(String[] arg) {
        _Queue<String> queue = new _Queue<String>();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }

}
