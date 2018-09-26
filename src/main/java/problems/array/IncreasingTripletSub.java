package problems.array;

/**
 * Created by kiryl_zayets on 9/26/18.
 */
public class IncreasingTripletSub {


    public static boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int vMax = Integer.MAX_VALUE;
        int vMax2 = Integer.MAX_VALUE;


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= vMax) vMax = nums[i];
            else if (nums[i] <= vMax2) vMax2 = nums[i];
            else return true;
        }
        return false;
    }


    public static void main(String[] args) {
        IncreasingTripletSub.increasingTriplet(new int[]{1,5,0,4,5});
    }

}
