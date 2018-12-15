package problems.array;

/**
 * Created by kiryl_zayets on 11/29/18.
 */
public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        if (nums.length ==1) return nums[0];

        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;


        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
            } else if (nums[i] > secondMax && nums[i] != firstMax) {
                thirdMax = secondMax;
                secondMax = nums[i];
            } else if (nums[i] > thirdMax && nums[i] != secondMax && nums[i] != firstMax) thirdMax = nums[i];

        }

        return (thirdMax == Long.MIN_VALUE) ? (int)firstMax : (int)thirdMax;
    }


    public static void main(String[] args) {
        ThirdMaximumNumber thirdMaximumNumber = new ThirdMaximumNumber();
        System.out.print(thirdMaximumNumber.thirdMax(new int[]{1,2,-2147483648}));
    }

}
