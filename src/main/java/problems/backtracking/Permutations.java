package problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiryl_zayets on 9/29/18.
 */
public class Permutations {

//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        // Arrays.sort(nums); // not necessary
//        backtrack(list, new ArrayList<>(), nums);
//        return list;
//    }
//
//    private void backtrack(List<List<Integer>> list, List<Integer>
// tempList, int [] nums){
//        if(tempList.size() == nums.length){
//            list.add(new ArrayList<>(tempList));
//        } else{
//            for(int i = 0; i < nums.length; i++){
//                if(tempList.contains(nums[i])) continue; // element already
// exists, skip
//                tempList.add(nums[i]);
//                backtrack(list, tempList, nums);
//                tempList.remove(tempList.size() - 1);
//            }
//        }
//    }


    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(nums, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums,
            List<List<Integer>> res,
            ArrayList<Integer> tmp) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<Integer>(tmp));
        }

        else {

            for (int j = 0; j < nums.length; j++) {
                if (tmp.contains(nums[j])) continue;
                tmp.add(nums[j]);
                backtrack(nums, res, tmp);
                tmp.remove(tmp.size() - 1);
            }

        }

    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        permutations.permute(new int[]{1, 2, 3});
    }

}
