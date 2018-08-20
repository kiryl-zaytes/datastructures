package datastructures.Deque;

/**
 * A double-ended queue or deque (pronounced “deck”) is like a stack or a
 * queue but
 * supports adding and removing items at both ends. A deque stores a collec-
 * tion of items
 */
public class Deque<T> {

    class Node<T> {
        Node prev = null;
        Node next = null;
        T value;

        Node(T item) {
            this.value = item;
        }
    }

    Node<T> head = null;
    Node<T> tail = null;

    int N = 0;

    public Deque() {

    }

    public void pushLeft(T item) {
        if (item == null) throw new NullPointerException();
        Node oldFirst = head;
        head = new Node<T>(item);

        if (isEmpty()) tail = head;
        else {
            head.next = oldFirst;
            head.prev = null;
            oldFirst.prev = head;
        }
        N++;
    }

    public void pushRight(T item) {
        if (item == null) throw new NullPointerException();
        Node<T> oldLast = tail;
        tail = new Node<T>(item);
        if (isEmpty()) head = tail;
        else {
            tail.prev = oldLast;
            tail.next = null;
            oldLast.next = tail;
        }
        N++;
    }

    public T popLeft() {
        if (isEmpty()) return null;
        if (head == tail) {
            T res = head.value;
            head = null;
            tail = null;
            return res;
        }
        T res = head.value;
        head = head.next;
        head.prev = null;
        N--;
        return res;
    }


    public T popRight() {
        if (isEmpty()) return null;
        if (head == tail) {
            T res = head.value;
            tail = null;
            head = null;
            return res;
        }

        T res = tail.value;
        Node<T> tp = tail.prev;
        tail.prev = null;
        tp.next = null;
        tail = tp;
        N--;
        return res;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public static void main(String[] arg) {
        Deque<String> deque = new Deque<String>();
        deque.pushLeft("4");
        deque.pushLeft("3");
        deque.pushLeft("2");
        deque.pushLeft("1");
        deque.popRight();
        deque.popRight();
    }

}
