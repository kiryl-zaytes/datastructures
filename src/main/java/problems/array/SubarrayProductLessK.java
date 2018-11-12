package problems.array;

/**
 * Created by kiryl_zayets on 11/12/18.
 */
public class SubarrayProductLessK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k==0) return 0;
        int product = 1;
        int count = 0;

        for (int i = 0, j = 0; j < nums.length; j++) {
            product *= nums[j];
            while (i <= j && product >= k) product /= nums[i++];
            count += j - i + 1;
        }
        return count;
    }


}
