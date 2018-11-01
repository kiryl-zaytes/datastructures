package problems.array;

/**
 * 1. Find max val and sum of all vals in array. Those would be range for
 * binary search.
 */
public class SplitArrayLargestSum {

    int max = 0;
    int greatest = 0;

    public int splitArray(int[] nums, int m) {



        for (int i = 0; i < nums.length; i++) {
            max += nums[i];
            greatest = Math.max(nums[i], greatest);
        }

        if (m ==1) return max;

        while (greatest < max) {
            int mid = greatest + (max - greatest) / 2;

            if (isSplitable(mid, m, nums)) max = mid;
            else greatest = mid+1;

        }

        return greatest;

    }

    private boolean isSplitable(int target, int m, int[] nums) {
        int sum = 0;
        int partitions = 1;

        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] <= target) {
                sum += nums[i];
            } else {
                sum = nums[i];
                partitions++;
            }
        }
        if (partitions > m) return false;
        return true;
    }


    public static void main(String[] args) {
        SplitArrayLargestSum spla = new SplitArrayLargestSum();

        System.out.print(spla.splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    }

}
