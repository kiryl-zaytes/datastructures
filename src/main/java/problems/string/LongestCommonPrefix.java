package problems.string;

import java.util.Random;

/**
 * Created by kiryl_zayets on 9/11/18.
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        Random r = new Random();
        String randomWord = strs[r.nextInt(strs.length)];
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < randomWord.length(); i++) {
            char c = randomWord.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() <= i || c != strs[j].charAt(i))
                    return stringBuilder.toString();
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        System.out.print(LongestCommonPrefix.longestCommonPrefix(new
                String[]{"", "dogoooefefefefefefefefefefee",
                "dogooo32e32423432432423"}));
    }

}
