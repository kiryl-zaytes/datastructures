package problems.array;

import java.util.Arrays;

/**
 * Created by kiryl_zayets on 12/10/18.
 */
public class ThreeSumClosest {

    int current = Integer.MAX_VALUE;
    int closest = Integer.MIN_VALUE;

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int h = nums.length - 1;

            while (l < h) {
                int s = nums[i] + nums[l] + nums[h];
                if (Math.abs(s - target) < current) {
                    current = Math.abs(s - target);
                    closest = s;
                }

             //   current = Math.max(s - target, current);
                if (s == target) return target;
                else if (s < target) l++;
                else if (s > target) h--;
            }
        }
        return closest;

    }


    public static void main(String[] args) {

        ThreeSumClosest ts = new ThreeSumClosest();
        System.out.print(ts.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }


}
