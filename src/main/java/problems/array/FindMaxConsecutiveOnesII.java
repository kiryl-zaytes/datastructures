package problems.array;

/**
 * Created by kiryl_zayets on 2/25/19.
 */
public class FindMaxConsecutiveOnesII {


    int zeroSeen = 0;
    int max = 0;
    int cur = 0;
    int sumBeforeZero = 0;

    int left = 0;

    public int findMaxConsecutiveOnes(int[] nums) {

        for (int i=0; i < nums.length; i++) {
            if (nums[i] == 0) zeroSeen++;
            while (zeroSeen > 1){
                if (nums[left++] == 0) zeroSeen--;
            }
            max = Math.max(max, i - left +1);
        }
        return max;

    }



    public static void main(String[] args){
        FindMaxConsecutiveOnesII fmxs = new FindMaxConsecutiveOnesII();
        fmxs.findMaxConsecutiveOnes(new int[]{1,0,1,1,0});

    }



}
