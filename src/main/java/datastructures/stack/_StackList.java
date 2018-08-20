package datastructures.stack;

import java.util.Iterator;

/**
 * Custom Stack implementation based on LinkedList
 */
public class _StackList<T> implements Iterable<T> {

    class Node<T> {
        Node next = null;
        T value;

        public String toString(){
            return value.toString();
        }
    }

    private Node<T> head = null;
    private int N = 0;

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(T item) {
        if (head == null) {
            head = new Node<T>();
            head.value = item;
            return;
        }

        Node n = new Node();
        n.value = item;
        n.next = head;
        head = n;
        N++;
    }


    public T pop() {
        T val = head.value;
        head = head.next;
        N--;
        return val;
    }

    public Iterator<T> iterator() {
        return new DirectIterator();
    }

    class DirectIterator implements Iterator<T> {
        int i = 0;
        Node<T> h = head;
        Node<T> t = null;

        public boolean hasNext() {
            return i <= N;
        }

        public T next() {
            if (hasNext()){
                t = h;
                h = h.next;
            }
            i++;
            return (T) t;
        }
    }

    public static void main(String[] arg) {
        _StackList<String> stackList = new _StackList<String>();
        stackList.push("1");
        stackList.push("2");
        stackList.push("3");
        stackList.pop();
        stackList.pop();
    }

}
