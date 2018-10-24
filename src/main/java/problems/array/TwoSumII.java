package problems.array;

/**
 * Created by kiryl_zayets on 10/23/18.
 */
public class TwoSumII {


    public int[] twoSum(int[] numbers, int target) {

        int[] res = new int[2];

        for (int i = 0; i < numbers.length; i++) {

            int foundEl = helper(i+1,
                    numbers.length - 1, numbers, target - numbers[i]);

            if (foundEl > 0) {
                res[0] = i+1;
                res[1] = foundEl+1;
            }
        }

        return res;
    }


    private int helper(int l, int h, int[] num, int target) {
        if (l > h) return -1;
        int m = l + (h - l) / 2;
        if (num[m] == target) return m;
        else if (target < num[m]) return helper(l, m - 1, num, target);
        else return helper(m + 1, h, num, target);
    }


    public static void main(String[] args) {

        TwoSumII twoSumII = new TwoSumII();

        twoSumII.twoSum(new int[]{2,7,11,15}, 18);
    }


}
