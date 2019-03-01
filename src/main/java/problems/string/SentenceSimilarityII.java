package problems.string;

import java.util.*;

/**
 * Created by kiryl_zayets on 2/26/19.
 */
public class SentenceSimilarityII {

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {

        if (words1.length != words2.length) return false;

        HashMap<String, List<String>> storage = new HashMap<>();

        for (String[] ss: pairs){
            for (String s : ss){
                if (!storage.containsKey(s)) storage.put(s, new ArrayList<>());
            }
            storage.get(ss[0]).add(ss[1]);
            storage.get(ss[1]).add(ss[0]);
        }

        for (int i=0; i < words1.length; i++){
            String w1 = words1[i];
            String w2 = words2[i];

            HashSet<String> visited = new HashSet<>();
            Stack<String> stack = new Stack<>();

            stack.push(w1);
            visited.add(w1);

            search: {
                while (!stack.isEmpty()){
                    String word = stack.pop();
                    if (word.equals(w2)) break search;
                    List<String> list = storage.get(word);
                    for (String l : list){
                        if (!visited.contains(l)) {
                            stack.push(l);
                            visited.add(l);
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

}
