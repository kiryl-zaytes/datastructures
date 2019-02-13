package problems.dp;

/**
 * Created by kiryl_zayets on 2/8/19.
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {

        int[] dp = new int[s.length()];

        int max = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2) ? dp[i - 2] + 2 : 2;
                } else {
                    if (dp[i - dp[i - 1] - 1] == '(' && (i - dp[i - 1] - 1 >= 0))
                        dp[i] = 2 + dp[i - 1] + ((i - dp[i - 1] - 2 >= 0)?(dp[i - dp[i - 1 - 2]]):0);
                }
                max = Math.max(dp[i], max);
            }
        }

        return max;
    }

}
