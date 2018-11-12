package problems.array;

import java.util.HashMap;

/**
 * Created by kiryl_zayets on 11/12/18.
 */
public class SubArraySumK {

    public int subarraySum(int[] nums, int k) {

        int curSum = 0;
        HashMap<Integer, Integer> storage = new HashMap<>();

        storage.put(0, 1);
        int count = 0;
        for (int i=0; i < nums.length; i++){
            curSum+=nums[i];
            count+=storage.getOrDefault(curSum - k, 0);
            storage.put(curSum, storage.getOrDefault(curSum, 0)+1);
        }
        return count;
    }

    public static void main(String[] args){
        SubArraySumK sa = new SubArraySumK();
        System.out.print(sa.subarraySum(new int[]{1, 1, 1}, 2));
    }

}
