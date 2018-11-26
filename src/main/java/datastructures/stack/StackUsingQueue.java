package datastructures.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kiryl_zayets on 11/24/18.
 */
public class StackUsingQueue {

    private Queue realQueue;
    private Queue reverseQueue;

    Integer top;

    /** Initialize your data structure here. */
    public StackUsingQueue() {
        realQueue = new LinkedList<>();
        reverseQueue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        top = x;
        if (realQueue.isEmpty()) push(x, reverseQueue);
        else push(x, realQueue);
    }

    private void push(int x, Queue q){
        q.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (realQueue.isEmpty()) return pop(realQueue, reverseQueue);
        else return pop(reverseQueue, realQueue);
    }

    private int pop(Queue empty, Queue not){
        int N = not.size();
        if (N == 1) {
            top = null;
            return (int) not.poll();
        }
        while (N>2) {
            empty.add(not.poll());
            N--;
        }
        top = (Integer) not.poll();
        empty.add(top);
        return (int) not.poll();
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (realQueue.isEmpty() && reverseQueue.isEmpty()) return true;
        return false;
    }

    public static void main(String[] args){
        StackUsingQueue suq = new StackUsingQueue();

        suq.push(1);
        suq.push(2);
        suq.push(3);
//        suq.push(2);
//        suq.top();   // returns 2
        suq.pop();   // returns 2
        suq.pop();   // returns 2
        suq.pop();   // returns 2
        suq.empty(); // returns false

    }

}
