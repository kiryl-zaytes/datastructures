package problems.array;

/**
 * Created by kiryl_zayets on 10/3/18.
 */
public class SearchForRange {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};

        int point = helper(nums, 0, nums.length - 1, target);

        if (point == -1) return new int[]{-1, -1};

        int start = -1;
        int end = -1;
        int process = point;


        while (process != -1) {
            process = helper(nums, 0, process - 1, target);
            if (process != -1) start = process;
        }

        process = 0;

        while (process != -1) {
            process = helper(nums, process + 1, nums.length - 1, target);
            if (process != -1) end = process;
        }

        start = (start == -1 ? point : start);
        end = (end == -1 ? point : end);

        return new int[]{start, end};


    }

    private int helper(int[] nums, int l, int h, int target) {
        if (l > h) return -1;


        int m = l + (h - l) / 2;

        if (nums[m] < target) return helper(nums, m + 1, h, target);
        else if (nums[m] > target) return helper(nums, l, m - 1, target);
        else return m;

    }


    public static void main(String[] args) {
        SearchForRange searchForRange = new SearchForRange();
        searchForRange.searchRange(new int[]{2,2}, 2);
    }


}
