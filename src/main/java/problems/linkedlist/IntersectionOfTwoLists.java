package problems.linkedlist;

/**
 * Created by kiryl_zayets on 9/21/18.
 */
public class IntersectionOfTwoLists {


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        if (headA.equals(headB)) return headA;
        ListNode na = headA;
        ListNode nb = headB;

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
            if (headA == null) headA = nb;
            if (headB == null) headB = na;
        }
        return headA;
    }


    public static void main(String[] args) {
        ListNode N = new ListNode(1);
        N.next = new ListNode(3);
        N.next.next = new ListNode(5);
        N.next.next.next = new ListNode(6);
        N.next.next.next.next = new ListNode(7);


        ListNode M = new ListNode(2);
//        M.next = N;

        M.next = new ListNode(4);
        M.next.next = N.next.next.next;
        M.next.next.next = new ListNode(55);
        System.out.print(IntersectionOfTwoLists.getIntersectionNode(N, M).val);

    }


}
