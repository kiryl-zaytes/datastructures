package problems.string;

/**
 * Created by kiryl_zayets on 12/11/18.
 */
public class LongestPalindromicSubseq {

    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        for (int l = 2; l <= s.length(); l++) {
            for (int i = 0; i < s.length() - l + 1; i++) {
                int j = i + l - 1;
                if (l == 2 && s.charAt(i) == s.charAt(j)) dp[i][j] = 2;
                else if (s.charAt(i) == s.charAt(j)) dp[i][j] = 2 + dp[i+1][j-1];
                else dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
            }
        }
        return dp[0][s.length()-1];
    }


}
