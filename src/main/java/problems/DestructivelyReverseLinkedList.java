package problems;

/**
 * Maintain 3 pointers: next, next.next from first list and current last at
 * second list.
 * When writing code involving linked lists, we must always be careful to
 * properly handle the exceptional cases
 * (when the linked list is empty, when the list has only one or two nodes)
 * and the boundary cases (dealing with the first or last items).
 */
public class DestructivelyReverseLinkedList {

    static class Node<T> {
        public Node(T value) {
            this.value = value;
        }

        Node next = null;
        T value;
    }

    // keep track of first - second (prev/next), to null previous next links.
    public static Node recursive(Node n) {
        if (n == null) return null;
        if (n.next == null) return n;
        Node second = n.next;
        Node n1 = recursive(second);
        second.next = n;
        n.next = null;
        return n1;
    }


    // keep track of 3 links
    public static void iterative(Node s) {
        Node r = null;
        while (s.next != null) {
            if (r == null)
                r = s;
            Node temp = s.next;
            Node s_next = temp.next;
            temp.next = r;
            r = temp;
            s.next = s_next;

        }
    }

    public static void main(String[] args) {
        Node<String> s = new Node<String>("1");
        s.next = new Node<String>("2");
        s.next.next = new Node<String>("3");
        s.next.next.next = new Node<String>("4");
        Node reversed = recursive(s);
    }
}
