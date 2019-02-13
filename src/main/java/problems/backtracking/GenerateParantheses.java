package problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiryl_zayets on 2/13/19.
 */
public class GenerateParantheses {


    public List<String> generateParenthesis(int n) {
        ArrayList<String> storage = new ArrayList<>();
        backTrack(storage, "", 0, 0, n);
        return storage;

    }

    private void backTrack(List<String> storage,String res,  int open, int closed, int n){
        if (n*2 == open + closed){
            storage.add(res);
            return;
        }
        if (open < n) backTrack(storage, res+'(', open + 1, closed, n);
        if (closed < open) backTrack(storage, res + ')', open, closed +1, n);
    }
}
