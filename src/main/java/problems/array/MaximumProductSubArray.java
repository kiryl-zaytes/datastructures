package problems.array;

/**
 * Created by kiryl_zayets on 11/12/18.
 */
public class MaximumProductSubArray {


    int product = 1;
    int maxSeen = Integer.MIN_VALUE;

    public int maxProduct(int[] nums) {

        for (int i=0; i < nums.length; i++){
            maxSeen = Math.max(product*=nums[i], maxSeen);
            if (nums[i] == 0) product = 1;
        }
        product = 1;

        for (int i = nums.length-1; i >=0; i--){
            maxSeen = Math.max(product*nums[i], maxSeen);
            if (nums[i] == 0) product = 1;
        }
        return maxSeen;
    }


    public static void main(String[] args){
        MaximumProductSubArray mps = new MaximumProductSubArray();

        System.out.print(mps.maxProduct(new int[]{2, 3, -2, 4}));
    }


}
