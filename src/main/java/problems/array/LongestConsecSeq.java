package problems.array;

import java.util.HashSet;

/**
 * Created by kiryl_zayets on 10/10/18.
 */
public class LongestConsecSeq {


    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        int greatestSeq = 0;

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (Integer i : set) {
            int start = i;
            if (!set.contains(i - 1)) {
                int val = i + 1;

                while (set.contains(val)) {
                    val++;

                }
                if (val - start > greatestSeq) greatestSeq = val - start;

            }
        }

        return greatestSeq;
    }


    public static void main(String[] args) {
        LongestConsecSeq longestConsecSeq = new LongestConsecSeq();
        System.out.print(longestConsecSeq.longestConsecutive(new int[]{100,
                4, 200, 1,
                3, 2, 5, 6, 7, 8, 9, 20}));
    }


}
