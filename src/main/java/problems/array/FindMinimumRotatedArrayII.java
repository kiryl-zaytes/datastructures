package problems.array;

/**
 * Created by kiryl_zayets on 10/22/18.
 */
public class FindMinimumRotatedArrayII {

    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }


    private int helper(int[] nums, int l, int h) {

        if (l >= h) return nums[l];
        int m = l + (h - l) / 2;
        if (nums[m] > nums[h]) {
            return helper(nums, m+1, h);
        } else if (nums[m] < nums[h]) {
            return helper(nums, l, m);
        } else{
            return helper(nums, l, --h);
        }
    }


    public static void main(String[] args) {

        FindMinimumRotatedArrayII fms = new FindMinimumRotatedArrayII();
//        System.out.print(fms.findMin(new int[]{2, 2, 2, 2, 0}));
//        System.out.print(fms.findMin(new int[]{10, 10, 1, 10, 10,10}));
        System.out.print(fms.findMin(new int[]{3,1}));
//        System.out.print(fms.findMin(new int[]{1,2,5}));


    }


}
