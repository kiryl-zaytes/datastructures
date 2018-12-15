package problems.math;

/**
 * Created by kiryl_zayets on 11/30/18.
 */
public class ArrangeCoins {

    public int arrangeCoins(int n) {

        if (n < 1) return 0;
        for (int i = 0; ; i++) {
            n -= i;
            if (n < 0) return i - 1;
        }
    }
}
