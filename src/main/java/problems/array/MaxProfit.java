package problems.array;

/**
 * Raising event: buy at low sell at high and buy again if next day price higher tht at previous.
 */
public class MaxProfit {

    public static int maxProfit(int[] prices) {
        int total = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i+1] > prices[i]) total+=prices[i+1] - prices[i];
        }

        return total;
    }


    public static void main(String[] args){
        int res = MaxProfit.maxProfit(new int[]{7,1,5,3,6,4});

        System.out.println(res);
    }
}
