package problems.array;

/**
 * Created by kiryl_zayets on 12/4/18.
 */
public class MaxConsecutive1 {

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) return 0;

        int max = 0;
        int curMax = 0;

        for(int i=0; i < nums.length; i++){
            if (nums[i] == 0) {
                max = Math.max(max, curMax);
                curMax = 0;
            }
            else curMax++;
        }

        return Math.max(max, curMax);
    }


    public static void main(String[] args){
        MaxConsecutive1 mc1 = new MaxConsecutive1();
        System.out.print(mc1.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1,
                1}));
    }
}
