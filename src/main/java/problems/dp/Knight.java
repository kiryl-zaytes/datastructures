package problems.dp;

/**
 * Created by kiryl_zayets on 3/1/19.
 */
public class Knight {

    int border = 0;
    int[][] moves = new int[][]{{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2},
            {2, 1}, {2, -1}, {1, -2}};

    public double knightProbability(int N, int K, int r, int c) {
        border = N;

        double[][][] dp = new double[N][N][K];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j][0] = 1;
            }
        }

        for (int k = 1; k <= K; k++) {
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp.length; j++) {
                    double prob = 0.0;
                    for (int[] m : moves) {
                        int dx = i + m[0];
                        int dy = j + m[1];

                        if (correct(dx, dy)) {
                            prob += dp[dx][dy][k - 1];
                        }
                    }
                    dp[i][j][k] = prob / 8.0;
                }
            }
        }
        return dp[r][c][K];
    }

    private boolean correct(int x, int y) {
        if (x >=0  && x < border && y >= 0 && y < border) return true;
        return false;
    }

}
