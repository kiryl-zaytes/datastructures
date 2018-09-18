package problems.dp;

/**
 * Created by kiryl_zayets on 9/18/18.
 */
public class BestTimeToBuy {

    public static int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int maxProfit = prices[1] - prices[0];
        int minPricetoBuy = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i];
            int potentialProfit = currentPrice - minPricetoBuy;
            maxProfit = Math.max(potentialProfit, maxProfit);
            minPricetoBuy = Math.min(currentPrice, minPricetoBuy);
        }

        return maxProfit < 0 ? 0 : maxProfit;
    }


    public static void main(String[] args) {
        System.out.print(BestTimeToBuy.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

}
