package problems.math;

/**
 * Created by kiryl_zayets on 9/19/18.
 */
public class PowerOfThree {

    public static boolean isPowerOfThree(int n) {
        if (n >0 && 1162261467 % n == 0) return true;
        return false;
    }

}
