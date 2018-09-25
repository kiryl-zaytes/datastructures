package problems.linkedlist;

/**
 * Created by kiryl_zayets on 9/25/18.
 */
public class AddTwoNums {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;

        int n1 = 0;
        int n2 = 0;
        int res = 0;

        while (l1.next != null) {
            n1 = 10 * (n1 + l1.val);
            l1 = l1.next;
        }
        n1 += l1.val;

        while (l2.next != null) {
            n2 = 10 * (n2 + l2.val);
            l2 = l2.next;
        }
        n2 += l2.val;

        res = n1 + n2;

        ListNode r = new ListNode(0);
        ListNode h = r;

        while (res >= 10) {

            r.next = new ListNode(res % 10);
            r = r.next;
            res = res / 10;

        }

        r.next = new ListNode(res % 10);

        return h.next;
    }


    public static void main(String[] args) {
        ListNode N = new ListNode(1);
        N.next = new ListNode(8);
        //N.next.next = new ListNode(0);

        ListNode M = new ListNode(0);
//        M.next = new ListNode(0);
//        M.next.next = new ListNode(0);

        AddTwoNums.addTwoNumbers(N, M);
    }

}
