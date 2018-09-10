package problems.array;

import java.util.HashMap;

/**
 * Created by kiryl_zayets on 9/7/18.
 */
public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        if (nums.length < 2) return false;
        HashMap<Integer, Integer> dups = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (dups.containsKey((nums[i]))) return true;
            else dups.put(nums[i], 1);
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.print(ContainsDuplicate.containsDuplicate(new int[]{1, 1,
                1, 3, 3, 4, 3, 2, 4, 2}));

    }


}
