package problems.array;

/**
 * Created by kiryl_zayets on 11/12/18.
 */
public class SearchInSortedArrayII {


    public boolean search(int[] nums, int target) {
        return helper(nums, 0, nums.length-1, target);
    }


    private boolean helper(int[] nums, int l, int h, int target){
        if (l > h) return false;

        int m = l + (h - l)/2;

        if (nums[m] == target) return true;

        if (nums[m] > nums[l] || nums[m] > nums[h]){
            if (target >= nums[l] && target <nums[m]){
                return helper(nums, l, m-1, target);
            }
            else return helper(nums, m+1, h, target);
        }

        else if (nums[m]<nums[h] || nums[m] < nums[l]){
            if (target > nums[m] && target <= nums[h]) return helper(nums, m+1, h, target);
            else return helper(nums, l, m-1, target);
        }
        else return helper(nums, l, --h, target);

    }

    public static void main(String[] args){

        SearchInSortedArrayII s = new SearchInSortedArrayII();
        System.out.print(s.search(new int[]{1, 1, 3, 1}, 3));
    }

}
