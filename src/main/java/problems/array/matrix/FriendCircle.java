package problems.array.matrix;

import datastructures.queue.PriorityQueue;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by kiryl_zayets on 2/19/19.
 */
public class FriendCircle {

    int [] union;

    public int findCircleNum(int[][] M) {
        this.union = new int[M.length];

        Arrays.fill(this.union, -1);
        for (int i=0; i< M.length; i++) union[i] = 1;

        for(int i=0; i < M.length; i++){

            for(int j=0; j < M[0].length; j++){
                if (M[i][j]!=1 && i==j) continue;
                union(i, j);
            }
        }

        int count = 1;

        for(int i=0; i < this.union.length; i++){
            if (this.union[i] == -1) count++;
        }
        return count;
    }

    private void union(int i, int j){
        while (i != union[i]) i = union[i];
        while (j != union[j]) j = union[j];
        if ( i !=j) union[i] = j;
    }

    PriorityQueue x = new PriorityQueue(new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            return 0;
        }
    });

}
