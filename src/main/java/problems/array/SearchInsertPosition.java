package problems.array;

/**
 * Created by kiryl_zayets on 11/22/18.
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;

        return helper(nums, 0, nums.length - 1, target);
    }


    private int helper(int[] nums, int l, int h, int target) {
        if (l > h) return l;

        int m = l + (h - l) / 2;

        if (target < nums[m]) return helper(nums, l, m-1, target);
        else if (target > nums[m]) return helper(nums, m + 1, h, target);
        else return m;

    }


    public static void main(String[] args) {
        SearchInsertPosition sip = new SearchInsertPosition();

        System.out.print(sip.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }

}
