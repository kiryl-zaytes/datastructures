package problems.string;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by kiryl_zayets on 12/14/18.
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {

        if (s == null || t == null || s.length() > t.length()) return false;

        int i = 0;
        int j = 0;

        while (true) {
            if (s.length() == i) return true;
            if (t.length() == j) return false;
            if (s.charAt(i) != t.charAt(j)) j++;
            else {
                i++;
                j++;
            }
        }
    }


    // when s is streaming s1,s2,sk, k > 1B.
    public boolean isSubsequence1(String s, String t) {
        ArrayList[] storage = new ArrayList[256];
        for (int i = 0; i < t.charAt(i); i++) {
            if (storage[t.charAt(i)] == null)
                storage[t.charAt(i)] = new ArrayList();
            storage[t.charAt(i)].add(i);
        }

        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            if (storage[s.charAt(i)].size() == 0) return false;
            int j = Collections.binarySearch(storage[s.charAt(i)], prev);
            if (j < 0) j *= -1;
            if (j == storage[s.charAt(i)].size()) return false;
            prev = (int) storage[s.charAt(i)].get(j) + 1;
        }
        return true;

    }


    public static void main(String[] args) {
        IsSubsequence iss = new IsSubsequence();
        System.out.print(iss.isSubsequence("axc", "ahbgdc"));
    }

}
