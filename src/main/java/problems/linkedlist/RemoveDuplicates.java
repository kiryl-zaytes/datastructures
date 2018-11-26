package problems.linkedlist;

/**
 * Created by kiryl_zayets on 11/22/18.
 */
public class RemoveDuplicates {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            fast = fast.next;
            while (fast != null && slow.val == fast.val) fast = fast.next;
            slow.next = fast;
            slow = fast;
        }
        return head;
    }


    public static void main(String[] args) {
        RemoveDuplicates rm = new RemoveDuplicates();
        ListNode N = new ListNode(1);
        N.next = new ListNode(2);
        N.next.next = new ListNode(2);
        N.next.next.next = new ListNode(2);
        N.next.next.next.next = new ListNode(2);
        N.next.next.next.next.next = new ListNode(2);
//        N.next.next.next.next.next.next = new ListNode(6);

        rm.deleteDuplicates(N);
    }

}
