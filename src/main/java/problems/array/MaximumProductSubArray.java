package problems.array;

/**
 * Created by kiryl_zayets on 11/12/18.
 */
public class MaximumProductSubArray {


    int product = 1;
    int maxSeen = Integer.MIN_VALUE;

    public int maxProduct(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            maxSeen = Math.max(product *= nums[i], maxSeen);
            if (nums[i] == 0) product = 1;
        }
        product = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            maxSeen = Math.max(product * nums[i], maxSeen);
            if (nums[i] == 0) product = 1;
        }
        return maxSeen;
    }

    public int maxProduct1(int[] nums) {

        int[] min = new int[nums.length];
        int[] max = new int[nums.length];


        max[0] = nums[0];
        min[0] = nums[0];

        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(max[i - 1] * nums[i], Math.max(
                    min[i - 1] * nums[i], nums[i]));
            min[i] = Math.min(max[i - 1] * nums[i], Math.min(
                    min[i - 1] * nums[i], nums[i]));
            res = Math.max(res, max[i]);
        }

        return res;

    }

    public static void main(String[] args) {
        MaximumProductSubArray mps = new MaximumProductSubArray();

        System.out.print(mps.maxProduct(new int[]{2, 3, -2, 4}));
    }


}
