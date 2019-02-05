package problems.dp;

/**
 * Created by kiryl_zayets on 9/18/18.
 */
public class MaxSubArray {


//    public static int maxSubArray(int[] nums) {
//
//
//    }

    public static int maxSAy(int[] nums, int l, int h, int max) {

        if (l >= h) return Integer.MIN_VALUE;

        int m = l + (h - l) / 2;

        int left = maxSAy(nums, l, m, max);
        int right = maxSAy(nums, m + 1, h, max);

        if (left == Integer.MIN_VALUE) left = nums[l];
        if (right == Integer.MIN_VALUE) right = nums[h];

        if (left + right < max) return left + right;
        else return max;
    }

    public static int maxSubArray1(int[] n) {
        if (n.length == 0) return 0;
        int max = n[0];
        int currentMax = n[0];

        for (int i = 1; i < n.length; i++) {

            currentMax = Math.max(n[i], n[i] + currentMax);
            max = Math.max(currentMax, max);
        }
        return max;
    }


    public static  int maxSubArray(int[] n){

        int max = n[0];

        int great = n[0];

        for(int i=1; i<n.length;i++){
            max = Math.max(n[i], n[i]+max);
            great = Math.max(great, max);
        }

        return great;

    }


    public static void main(String[] args) {
        System.out.print(MaxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1,
                2, 1,
                -5, 4}));
    }

}
