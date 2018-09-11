package problems.string;

/**
 * Created by kiryl_zayets on 9/11/18.
 */
public class ReverseInteger {

    public static long reverseInt(int x) {
        long res = 0;
        while (Math.abs(x) > 0) {
            res *= 10;
            res += x % 10;
            x = x / 10;
        }
        return res == (int) res ? (int) res : 0;
    }


    public static void main(String args[]) {
        System.out.print(ReverseInteger.reverseInt(-123));
    }


}
