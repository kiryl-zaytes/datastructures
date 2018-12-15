package problems.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kiryl_zayets on 12/12/18.
 */
public class IncreasingSubs {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> backtrack = new LinkedList<>();
        helper(nums, res, backtrack, 0);
        return res;

    }

    private void helper(int[] nums,
            List<List<Integer>> res,
            LinkedList<Integer> backtrack, int index) {

        if (backtrack.size() > 1) res.add(new ArrayList<Integer>(backtrack));

        HashSet temp = new HashSet();
        for (int i = index; i < nums.length; i++) {
            if (temp.contains(nums[i])) continue;
            if (backtrack.size() == 0 || nums[i] >= backtrack.peekLast()) {
                backtrack.addLast(nums[i]);
                temp.add(nums[i]);
                helper(nums, res, backtrack, i + 1);
                backtrack.removeLast();
            }
        }
    }


    public static void main(String[] args) {
        IncreasingSubs is = new IncreasingSubs();
        is.findSubsequences(new int[]{4, 6, 7, 7});
    }

}
