package problems.string;

/**
 * Created by kiryl_zayets on 9/25/18.
 */
public class LongestPalindromicSubs {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 1) return s;

        String tmp = "";

        for (int i = 0; i < s.length(); i++) {
            String res = expand(s, i, i);
            if (res.length() > tmp.length()) tmp = res;
        }

        for (int i = 0; i < s.length(); i++) {
            String res = expand(s, i, i + 1);
            if (res.length() > tmp.length()) tmp = res;
        }
        return tmp;
    }


    public static String expand(String s, int l, int h) {
        while (l >= 0 && h < s.length() && s.charAt(l) == s.charAt(h)) {
            l--;
            h++;
        }
        return s.substring(l+1, h);
    }


    public static void main(String[] args) {
        LongestPalindromicSubs.longestPalindrome("ab");
    }


}
