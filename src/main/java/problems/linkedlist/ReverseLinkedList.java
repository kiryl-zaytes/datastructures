package problems.linkedlist;

import java.util.Stack;

/**
 * Created by kiryl_zayets on 9/12/18.
 */
public class ReverseLinkedList {

    public static class ListNode<T> {
        T val;
        ListNode next;

        ListNode(T x) { val = x; }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        Stack<ListNode> stack = new Stack();
        stack.push(head);
        while (head.next != null) {
            stack.push(head.next);
            head = head.next;
        }
        ListNode start = stack.pop();
        head = start;
        while (!stack.empty()) {
            start.next = stack.pop();
            start = start.next;
        }
        start.next = null;
        return head;
    }


    public static ListNode reverseRec(ListNode node){
        if (node == null) return null;
        if (node.next == null) return node;
        ListNode n2 = node.next;
        ListNode n1 = reverseRec(n2);
        n2.next = node;
        node.next = null;
        return n1;
    }


    public static ListNode reverse(ListNode root){
        if (root.next == null) return root;
        ListNode n = root.next;
        ListNode head = reverse(n);
        n.next = root;
        root.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode N = new ListNode<Integer>(1);
        N.next = new ListNode<Integer>(2);
        N.next.next = new ListNode<Integer>(3);
        N.next.next.next = new ListNode<Integer>(4);
        N.next.next.next.next = new ListNode<Integer>(5);
        ListNode n = ReverseLinkedList.reverse(N);
        System.out.print("");
    }
}
