package problems.dp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by kiryl_zayets on 2/7/19.
 */
public class WordBreakII {

    public List<String> wordBreak(String s, Set<String> wordDict) {

        HashMap<String, LinkedList> storage = new HashMap<>();
        return breakWord(s, wordDict, storage);
    }


    private List<String> breakWord(String s, Set<String> words, HashMap<String, LinkedList> storage){

        if (storage.containsKey(s)) return storage.get(s);

        LinkedList<String> res = new LinkedList<>();
        if (s.length() == 0){
            res.add("");
            return res;
        }

        for(String word: words){
            if(s.startsWith(word)){
                LinkedList<String> temp = (LinkedList<String>) breakWord(s.substring(word.length()), words, storage);
                for (String w: temp){
                    if (w.equals("")) res.add(word + "");
                    else res.add(word + " " + w);
                }
            }
        }

        storage.put(s, res);
        return res;
    }

}
