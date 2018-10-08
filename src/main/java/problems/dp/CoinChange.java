package problems.dp;

import java.util.Arrays;

/**
 * Top down recursive solution.
 * Use memo to store best prev solution. Run recursion from top to bottom,
 * at each step assess all provided denominations and choose least amount to build up
 * the sum. Store this value and go to next up.
 */
public class CoinChange {


    public int coinChange(int[] coins, int target) {
        if (target < 1) return 0;
        Arrays.sort(coins);
        int[] memo = new int[target + 1];
        int res =  helper(coins, target, memo);
        return res;
    }


    private int helper(int[] coins, int remainder, int[] memo) {

        if (remainder < 0) return -1;
        if (remainder == 0) return 0;
        if (memo[remainder] != 0) return memo[remainder];
        int min = Integer.MAX_VALUE;
        for(int c : coins){
            int res = helper(coins, remainder - c, memo);
            if (res >= 0 && res < min) min = res + 1;
        }
        if (min == Integer.MAX_VALUE) return memo[remainder] =-1;
        else memo[remainder] = min;
        return memo[remainder];
    }


    public static void main(String[] args){
        CoinChange coinChange = new CoinChange();
        System.out.print(coinChange.coinChange(new int[]{186,419,83,408}, 6249));
    }

}
