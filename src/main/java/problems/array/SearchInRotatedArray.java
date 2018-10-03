package problems.array;

/**
 * Half of array is always sorted. Since we now start of sorted array and end we can check if
 * value is in range if not move to opposite side and again check fo sorted boundaries.
 */
public class SearchInRotatedArray {

    public int search(int[] nums, int target) {
        return helper(0, nums.length - 1, nums, target);
    }

    public int helper(int l, int h, int[] nums, int target) {

        if (l > h) return -1;
        int m = l + (h - l) / 2;

        if (nums[m] == target) return m;

        if (nums[l] <= nums[m]) {

            if (target >= nums[l] && target < nums[m]) {
                return helper(l, m - 1, nums, target);
            } else {
                return helper(m + 1, h, nums, target);
            }
        } else {
            if (target > nums[m] && target <= nums[h]) {
                return helper(m + 1, h, nums, target);
            } else {
                return helper(l, m - 1, nums, target);
            }
        }
    }


    public static void main(String[] args) {
        SearchInRotatedArray s = new SearchInRotatedArray();
        System.out.print(s.search(new int[]{3,5,1}, 3));
    }

}
