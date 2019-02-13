package problems.dp;

/**
 * Created by kiryl_zayets on 2/7/19.
 */
public class RegExpMatching {

    public boolean isMatch(String s, String p) {

        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i < dp.length; i++) {

            for (int j = 1; j < dp[0].length; j++) {

                if (s.charAt(i - 1) == p.charAt(j - 1) ||
                        p.charAt(i - 1) == '.') dp[i][j] = dp[i - 1][j - 1];

                else if (p.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (p.charAt(i - 2) == s.charAt(j - 1) ||
                            p.charAt(i - 2) == '.')
                        dp[i][j] = dp[i - 1][j] | dp[i-1][j];


                } else dp[i][j] = false;
            }

        }
        return dp[p.length() + 1][s.length() + 1];
    }

}
