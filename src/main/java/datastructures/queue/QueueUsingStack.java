package datastructures.queue;

import java.util.Stack;

/**
 * Created by kiryl_zayets on 11/26/18.
 */
public class QueueUsingStack {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    Integer top = null;

    /**
     * Initialize your data structure here.
     */
    public QueueUsingStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (stack1.empty()) top = x;
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (stack2.empty()) while (!stack1.empty()) stack2.push(stack1.pop());
        return stack2.pop();
    }


    /**
     * Get the front element.
     */
    public int peek() {
        if (!stack2.empty()) return stack2.peek();
        return top;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return  (stack1.empty() && stack2.empty());
    }

    public static void main(String[] args) {
        QueueUsingStack suq = new QueueUsingStack();

        suq.push(1);
        suq.push(2);
        suq.push(3);
//        suq.push(2);
//        suq.top();   // returns 2
        System.out.print(suq.pop());   // returns 2
        System.out.print(suq.pop());   // returns 2
        System.out.print(suq.pop());   // returns 2
        suq.empty(); // returns false

    }

}
