package problems.linkedlist;

/**
 * Created by kiryl_zayets on 9/13/18.
 */
public class HasCycle {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        ListNode N = new ListNode(1);
        N.next = new ListNode(4);
        N.next.next = new ListNode(2);
        N.next.next.next = new ListNode(2);
        N.next.next.next.next = new ListNode(4);
//        N.next.next.next.next.next = N;
        System.out.print(HasCycle.hasCycle(N));
    }
}
