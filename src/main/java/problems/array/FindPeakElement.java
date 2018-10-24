package problems.array;

/**
 * Transform to find local maximum. Compare two adjacent elements and move
 * recursion
 * towards that element.
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }


    private int helper(int[] nums, int l, int h) {
        if (l == h) return l;
        int m = l + (h - l) / 2;

        if (nums[m] > nums[m + 1]) return helper(nums, l, m);
        else return helper(nums, m + 1, h);
    }


    public int findPeakk(int l, int h, int[] nums) {

        if (l == h) return l;

        int m = l + (h - l) / 2;

        if (nums[m] > nums[m + 1]) return findPeakk(l, m, nums);
        else return findPeakk(m + 1, h, nums);


    }


    public static void main(String[] args) {

        FindPeakElement findPeakElement = new FindPeakElement();
        System.out.print(findPeakElement.findPeakElement(new int[]{1, 2, 1,
                3, 5, 6, 4}));
    }

}
