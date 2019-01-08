package problems.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kiryl_zayets on 12/15/18.
 */
public class LongestHarmoniousSubs {


    public int findLHS1(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        int prevCount = 1;

        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            if (i > 0 && nums[i] - nums[i - 1] == 1) {
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    count++;
                    i++;
                }
                max = Math.max(count + prevCount, max);
                prevCount = count;
            } else {
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                    count++;
                }
                prevCount = count;
            }
        }
        return max;
    }

    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> storage = new HashMap<>();

        for (int i = 0; i < nums.length; i++) storage.put(nums[i], storage.getOrDefault(nums[i], 0) + 1);
        int res = 0;
        for(Map.Entry<Integer, Integer> k: storage.entrySet()){
            int key = k.getKey();
            if (storage.containsKey(key+1)) {
                res = Math.max(res, storage.get(key+1) + k.getValue());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestHarmoniousSubs lhs = new LongestHarmoniousSubs();
        System.out.print(lhs.findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));

    }


}
