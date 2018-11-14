package problems.linkedlist;

/**
 * Created by kiryl_zayets on 11/13/18.
 */
public class RemoveElements {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode root = head;
        ListNode prev = null;

        while (head != null) {

            if (head.val == val) {
                ListNode tmp = head;
                if (root == head) {
                    head = head.next;
                    tmp.next = null;
                    root = head;
                } else {
                    prev.next = head.next;
                    head = head.next;
                    tmp.next = null;
                }
            }
            else {
                prev = head;
                if (head != null) head = head.next;
            }

        }
        return root;
    }

    public static void main(String[] args) {
        RemoveElements re = new RemoveElements();
        ListNode N = new ListNode(6);
        N.next = new ListNode(2);
        N.next.next = new ListNode(6);
        N.next.next.next = new ListNode(6);
        N.next.next.next.next = new ListNode(4);
        N.next.next.next.next.next = new ListNode(5);
        N.next.next.next.next.next.next = new ListNode(6);

        re.removeElements(N, 6);
    }

}
