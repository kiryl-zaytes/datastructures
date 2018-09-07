package problems.array;

import java.util.Arrays;

/**
 * Created by kiryl_zayets on 9/6/18.
 */
public class MaxArea {

    static class Pair implements Comparable<Pair> {

        private final int index;
        private final Integer value;

        Pair(int index, Integer value) {
            this.index = index;
            this.value = value;
        }

        public int compareTo(Pair o) {
            return Integer.valueOf(this.value).compareTo(o.value);
        }
    }


    public static int maxArea1(int[] height) {

        int l = 0;
        int r = height.length-1;
        int res = 0;
        while (l < r){

            res = Math.max(res, Math.min(height[l], height[r]) * (r-l));
            if (height[l] < height[r]) l++;
            else r--;
        }
        return res;
    }

    public static int maxArea(int[] height) {
        if (height.length < 2) return 0;
        if (height.length == 2) {
            Arrays.sort(height);
            return height[0];
        }

        int minSide = 0;
        int maxPos = height.length;
        int minPos = 1;
        int greatestSeen1 = 1;
        int greatestSeen2 = 1;
        Pair bar1 = null;
        Pair bar2 = null;

        Pair[] arr = new Pair[height.length];


        for (int i = 0; i < height.length; i++) {
            arr[i] = new Pair(i+1, height[i]);
        }

        Arrays.sort(arr);

        for (int j = 0; j < arr.length; j++) {
            Integer indexSide1 = arr[j].index;
            Integer valueSide2 = arr[j].value;



            if ((indexSide1 - minPos) * valueSide2 > greatestSeen1){
                greatestSeen1 = (indexSide1 - minPos) * valueSide2;
                bar1 = arr[j];
            }

            if((Math.abs(indexSide1 - maxPos)) * valueSide2 > greatestSeen2){
                if (bar1 != arr[j]){
                    greatestSeen2 = (Math.abs(indexSide1 - maxPos)) * valueSide2;
                    bar2 = arr[j];
                }
            }
        }
        if (bar1.value >= bar2.value) minSide = bar2.value;
        else minSide = bar1.value;
        return Math.abs(bar1.index - bar2.index) * minSide;
    }


    public static void main(String[] args) {
        int res = MaxArea.maxArea1(new int[]{6,4,3,1,4,6,99,62,1,2,6}); //1.2.1
        System.out.print(res);
    }
}
