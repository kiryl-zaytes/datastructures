package problems.time;


import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by kiryl_zayets on 2/15/19.
 */
public class LeastInterval {

    public int leastInterval1(char[] tasks, int n) {

        int[] storage = new int[26];

        for(int i=0; i< tasks.length; i++) storage[tasks[i] - 'A']++;

        PriorityQueue<Integer> pq = new PriorityQueue<>(26, Collections.reverseOrder());

        for(int c: storage) if (c > 0) pq.add(c);

        int count = 0;

        while (!pq.isEmpty()){
            int gap = 0;
            ArrayList<Integer> tmp = new ArrayList<>();

            while (gap <= n){
                if (!pq.isEmpty()){
                    if (pq.peek() > 1) tmp.add(pq.poll()-1);
                    else pq.poll();
                }
                count++;
                if (pq.isEmpty() && tmp.size() == 0) break;
                gap++;
            }

            for(Integer in : tmp) pq.add(in);

        }
        return count;
    }


    public int leastInterval(char[] tasks, int n) {

        int[] chars = new int[26];

        for(char c : tasks) chars[c - 'A']++;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int nn : chars) if (nn > 0) pq.offer(nn);

        int res = 0;

        while(!pq.isEmpty()){
            int delta = 0;
            ArrayList<Integer> tmp = new ArrayList<>();

            while (delta <= n){

                if (!pq.isEmpty()){
                    if (pq.peek() > 1) tmp.add(pq.poll()-1);
                    else pq.poll();
                }
                res++;
                delta++;
            }

            for(int i:tmp) pq.offer(i);
        }

        return res;
    }


    public static void main(String[] args){
        LeastInterval li = new LeastInterval();
        li.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
    }

}
