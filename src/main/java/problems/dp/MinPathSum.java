package problems.dp;

/**
 * Created by kiryl_zayets on 2/6/19.
 */
public class MinPathSum {

    public int minPathSum(int[][] grid) {

        int[][] dp = new int[grid.length][grid.length];

        dp[0][0] = grid[0][0];
        for (int i=1; i<dp.length; i++) dp[i][0]  = grid[i-1][0]+grid[i][0];
        for (int i=1; i<dp.length; i++) dp[0][i] = grid[0][i-1] + grid[0][i];


        for(int i=1; i<dp.length; i++){
            for (int j=1; j<dp[0].length; j++){

                int left = dp[i][j-1];
                int up = dp[i-1][j];
                dp[i][j] = grid[i-1][j-1] + Math.min(left, up);

            }

        }

        return dp[dp.length-1][dp.length-1];



    }


    public static void main(String[] args){

        MinPathSum mps = new MinPathSum();
        mps.minPathSum(new int[][]{{1,4,5}, {2,7,6}, {6,8,7}});
    }

}
