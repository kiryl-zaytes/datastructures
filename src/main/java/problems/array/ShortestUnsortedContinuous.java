package problems.array;

import java.util.Arrays;

/**
 * Created by kiryl_zayets on 12/6/18.
 */
public class ShortestUnsortedContinuous {


    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 0) return 0;
        int[] nums1 = nums.clone();
        Arrays.sort(nums1);
        int l = 0;
        int e = nums.length - 1;

        while (l <= e && (nums[l] == nums1[l] || nums[e] == nums1[e])) {
            if (nums[l] == nums1[l]) l++;
            if (nums[e] == nums1[e]) e--;
        }
        return (e - l > 0) ? nums.length - (l + (nums.length-1 - e)) : 0;
    }

    public static void main(String[] args) {

        ShortestUnsortedContinuous s = new ShortestUnsortedContinuous();
        System.out.print(s.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }
}
