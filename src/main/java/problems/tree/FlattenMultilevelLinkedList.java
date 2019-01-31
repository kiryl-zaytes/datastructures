package problems.tree;

import java.util.Stack;

/**
 * Created by kiryl_zayets on 1/31/19.
 */
public class FlattenMultilevelLinkedList {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }


    public Node flatten(Node head) {
        if (head == null) return head;

        Stack<Node> stack = new Stack<>();
        Node prev = null;
        stack.push(head);

        while (!stack.isEmpty()){

            Node cur = stack.pop();

            if (prev != null){
                prev.next = cur;
                cur.prev = prev;
                prev.child = null;
            }

            if (cur.next != null) stack.push(cur.next);
            if (cur.child != null) stack.push(cur.child);
            prev = cur;
        }
        return head;

    }


}
