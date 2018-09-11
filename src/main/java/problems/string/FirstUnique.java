package problems.string;

/**
 * Created by kiryl_zayets on 9/11/18.
 */
public class FirstUnique {

    public static int firstUniqChar(String s) {
        if (s.length() < 1) return -1;
        if (s.length() == 1) return 0;

        char[] ASCII = new char[255];

        for (int i = 0; i < s.length(); i++) {
            ASCII[s.charAt(i)]++;
        }

        for (int j = 0; j < s.length(); j++) {
            if (ASCII[s.charAt(j)] == 1) return j;
        }

        return -1;

    }


    public static void main(String[] args) {
        System.out.print(FirstUnique.firstUniqChar("loveleetcode"));
    }


}
