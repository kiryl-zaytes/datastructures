package problems.dp;

/**
 * Created by kiryl_zayets on 2/4/19.
 */
public class CountBits {


    public int[] countBits(int num) {

        int i = 0;
        int b = 1;
        int[] dp = new int[num+1];

        while (b <= num){
            while (i < b && i+b <= num){
                dp[i+b] = dp[i] + 1;
                i++;
            }
            i = 0;
            b = 2*b;
        }
        return dp;

    }

}
