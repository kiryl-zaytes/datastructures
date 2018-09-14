package problems.array;

/**
 * Created by kiryl_zayets on 9/13/18.
 */
public class FirstBadVersion {
    // boolean isBadVersion(int version);
    boolean state = true;
    boolean isB = false;


    public boolean isBadVersion(int x) {
        return false;
    }

    public int firstBadVersion(int n) {
        int l = 1;
        while (l < n) {
            int m = l + (n - l) / 2;
            if (isBadVersion(m)) n = m;
            else l = m + 1;
        }
        return l;
    }


}
