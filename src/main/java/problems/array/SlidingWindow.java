package problems.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * use dequeue
 */
public class SlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 0) return new int[0];

        Deque<Integer> deque = new LinkedList<>();

        int[] res = new int[nums.length - k + 1];
        int r = 0;

        for (int i = 0; i < nums.length; i++) {

            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offer(i);

            if (i >= k - 1) res[r++] = nums[deque.peek()];
        }

        return res;
    }


    public static void main(String[] args) {
        SlidingWindow slidingWindow = new SlidingWindow();
        slidingWindow.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
    }

}
