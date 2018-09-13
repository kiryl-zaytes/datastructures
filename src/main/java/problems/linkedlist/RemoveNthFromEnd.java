package problems.linkedlist;

/**
 * Created by kiryl_zayets on 9/12/18.
 */
public class RemoveNthFromEnd {

    static class ListNode<T> {
        ListNode<T> next;
        T value;

        public ListNode(T value) {
            this.value = value;
        }

    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode N = new ListNode<String>("1");
        N.next = new ListNode<String>("2");
//        N.next.next = new Node<String>("1");
//        N.next.next.next = new Node<String>("3");
//        N.next.next.next.next = new Node<String>("4");
        RemoveNthFromEnd.removeNthFromEnd(N, 1);

    }

}
