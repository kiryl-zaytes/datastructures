package problems.linkedlist;

/**
 * Created by kiryl_zayets on 10/15/18.
 */
public class MergeKSortedLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 ) return null;
        return partioning(lists, 0, lists.length - 1);
    }


    private ListNode partioning(ListNode[] listNodes, int l, int r) {


        if ( l == r) return listNodes[l];
        else if (l > r) return null;
        //if (l == r) return listNodes[l];

        int m = l + (r - l) / 2;
        ListNode ln1 = partioning(listNodes, l, m);
        ListNode ln2 = partioning(listNodes, m + 1, r);
        return merge(ln1, ln2);
    }


    private ListNode merge(ListNode l1, ListNode l2) {


        ListNode head = new ListNode(0);
        ListNode dumb = head;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }

            head = head.next;
        }

        if (l1 != null) head.next = l1;
        if (l2 != null) head.next = l2;

        return dumb.next;
    }


    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode x = new ListNode(1);
        x.next = new ListNode(2);
        x.next.next = new ListNode(3);
        x.next.next.next = new ListNode(4);

        ListNode x1 = new ListNode(0);
        x1.next = new ListNode(1);
        x1.next.next = new ListNode(5);
        x1.next.next.next = new ListNode(8);


        ListNode x3 = new ListNode(2);
        x3.next = new ListNode(4);
        x3.next.next = new ListNode(5);
        x3.next.next.next = new ListNode(6);


        ListNode res = mergeKSortedLists.mergeKLists(new ListNode[]{
                x, x1, x3
        });
        System.out.print(res.val);
    }

}
