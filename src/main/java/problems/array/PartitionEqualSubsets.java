package problems.array;

import java.util.Arrays;

/**
 * Created by kiryl_zayets on 12/17/18.
 */
public class PartitionEqualSubsets {

    public boolean canPartition(int[] nums) {
        int s = Arrays.stream(nums).sum();
        if (s % 2 > 0) return false;
        int k = 2;
        int target = s / k;
        Arrays.sort(nums);
        int j = nums.length - 1;
        if (nums[j] > target) return false;
        while ( j>=0 && nums[j] == target) {
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


    public static void main(String[] args) {
        PartitionEqualSubsets ps = new PartitionEqualSubsets();
        System.out.print(ps.canPartition(new int[]{1, 1}));
    }
}
