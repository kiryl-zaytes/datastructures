package problems.linkedlist;

/**
 * Created by kiryl_zayets on 9/12/18.
 */
public class DeleteNode {

    static class Node<T> {
        Node<T> next;
        T value;

        public Node(T value) {
            this.value = value;
        }

    }


    public static void deleteNode(Node node) {
        if (node == null) return;
        if (node.next != null) {
            node.value = node.next.value;
            node.next = node.next.next;
        }
    }


    public static void main(String[] args) {
        DeleteNode.Node N = new DeleteNode.Node<String>("2");
        N.next = new Node<String>("0");
        N.next.next = new Node<String>("1");
        N.next.next.next = new Node<String>("3");
        DeleteNode.deleteNode(N.next.next );

    }

}