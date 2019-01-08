package problems.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kiryl_zayets on 1/2/19.
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, res, tmp, 0, 0);
        return res;
    }

    private void helper(int[] candidates, int target, ArrayList<List<Integer>> res, ArrayList<Integer> tmp,  int sum, int pos){
        if (sum == target) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        else if (sum > target) return;
        else {
            for(int i=pos; i < candidates.length; i++){
                tmp.add(candidates[i]);
                helper(candidates, target, res, tmp, sum + candidates[i], i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }


    public static void main(String[] args){
        CombinationSum cs = new CombinationSum();
        cs.combinationSum(new int[]{2,3,6,7}, 7);
    }

}