package problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiryl_zayets on 2/14/19.
 */
public class WordSquares {

    List<List<String>> res = null;

    public List<List<String>> wordSquares(String[] words) {

        res = new ArrayList<>();
        backTrack(words, 0, new ArrayList<>());
        return res;

    }


    private void backTrack(String[] words, int num, List<String> res) {
        if (num == words.length) {
            check(res);
            res.clear();
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(words[num])) continue;
            res.add(words[num]);
            backTrack(words, num + 1, res);
        }
    }


    private void check(List<String> tmp) {
        for (int i = 0; i<tmp.size(); i++){
            String current  = tmp.get(i);
            for (int j=0; j < current.length(); j++){
                if (current.charAt(j) != tmp.get(j).charAt(i)) return;
            }
        }
        this.res.add(tmp);
    }


    public static void main(String[] args){

        WordSquares ws = new WordSquares();
        ws.wordSquares(new String[]{"area","lead","wall","lady","ball"});
    }
}
