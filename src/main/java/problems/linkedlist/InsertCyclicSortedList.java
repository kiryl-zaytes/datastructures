package problems.linkedlist;

/**
 * Created by kiryl_zayets on 2/22/19.
 */
public class InsertCyclicSortedList {

    static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val,Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {

        if (head == null){
            head = new Node(insertVal, null);
            head.next = head;
            return head;
        }

        Node breakPoint = head;

        while (breakPoint.next != breakPoint &&
                breakPoint.next.val >= breakPoint.val)
            breakPoint = breakPoint.next;


        if (breakPoint.val <= insertVal || breakPoint.next.val >= insertVal) {
            breakPoint.next = new Node(insertVal, breakPoint.next);
        }
        else {
            while (breakPoint.next.val < insertVal) breakPoint = breakPoint.next;
            breakPoint.next = new Node(insertVal, breakPoint.next);;
        }

        return head;
    }


    public static void main(String[] args){


        Node head = new Node(1, null);
        Node n0 = new Node(2, null);
//        Node n1 = new Node(4, null);
        Node n2 = new Node(3, null);

        head.next = n0;
//        n1.next = n2;
        n0.next = n2;
        n2.next = head;

        InsertCyclicSortedList ins = new InsertCyclicSortedList();

        ins.insert(head, 0);
    }

}
