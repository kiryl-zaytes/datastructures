package problems.linkedlist;

/**
 * Created by kiryl_zayets on 9/12/18.
 */
public class MergeTwoLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode res = new ListNode(0);
        ListNode h = res;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                while (l2 != null) {
                    res.next = l2;
                    res = res.next;
                    l2 = l2.next;
                }
                break;
            } else if (l2 == null) {
                while (l1 != null) {
                    res.next = l1;
                    res = res.next;
                    l1 = l1.next;
                }
                break;
            }

            if (l2.val < l1.val) {
                res.next = l2;
                res = res.next;
                l2 = l2.next;
            } else if (l1.val <= l2.val) {
                res.next = l1;
                res = res.next;
                l1 = l1.next;
            }
        }
        ListNode x = h;
        h = h.next;
        x.next = null;
        return h;
    }


    public static void main(String[] args) {
        ListNode N = new ListNode(-9);
        N.next = new ListNode(3);
        N.next.next = new ListNode(10);
        N.next.next.next = new ListNode(20);

        ListNode M = new ListNode(5);
        M.next = new ListNode(7);
        M.next.next = new ListNode(6);
        M.next.next.next = new ListNode(8);


        MergeTwoLists.mergeTwoLists(N, M);
    }

}
//1 3 4 4 6 8 10 20