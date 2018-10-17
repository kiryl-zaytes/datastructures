package problems.math;

/**
 * Created by kiryl_zayets on 10/17/18.
 */
public class Sqrt {

    public int mySqrt(int x) {
        if (x == 0) return 0;
        return helper(1, x, x);
    }


    private int helper(int l, int h, int target) {

        if (h - l <= 1) return l;
        if (l > h) return -1;
        int m = l + (h - l) / 2;
        if (m > target/m) return helper(l, m, target);
        else if (m < target/m) return helper(m, h, target);
        return m;
    }


    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();

        System.out.print(sqrt.mySqrt(144));
    }
}
