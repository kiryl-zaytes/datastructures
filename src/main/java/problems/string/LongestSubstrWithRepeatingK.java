package problems.string;

/**
 * Created by kiryl_zayets on 12/14/18.
 */
public class LongestSubstrWithRepeatingK {

    public int longestSubstring(String s, int k) {
        if (s.length() < k) return 0;

        int[] storage = new int[256];

        for (int i = 0; i < s.length(); i++) {
            storage[s.charAt(i)]++;
        }

        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (storage[s.charAt(i)] < k) flag = false;
        }
        if (flag) return s.length();

        int max = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (storage[s.charAt(i)] < k) {
                max = Math.max(max, longestSubstring(s.substring(start, i), k));
                start = i + 1;
            }
        }
        return Math.max(max, longestSubstring(s.substring(start), k));
    }


    public static void main(String[] args) {
        LongestSubstrWithRepeatingK ls = new LongestSubstrWithRepeatingK();
        System.out.print(ls.longestSubstring("ababacb", 3));

    }

}
