package problems.linkedlist;

/**
 * Created by kiryl_zayets on 9/13/18.
 */
public class IsPalindrome {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }


    public static ListNode reverse(ListNode h) {
        if (h == null) return null;
        if (h.next == null) return h;
        ListNode n = h.next;
        ListNode tail = reverse(n);
        n.next = h;
        h.next = null;
        return tail;
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return true;

        int l = 0;
        int m = 0;
        ListNode midNode = head;
        ListNode h = head;

        while (head != null) {
            head = head.next;
            l++;
        }

        m = l / 2;
        int i = 1;

        while (i++ <= m) midNode = midNode.next;

        midNode = reverse(midNode);

        while (m-- > 0) {
            if (midNode.val != h.val) return false;
            midNode = midNode.next;
            h = h.next;
        }
        return true;

    }


    public static void main(String[] args) {
        ListNode N = new ListNode(1);
        N.next = new ListNode(4);
        N.next.next = new ListNode(2);
        N.next.next.next = new ListNode(2);
        N.next.next.next.next = new ListNode(4);
        N.next.next.next.next.next = new ListNode(1);
        System.out.print(IsPalindrome.isPalindrome(N));
    }

}
