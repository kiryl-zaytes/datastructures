package problems.string;

import java.util.HashMap;

/**
 * Created by kiryl_zayets on 11/29/18.
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) return s.length();
        HashMap<Character, Integer> storage = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            storage.put(c, storage.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        for (int j = 0; j < s.length(); j++) {
            Character c = s.charAt(j);
            int tmp = storage.getOrDefault(c, 0);
            res+=tmp/2 *2;
            if (res % 2 ==0 & tmp % 2 ==1) res++;
            storage.put(c, 0);
        }
        return res;
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        System.out.print(lp.longestPalindrome("Aa"));
    }

}
