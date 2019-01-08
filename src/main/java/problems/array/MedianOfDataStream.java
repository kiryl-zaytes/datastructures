package problems.array;


import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by kiryl_zayets on 1/4/19.
 */
public class MedianOfDataStream {

    PriorityQueue<Integer> lower;
    PriorityQueue<Integer> higher;

    /**
     * initialize your data structure here.
     */
    public MedianOfDataStream() {
        higher = new PriorityQueue<>();
        lower = new PriorityQueue<Integer>(Collections.reverseOrder());
    }

    public void addNum(int num) {

        if (lower.isEmpty() || num <= lower.peek()) lower.add(num);
        else higher.add(num);

        if (higher.size() - lower.size() >=2) lower.add(higher.remove());
        else if (lower.size() - higher.size() >=2) higher.add(lower.remove());

    }

    public double findMedian() {
        if (higher.size() == lower.size()) return (higher.peek() + lower.peek())/2.0;
        else if (higher.size() > lower.size()) return higher.peek();
        else return lower.peek();
    }


}
