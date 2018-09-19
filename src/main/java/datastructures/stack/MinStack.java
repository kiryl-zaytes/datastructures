package datastructures.stack;


/**
 * Created by kiryl_zayets on 9/18/18.
 */
public class MinStack {

    class Node {
        Node(Integer val) {
            this.val = val;
        }

        Node next;
        Integer val;
    }

    Node head;
    int mm = Integer.MAX_VALUE;

    public void push(Integer val) {
        if (val < mm) {
            Node temp = new Node(mm);
            temp.next = head;
            head = temp;
            mm = val;
        }
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
    }


    public void pop() {
        if (head == null) return;
        Node tmp = head;

        if (head.val == mm) {
            mm = head.next.val;
            head = head.next.next;
            tmp.next.next = null;
            tmp.next = null;
        } else {
            head = head.next;
            tmp.next = null;
        }
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return mm;
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        System.out.println(minStack.getMin());
        minStack.pop();
//        minStack.push(0);
//        minStack.push(-3);
//        System.out.println(minStack.getMin());
//        minStack.pop();
//        System.out.print(minStack.top().val);
//        System.out.println(minStack.getMin());
//        minStack.pop();
    }


}
