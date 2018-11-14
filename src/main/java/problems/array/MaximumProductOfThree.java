package problems.array;

import java.util.Arrays;

/**
 * Created by kiryl_zayets on 11/12/18.
 */
public class MaximumProductOfThree {


    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        return Math.max(nums[0] * nums[1] * nums[nums.length - 1],
                nums[nums.length - 3] * nums[nums.length - 2] *
                        nums[nums.length - 1]);
    }


    public static void main(String[] args) {
        MaximumProductOfThree mp3 = new MaximumProductOfThree();
        System.out.print(mp3.maximumProduct(new int[]{1, 2, 3,4}));
    }


}
