package problems.string;

import java.util.HashSet;

/**
 * Created by kiryl_zayets on 11/27/18.
 */
public class ReverseVowels {

    public String reverseVowels(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) return s;
        HashSet set = new HashSet();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        int l = 0;
        int h = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        while (l <= h) {
            if (!set.contains(s.charAt(l))) sb.append(s.charAt(l++));
            else if (!set.contains(s.charAt(h))) sb2.append(s.charAt(h--));
            else if (l == h) sb.append(s.charAt(l++));
            else if (set.contains(s.charAt(l)) && set.contains(s.charAt(h))) {
                sb.append(s.charAt(h));
                sb2.append(s.charAt(l));
                h--;
                l++;
            }
        }
        return sb.toString() + sb2.reverse().toString();
    }


    public static void main(String[] args) {
        ReverseVowels rv = new ReverseVowels();
        System.out.print(rv.reverseVowels("ee"));
    }

}
