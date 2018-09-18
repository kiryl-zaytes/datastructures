package problems.dp;

/**
 * Created by kiryl_zayets on 9/18/18.
 */
public class HouseRobber {

//    public int rob(int[] nums) {
//
//    }

    public static int robb(int[] nums) {
        if (nums.length ==0) return 0;

        int f = 0;
        int s = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) f = Math.max(f + nums[i], s);
            else s = Math.max(s + nums[i], f);
        }
        return Math.max(f, s);
    }


    public static void main(String[] args) {
        System.out.print(HouseRobber.robb(new int[]{1, 2, 3, 1}));
    }
}
