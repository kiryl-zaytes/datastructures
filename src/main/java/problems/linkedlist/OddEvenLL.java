package problems.linkedlist;

/**
 * Created by kiryl_zayets on 9/25/18.
 */
public class OddEvenLL {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = head;
        ListNode firstEven = head.next;


        while (head.next != null && head.next.next != null){

            ListNode int1 = head.next;
            head.next = head.next.next;
            int1.next = int1.next.next;
            head = head.next;

        }

        head.next = firstEven;

        return newHead;
    }

    public static void main(String[] args){
        ListNode N = new ListNode(1);
        N.next = new ListNode(2);
//        N.next.next = new ListNode(3);
//        N.next.next.next = new ListNode(5);
//        N.next.next.next.next = new ListNode(6);
//        N.next.next.next.next.next = new ListNode(4);
//        N.next.next.next.next.next.next = new ListNode(7);
        OddEvenLL.oddEvenList(N);
    }


}
