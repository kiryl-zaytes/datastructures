package problems.dp;

/**
 * Created by kiryl_zayets on 9/17/18.
 */
public class ClimbStairs {

    int[] memo;

    public int climbStairs(int n) {
        memo = new int[n + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        return climbStairsRec(n);
    }

    public int climbStairsRec(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (memo[n] != -1) return memo[n];
        int r = climbStairsRec(n - 1);
        r = r + climbStairsRec(n - 2);
        memo[n] = r;
        return r;
    }
    public int minCostClimbingStairs(int[] cost) {

        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i=2; i<cost.length; i++) dp[i] = Math.min(cost[i] + dp[i-1], cost[i] + dp[i-2]);

        return dp[dp.length-1];

    }


    public static void main(String[] args) {
        int j = 3;
//        memo = new int[j + 1];
//        for (int i = 0; i < memo.length; i++) {
//            memo[i] = -1;
//        };

        ClimbStairs climbStairs = new ClimbStairs();
        climbStairs.minCostClimbingStairs(new int[]{0,0,0,1});
        System.out.print(climbStairs.climbStairs(j));

    }

}



