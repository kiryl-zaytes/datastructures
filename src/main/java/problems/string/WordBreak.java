package problems.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by kiryl_zayets on 12/18/18.
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i=1; i <=s.length(); i++){
            for (int j=0; j < i; j++){
                if (dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args){
        WordBreak wb = new WordBreak();
        ArrayList s = new ArrayList();
        s.add("leet");
        s.add("code");
        wb.wordBreak("leetcode", s);
    }

}
