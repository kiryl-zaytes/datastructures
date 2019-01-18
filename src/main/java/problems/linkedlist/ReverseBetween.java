package problems.linkedlist;

import java.util.HashMap;

/**
 * Created by kiryl_zayets on 1/17/19.
 */
public class ReverseBetween {

    static class ListNode<T> {
        ListNode<T> next;
        T value;

        public ListNode(T value) {
            this.value = value;
        }

    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null) return null;
        if (m == n) return head;
        int i = 1;

        ListNode root = head;
        ListNode leftBreak = null;

        while (i < m) {
            leftBreak = head;
            head = head.next;
            i++;
        }

        ListNode prev = null;
        ListNode cur = head;

        while (i <= n){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            i++;
        }

        if (leftBreak != null){
            ListNode x = leftBreak.next;
            leftBreak.next = prev;
            x.next = cur;
        }
        else {
            if (cur !=null) root.next = cur;
            root = prev;
        }

        return root;
    }


    public static void main(String[] args){
        ReverseBetween rb = new ReverseBetween();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        HashMap f = new HashMap();


        rb.reverseBetween(head, 1, 2);
    }

}
