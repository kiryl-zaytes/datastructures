package problems.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kiryl_zayets on 12/21/18.
 */
public class WordDistance {

    HashMap<String, List<Integer>> storage;

    public WordDistance(String[] words) {

        storage = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (storage.containsKey(words[i])) {
                storage.get(words[i]).add(i);
            } else {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                storage.put(words[i], tmp);
            }
        }

    }

    public int shortest(String word1, String word2) {

        List<Integer> l1 = storage.get(word1);
        List<Integer> l2 = storage.get(word2);
        int min = Integer.MAX_VALUE;

        for(int i = 0, j=0; i < l1.size() && j < l2.size();){
            int v1 = l1.get(i);
            int v2 = l2.get(i);
            if (v1 < v2){
                min = Math.min(min, v2 - v1);
                i++;
            }
            else {
                min = Math.min(min, v1-v2);
                j++;
            }
        }
        return min;
    }

}
