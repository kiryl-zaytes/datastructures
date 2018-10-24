package problems.math;

/**
 * Created by kiryl_zayets on 10/22/18.
 */
public class PerfectSquare {

    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        return helper(num, 1, num);
    }


    private boolean helper(int num, int l, int h) {

        if (l > h) return false;

        long m = l + (h - l) / 2;

        if (m * m == num) return true;
        else if (m * m > num) return helper(num, l, (int)m-1);
        else return helper(num, (int)m+1, h);
    }

    public static void main(String[] args) {

        PerfectSquare perfectSquare = new PerfectSquare();
        System.out.print(perfectSquare.isPerfectSquare(2147483647));
    }


}