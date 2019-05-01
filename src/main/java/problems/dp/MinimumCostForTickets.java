package problems.dp;

import java.util.HashSet;

/**
 * Created by kiryl_zayets on 3/1/19.
 */
public class MinimumCostForTickets {


    public int mincostTickets1(int[] days, int[] costs) {
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

    public int mincostTickets(int[] ds, int[] costs) {
        int[] dp = new int[366];
        HashSet<Integer> days = new HashSet<>();

        for(int d: ds) days.add(d);


        for(int i=1; i<366; i++){
            if (!days.contains(i)) dp[i] = dp[i-1];
            else {

                dp[i] = Math.min(dp[Math.max(0, i-7)] + costs[1], Math.min(dp[Math.max(0, i - 30)] + costs[2], dp[i-1] + costs[0]));

//                if (i >= 30) dp[i] = Math.min(dp[i-30] + costs[2], Math.min(dp[i-7] + costs[1], dp[i-1] + costs[0]));
//                else if (i >= 7) dp[i] = Math.min(dp[i-7] + costs[1], dp[i-1] + costs[0]);
//                else dp[i] = Math.min(dp[0] + Math.min(costs[1], costs[2]), dp[i-1] + costs[0]);
            }
        }

        return dp[365];


    }

    public static void main(String[] args) {
        MinimumCostForTickets mtc = new MinimumCostForTickets();
        System.out.print(mtc.mincostTickets(new int[]{1, 4, 6,7,8,20}, new int[]{7, 2, 15}));
    }
}
