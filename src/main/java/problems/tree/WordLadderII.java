package problems.tree;

import java.util.*;

/**
 * Created by kiryl_zayets on 1/9/19.
 */
public class WordLadderII {

    HashMap<String, Set<String>> mapping;
    HashMap<String, Integer> distance;

    public List<List<String>> findLadders(String beginWord,
            String endWord,
            List<String> wordList) {

        ladderLength(beginWord, endWord, wordList);

        ArrayList<List<String>> res = new ArrayList<>();
        distance.put(beginWord, 0);
        getSequences(beginWord, endWord, new ArrayList<>(), res);
        return res;
    }


    public int ladderLength(String beginWord, String endWord,
            List<String> wordList) {

        HashSet<String> reached = new HashSet<>();
        HashSet<String> words = new HashSet<>(wordList);

        mapping = new HashMap<>();
        distance = new HashMap<>();
        int lvl = 1;

        reached.add(beginWord);
        words.add(endWord);

        for (String w : words) mapping.put(w, new HashSet<>());
        mapping.put(beginWord, new HashSet<>());

        while (!reached.contains(endWord)) {
            HashSet<String> temp = new HashSet<>();
            for (String reach : reached) {
                for (int i = 0; i < reach.length(); i++) {
                    char[] reachArray = reach.toCharArray();
                    for (char ii = 'a'; ii <= 'z'; ii++) {
                        reachArray[i] = ii;
                        String newWord = new String(reachArray);
                        if (wordList.contains(newWord)) {
                            if (!distance.containsKey(newWord)) {
                                distance.put(newWord, lvl);
                                temp.add(newWord);
                            }
                            mapping.get(reach).add(newWord);

                        }
                    }
                }
                //      mapping.put(reach, new ArrayList<>(temp));
            }
            lvl++;
            if (temp.size() == 0) return 0;
            reached = temp;
        }

        return lvl;

    }

    private void getSequences(String start,
            String end,
            ArrayList<String> solution,
            ArrayList<List<String>> res) {
        solution.add(start);
        if (end.equals(start)) res.add(new ArrayList<String>(solution));
        else {
            Set<String> neighbours = mapping.get(start);
            for (String n : neighbours) {
                if (distance.get(n) == distance.get(start) + 1) {
                    getSequences(n, end, solution, res);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }

    public static void main(String[] args) {
        WordLadderII wordLadder = new WordLadderII();
        wordLadder.findLadders("hit", "cog", new
                ArrayList<>(Arrays
                .asList(new
                        String[]{"hot", "dot", "dog", "lot", "log", "cog"})));

        System.out.print("rr");
        //wordLadder.getSequence();
    }
}
