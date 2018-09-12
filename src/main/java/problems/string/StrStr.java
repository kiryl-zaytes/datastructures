package problems.string;

/**
 * Created by kiryl_zayets on 9/11/18.
 */
public class StrStr {

    public static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;
        if (haystack.equals(needle)) return 0;
        for (int i = 0; i < haystack.length(); i++) {
            int j = 0;
            for (; j < needle.length(); j++) {
                if (i+j >= haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }

            if (j == needle.length()) return i;
        }

        return -1;
    }


    public static void main(String[] args) {
        System.out.println(StrStr.strStr("mississippi", "issipi"));
    }
}