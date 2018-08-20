package problems;

/**
 * Created by kiryl_zayets on 8/20/18.
 */
public class DestructivelyReverseLinkedList {

    static class Node<T> {
        public Node(T value) {
            this.value = value;
        }

        Node next = null;
        T value;
    }

    public static void main(String[] args) {
        Node<String> s = new Node<String>("1");
        s.next = new Node<String>("2");
        s.next.next = new Node<String>("3");
        s.next.next.next = new Node<String>("4");
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
}
