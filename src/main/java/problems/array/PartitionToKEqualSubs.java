package problems.array;

import java.util.Arrays;

/**
 * Created by kiryl_zayets on 12/17/18.
 */
public class PartitionToKEqualSubs {

    public boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) return false;
        int target = sum / k;
        Arrays.sort(nums);
        int j = nums.length - 1;
        if (nums[j] > target) return false;
        while (target == nums[j]) {
            j--;
            k--;
        }

        return search(new int[k], j, nums, target);
    }


    private boolean search(int[] groups, int row, int[] nums, int target) {
        if (row < 0) return true;

        int val = nums[row--];

        for (int i = 0; i < groups.length; i++) {

            if (groups[i] + val <= target){
                groups[i]+=val;
                if (search(groups, row, nums, target)) return true;
                groups[i]-=val;
            }
        }
        return false;
    }
}
