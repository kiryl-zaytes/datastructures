package problems.array;

/**
 * Created by kiryl_zayets on 12/15/18.
 */
public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;

        int up = 1;
        int down = 1;

        for(int i=1; i<nums.length; i++){
            if (nums[i] > nums[i-1]) up = down + 1;
            else if (nums[i] < nums[i-1]) down = up +1;
        }

        return Math.max(up, down);
    }
}
