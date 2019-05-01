package problems.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by kiryl_zayets on 12/12/18.
 */
public class MaximumLengthOfPairChain {

    public int findLongestChain1(int[][] pairs) {

        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int min = Integer.MIN_VALUE;
        int count = 0;

        for (int[] pair : pairs) {
            if (pair[1] > min) {
                count++;
                min = pair[1];
            }
        }
        return count;
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if (a[1] > b[1]) return 1;
                else if (a[1] < b[1]) return -1;
                else return 0;
            }
        });

        int border = Integer.MIN_VALUE;
        int count = 0;

        for(int[] p : pairs){
            if (p[0] > border) {
                count++;
                border = p[1];
            }
        }

        return count;

    }


    public static void main(String[] args) {
        MaximumLengthOfPairChain mlc = new MaximumLengthOfPairChain();
        mlc.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}});
    }


}
