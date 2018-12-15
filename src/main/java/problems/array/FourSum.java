package problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kiryl_zayets on 12/10/18.
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                break;
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) continue;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) continue;
                if (nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2] < target) continue;
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int l = j + 1;
                int h = nums.length - 1;

                while (l < h) {
                    int s = nums[i] + nums[j] + nums[l] + nums[h];
                    if (s == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[h]));
                        while (l < h && nums[l] == nums[l+1]) l++;
                        while (h > l && nums[h] == nums[h-1]) h--;
                        l++;
                        h--;
                    }
                    else if (s < target) l++;
                    else if (s > target) h--;

                }

            }
        }
        return res;
    }

}
