package problems.array;

/**
 * Created by kiryl_zayets on 11/27/18.
 */
public class RangeSumImmutable {

    int[] sum;

    public RangeSumImmutable(int[] nums) {
        sum = new int[nums.length+1];
        for(int i=0; i<nums.length;i++){
            sum[i+1] = sum[i] + nums[i];
        }

    }

    public int sumRange(int i, int j) {

        return sum[j+1] - sum[i];
    }

}
