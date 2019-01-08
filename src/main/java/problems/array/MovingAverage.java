package problems.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kiryl_zayets on 1/8/19.
 */
public class MovingAverage {


    Queue<Integer> queue;
    int size = 0;
    int sum = 0;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() == size) sum -= queue.poll();
        sum+=val;
        queue.offer(val);
        return (double) sum / queue.size();
    }


    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage(5);
        System.out.println(ma.next(12009));

        System.out.println(ma.next(1965));

        System.out.println(ma.next(-940));
        System.out.println(ma.next(-8516));
        System.out.println(ma.next(-16446));

        System.out.println(ma.next(7870));
        System.out.println(ma.next(25545));

        System.out.println(ma.next(-21028));
        System.out.println(ma.next(18430));
        System.out.println(ma.next(-23464));
    }

    // [null,12009.0,6987.0,4344.66667,1129.5,-2385.6,-3213.4,1502.6,-2515.0,
    // 2874.2,1470.6]

}