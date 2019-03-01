package problems.dp;

import java.util.HashSet;

/**
 * Created by kiryl_zayets on 3/1/19.
 */
public class MinimumCostForTickets {


    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[30];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < days.length; i++) set.add(days[i]);

        int s = days[0];
        int e = days[days.length - 1];

        for (int i = s; i <= e; i++) {
            if (!set.contains(i)) dp[i % 30] = dp[(i - 1) % 30];
            else {
                dp[i % 30] = Math.min(Math.min(
                        dp[(i - 1) % 30] + costs[0],
                        dp[Math.max(0, i - 7) % 30] + costs[1]),
                        dp[Math.max(i - 30, 0) % 30] + costs[2]);
            }
        }
        return dp[e % 30];
    }


    public static void main(String[] args) {
        MinimumCostForTickets mtc = new MinimumCostForTickets();
        System.out.print(mtc.mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8,
                9, 10, 30, 31}, new int[]{2, 7, 15}));
    }
}
