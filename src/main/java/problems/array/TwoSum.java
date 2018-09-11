package problems.array;

import java.util.HashMap;

/**
 * Created by kiryl_zayets on 9/10/18.
 */
public class TwoSum {


    public static int[] twoSum(int[] sample, int target) {
        if (sample.length < 2) return new int[]{};

        HashMap<Integer, Integer> storage = new HashMap();

        for (int i = 0; i < sample.length; i++) {

            if (storage.containsKey(target - sample[i])) {
                return new int[]{storage.get(target - sample[i]), i};
            } else storage.put(sample[i], i);
        }

        return new int[]{};
    }


    public static void main(String[] args) {
        int[] r = TwoSum.twoSum(new int[]{3, 6, 11, 1}, 9);
        System.out.print(String.valueOf(r[0]) + String.valueOf(r[1]));
    }

}
