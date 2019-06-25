package problems.linkedlist;

/**
 * Created by kiryl_zayets on 5/2/19.
 */
public class ReverseKGroup {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        if (k < 2) return head;

        int nodes = 1;
        ListNode root = head;
        ListNode lastSeen = null;

        while (head.next != null) {
            head = head.next;
            nodes++;
            if (nodes % k == 0) lastSeen = head;
        }
        if (nodes < k) return root;

        ListNode newHead = root;

        int i = 1;
        while (i++ != k) newHead = newHead.next;

        ListNode tail = null;

        if (nodes % k != 0) tail = lastSeen.next;
        lastSeen.next = null;

        head = root;
        int delta = 0;
        ListNode current = root;
        ListNode last = null;

        while (root != null) {
            delta++;
            if (delta == k) {
                delta = 0;

                ListNode tmp = root.next;
                root.next = current.next;

                current.next.next = current;
                current.next = tmp;

                current = root.next;
            }
            if (root.next == null) last = root;
            root = root.next;
        }

        last.next = tail;

        return newHead;
    }

    public static void main(String[] args){
        ReverseKGroup rvk = new ReverseKGroup();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        rvk.reverseKGroup(head, 2);
    }

}
