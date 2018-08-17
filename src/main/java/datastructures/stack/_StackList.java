package datastructures.stack;

/**
 * Custom Stack implementation based on LinkedList
 */
public class _StackList<T> {

    class Node<T> {
        Node next = null;
        T value;
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

    public static void main(String[] arg) {
        _StackList<String> stackList = new _StackList<String>();
        stackList.push("1");
        stackList.push("2");
        stackList.push("3");
        stackList.pop();
        stackList.pop();
    }

}
