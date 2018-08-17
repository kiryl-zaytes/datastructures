package datastructures.linkedlist;

/**
 * Custom LinkedList implementation.
 */
public class _LinkedList<T> {

    class Node<T> {
        private Node next = null;
        private T value;
    }

    Node head;
    Node pointer;

    public _LinkedList() {
        head = new Node();
        pointer = head;
    }


    public void add(T value) {
        pointer.value = value;
        Node n = new Node();
        pointer.next = n;
        pointer = n;
    }

    public void addFirst(T value) {
        Node n = new Node();
        n.value = value;
        n.next = head;
        head = n;
    }

    // Need to have second pointer, leave for now
    public void removeLast(){

    }

    public void removeFirst(){
        Node newHead = head.next;
        head.next = null;
        head = newHead;
    }

    public static void main(String[] args) {
        _LinkedList<String> linkedList = new _LinkedList<String>();
        linkedList.add("privet");
        linkedList.add("poka");
        linkedList.addFirst("first");
        linkedList.removeFirst();
    }
}
