package problems.array;

/**
 * Created by kiryl_zayets on 12/7/18.
 */
public class MaxAvgSubArray {

    public double findMaxAverage(int[] nums, int k) {

        if (k == 0 || nums.length == 0) return 0;
        int n = nums.length - k;

        int maxSeen = 0;
        int maxCurrent = 0;

        int i = 0;
        while (i < k) {
            maxSeen += nums[i++];
        }
        maxCurrent = maxSeen;

        for (i = 0; i < n; i++) {
            maxCurrent = (maxCurrent + nums[k + i]) - nums[i];
            maxSeen = Math.max(maxCurrent, maxSeen);
        }

        return maxSeen / (double) k;

    }

    public static void main(String[] args) {
        MaxAvgSubArray maxAvg = new MaxAvgSubArray();
        System.out.print(maxAvg.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }


}
