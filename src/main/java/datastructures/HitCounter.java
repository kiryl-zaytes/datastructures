package datastructures;

/**
 * Created by kiryl_zayets on 1/10/19.
 */
public class HitCounter {

    int N = 300;
    int[] counter;
    int[] time;

    /** Initialize your data structure here. */
    public HitCounter() {
        counter = new int[N];
        time = new int[N];
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {

        int index = timestamp % N;
        if (timestamp == time[index]){
            counter[index]++;
        }
        else counter[index] = 1;
        time[index] = timestamp;
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {

        int total = 0;
        for(int i=0; i < counter.length; i++) {
            if (timestamp - time[i] < 300) total+=counter[i];
        }
        return total;
    }

    public static void main(String[] args){
        HitCounter hc= new HitCounter();
        HitCounter counter = new HitCounter();

// hit at timestamp 1.
        counter.hit(1);

// hit at timestamp 2.
        counter.hit(2);

// hit at timestamp 3.
        counter.hit(3);

// get hits at timestamp 4, should return 3.
        System.out.println(counter.getHits(4));

// hit at timestamp 300.
        counter.hit(300);

// get hits at timestamp 300, should return 4.
        System.out.println(counter.getHits(300));

// get hits at timestamp 301, should return 3.
        System.out.println(counter.getHits(301));
    }

}
