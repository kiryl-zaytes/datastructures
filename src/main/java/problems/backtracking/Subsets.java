package problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiryl_zayets on 10/2/18.
 */
public class Subsets {

    ArrayList<List<Integer>> re = new ArrayList<List<Integer>>();
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        enumerate(nums, 0, new ArrayList(), re);
        return re;
    }

    private void enumerate(int[] nums,
            int k,
            ArrayList tmp,
            ArrayList<List<Integer>> res) {

        res.add(new ArrayList<>(tmp));

        for (int i = k; i < nums.length; i++) {
            tmp.add(nums[i]);
            enumerate(nums, i+1, tmp, res);
            tmp.remove(tmp.size() -1 );
        }


    }


    public static void main(String[] args) {
        Subsets s = new Subsets();
        s.subsets(new int[]{1, 2, 3});
    }

}
