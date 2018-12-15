package problems.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Template for all problems
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
 */
public class FindAllAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        ArrayList res = new ArrayList();
        if (p.length() > s.length()) return res;
        int l = p.length();
        int[] storage = new int[256];
        for (int i = 0; i < p.length(); i++) {
            storage[p.charAt(i)]++;
        }

        int end = 0;
        int start = 0;
        while (end < s.length()) {
            int c = s.charAt(end);
            if (--storage[c] >= 0) l--;

            end++;

            while (l == 0) {
                int c1 = s.charAt(start);
                if (++storage[c1] == 1) l++;
                if (end - start == p.length()) res.add(start);
                start++;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        FindAllAnagrams fa = new FindAllAnagrams();
        fa.findAnagrams("baa", "aa");
    }

}
