package problems.array;

import java.util.Arrays;

/**
 * Created by kiryl_zayets on 12/6/18.
 */
public class ArrayPartitionI {


    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length/2;
        int res = 0;
        int i = 0;
        while (l > 0) {
            res+=nums[i];
            l--;
            i+=2;
        }
        return res;
    }


    public static void main(String[] args){
        ArrayPartitionI ap = new ArrayPartitionI();
        System.out.print(ap.arrayPairSum(new int[]{-1, -4, 15, 14}));
    }




}
