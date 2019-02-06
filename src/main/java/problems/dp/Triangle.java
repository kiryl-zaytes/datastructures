package problems.dp;

import java.util.List;

/**
 * Created by kiryl_zayets on 2/6/19.
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        int[] dp = new int[triangle.size()+1];

        int levels = triangle.size();

        for (int i=levels-1; i >=0; i--){

            for(int j=0; j<triangle.get(i).size(); j++){

                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }

        }
        return dp[0];
    }
}
