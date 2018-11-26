package problems.math;

/**
 * Created by kiryl_zayets on 11/26/18.
 */
public class PowerOfTwo {


    public boolean isPowerOfTwo(int n) {
        if (n>0 && Integer.bitCount(n) == 1) return true;
        return false;
    }

}
