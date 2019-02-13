package problems.dp;

import java.util.Arrays;

/**
 * Created by kiryl_zayets on 2/11/19.
 */
public class NumOfLis {

    public int findNumberOfLIS(int[] nums) {

        int[] count = new int[nums.length];
        int[] len = new int[nums.length];

        Arrays.fill(count, 1);
        int max = 0;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (len[i] <= len[j]) {
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    } else if (len[j] + 1 == len[i]) {
                        count[i] = count[i] + count[j];
                    }
                }
            }
        }

        for (int l : len) max = Math.max(l, max);
        for (int i = 0; i < len.length; i++) if (len[i] == max) ans += count[i];
        return ans;
    }
}

