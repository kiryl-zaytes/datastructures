package problems.time;


import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by kiryl_zayets on 2/15/19.
 */
public class LeastInterval {

    public int leastInterval(char[] tasks, int n) {

        int[] storage = new int[26];

        for(int i=0; i< tasks.length; i++) storage[tasks[i] - 'A']++;

        PriorityQueue<Integer> pq = new PriorityQueue<>(26, Collections.reverseOrder());

        for(int c: storage) if (c > 0) pq.add(c);

        int count = 0;

        while (!pq.isEmpty()){

            int gap = n;

            ArrayList<Integer> tmp = new ArrayList<>();
            while (!pq.isEmpty() && gap >= 0){
                if (pq.peek() > 0) tmp.add(pq.poll()-1);
                else pq.poll();
                count++;
                gap--;
            }

            for(Integer in : tmp) pq.add(in);

        }
        return count;
    }

}
