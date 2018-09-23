package problems.array;

import java.util.*;

/**
 * Created by kiryl_zayets on 9/20/18.
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum1(int[] nums) {
        HashMap<Integer, Integer[]> hashNums = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                hashNums.put(nums[i] + nums[j], new Integer[]{i, j});
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (hashNums.containsKey(-nums[i])) {
                Integer[] pos = hashNums.get(-nums[i]);
                ArrayList<Integer> tmp = new ArrayList<>();
                if (pos[0] != i && pos[1] != i) {
                    tmp.add(nums[i]);
                    tmp.add(nums[pos[0]]);
                    tmp.add(nums[pos[1]]);
                    tmp.sort(Comparator.<Integer>naturalOrder());
                    hashSet.add(tmp);
                    res.add(tmp);
                }
            }
        }
        return new ArrayList<>(hashSet);
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            if (i == 0 || (nums[i] != nums[i - 1])) {
                int l = i + 1;
                int h = nums.length - 1;
                int sum = -nums[i];

                while (l < h) {
                    if (nums[l] + nums[h] == sum) {
                        res.add(new ArrayList<>(Arrays.asList
                                (nums[l], nums[h], -sum)));
                        while (l < h && nums[l] == nums[l + 1]) l++;
                        while (l < h && nums[h] == nums[h - 1]) h--;
                        l++;
                        h--;
                    } else if (sum > nums[l] + nums[h]) l++;
                    else h--;
                }
            }
        }

        return res;

    }


    public static void main(String[] args) {
        ThreeSum.threeSum(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4,});
        // ThreeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
