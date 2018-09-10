package problems.string;

/**
 * Created by kiryl_zayets on 9/9/18.
 */
public class BackSpace {

    public static boolean backspaceCompare(String S, String T) {

        if (S.length() < 1 || T.length() < 1) return false;

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int cnt = 0;

        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) != '#' && cnt == 0) {
                sb1.append(S.charAt(i));
            } else if (S.charAt(i) != '#' && cnt != 0) {
                cnt--;
            } else cnt++;

        }
        cnt = 0;

        for (int i = T.length() - 1; i >= 0; i--) {
            if (T.charAt(i) != '#' && cnt == 0) {
                sb2.append(T.charAt(i));
            } else if (T.charAt(i) != '#' && cnt != 0) {
                cnt--;
            } else cnt++;

        }

        return sb1.toString().equals(sb2.toString());

    }


    public static void main(String[] args) {
        System.out.print(BackSpace.backspaceCompare("a#c", "b"));
    }
}
