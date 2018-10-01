package problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiryl_zayets on 9/29/18.
 */
public class LetterCombinations {

    String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyx"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();

        if (digits == null || digits.length() == 0) return res;

        helper("", res, digits, 0);
        return res;
    }


    public void helper(String pref, List<String> res, String digits, int pos) {

        if (pref.length() == digits.length()) {
            res.add(pref);
            return;
        }

        String button = mapping[digits.charAt(pos) - '0'];

        for (int i = 0; i < button.length(); i++) {
            helper(pref + button.charAt(i), res, digits, pos + 1);
        }

    }


    public static void main(String[] args) {
        LetterCombinations letterCombination = new LetterCombinations();

        letterCombination.letterCombinations("23");
    }

}
