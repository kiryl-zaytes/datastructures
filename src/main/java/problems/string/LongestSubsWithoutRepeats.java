package problems.string;

import java.util.HashMap;

/**
 * Created by kiryl_zayets on 9/25/18.
 */
public class LongestSubsWithoutRepeats {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        int l = 0;
        int max = 0;
        HashMap<Character, Integer> storage = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!storage.containsKey(s.charAt(i))) {
                l++;
                storage.put(s.charAt(i), i);
            } else {
                max = Math.max(l, max);
                l = 0;
                int pos = storage.get(s.charAt(i));
                i = pos;
                storage.clear();
            }

        }
        return Math.max(l, max);

    }


    public static void main(String[] args) {
        System.out.print(LongestSubsWithoutRepeats.lengthOfLongestSubstring
                ("baabb"));
    }

}
