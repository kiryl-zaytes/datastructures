package problems.linkedlist;

/**
 * Created by kiryl_zayets on 10/12/18.
 */
public class SortList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }


    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head, prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
    }


    private ListNode merge(ListNode l1, ListNode l2) {

        ListNode m = new ListNode(0);
        ListNode dummy = m;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                m.next = l1;
                l1 = l1.next;
            } else {
                m.next = l2;
                l2 = l2.next;
            }
            m = m.next;
        }

        if (l1 != null) m.next = l1;

        if (l2 != null) m.next = l2;

        return dummy.next;
    }



    public static void main(String[] args){
        SortList sl = new SortList();
        ListNode x = new ListNode(4);
        x.next = new ListNode(2);
        x.next.next = new ListNode(1);
        x.next.next.next = new ListNode(3);

        sl.sortList(x);
    }
}
