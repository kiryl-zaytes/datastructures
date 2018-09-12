package problems.string;

/**
 * Created by kiryl_zayets on 9/11/18.
 */
public class ValidAnagram {


    public static boolean isAnagram(String s, String t) {

        if (t.length() != s.length()) return false;
        if (s.length() < 1 && t.length() < 1) return true;
        if (s.equals(t)) return true;

        int[] storage = new int[256];

        for (int i = 0; i < s.length(); i++) {
            storage[s.charAt(i)]++;
        }

        for (int j = 0; j < t.length(); j++) {
            if (--storage[t.charAt(j)] < 0) return false;
        }
        return true;

    }


    public static void main(String[] args) {
        System.out.print(ValidAnagram.isAnagram("ab", "a"));
    }


}
