package problems.array;

import java.util.Random;

/**
 * Created by kiryl_zayets on 9/18/18.
 */
public class Shuffle {

    private int[] cp;

    public Shuffle(int[] n) {
        cp = n.clone();
        shuffle(n);
    }

    public int[] shuffle(int[] n) {
        if (n.length == 0) return null;
        Random r = new Random();

        for (int i = n.length; i > 0; i--) {
            int ii = r.nextInt(i);
            int buff;

            buff = n[i];
            n[i] = n[ii];
            n[ii] = buff;
        }
        return n;
    }

    public int[] reset() {
        return cp;
    }
}
