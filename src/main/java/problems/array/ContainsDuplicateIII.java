package problems.array;

import java.util.TreeSet;

/**
 * Created by kiryl_zayets on 11/9/18.
 */
public class ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        TreeSet<Long> tree = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            Long floor = tree.floor((long)nums[i] + t);
            Long ceil = tree.ceiling((long)nums[i] - t);

            if ((floor != null && nums[i] <= floor)
                    || (ceil != null && nums[i] >= ceil)) return true;

            tree.add((long)nums[i]);
            if (i >= k) tree.remove((long)nums[i - k]);
        }
        return false;


    }

    public static void main(String[] args){
        ContainsDuplicateIII c = new ContainsDuplicateIII();
        c.containsNearbyAlmostDuplicate(new int[]{-2147483648,-2147483647},3,3);
    }

}
