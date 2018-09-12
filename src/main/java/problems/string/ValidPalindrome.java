package problems.string;

/**
 * Created by kiryl_zayets on 9/11/18.
 */
public class ValidPalindrome {


    public static boolean isPalindrome(String s) {
        if (s.length() < 2) return true;
        s = s.toLowerCase();

        int l = 0;
        int h = s.length() - 1;

        while (l < h) {

            while (l <= h && !Character.isLetterOrDigit(s.charAt(l)))
                l++;
            while (h >= l && !Character.isLetterOrDigit(s.charAt(h))) h--;

            if (l > h) return true;
            if (s.charAt(l++) != s.charAt(h--)) return false;
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.print(ValidPalindrome.isPalindrome("race a car"));
    }
}
