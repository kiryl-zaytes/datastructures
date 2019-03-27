package problems.string;

import java.util.*;

/**
 * Created by kiryl_zayets on 3/26/19.
 */
public class SSt {

    public List<List<String>> findLadders(String beginWord,
            String endWord,
            List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, Integer> distance = new HashMap<>();
        HashSet<String> uniqueWords = new HashSet<>(wordList);
        HashMap<String, HashSet<String>> graph = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        for (String s : uniqueWords) graph.put(s, new HashSet<String>());
        graph.put(beginWord, new HashSet<>());
        distance.put(beginWord, 0);
        buildGraphOfWords(graph, uniqueWords, q, distance, endWord);
        dfs(graph, beginWord, endWord, res, new ArrayList<>(), distance);
        return res;
    }

    private void buildGraphOfWords(HashMap<String, HashSet<String>> graph,
            HashSet<String> uniqueWords,
            Queue<String> q,
            HashMap<String, Integer> distance,
            String endWord) {

        while (!q.isEmpty()) {
            boolean found = false;
            String word = q.poll();
            int curDistance = distance.get(word);
            for (int i = 0; i < word.length(); i++) {
                char[] chars = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    if (chars[i] == j) continue;
                    chars[i] = j;
                    String tmp = new String(chars);
                    if (uniqueWords.contains(tmp)) {
                        graph.get(word).add(tmp);
                        if (!distance.containsKey(tmp)) {
                            distance.put(tmp, curDistance + 1);
                            if (tmp.equals(endWord)) found = true;
                            else q.offer(tmp);
                        }
                    }
                }
                if (found) break;
            }

        }
    }


    private void dfs(HashMap<String, HashSet<String>> graph,
            String word,
            String endWord,
            List<List<String>> res,
            List<String> tmp,
            HashMap<String, Integer> distance) {
        tmp.add(word);
        if (word.equals(endWord)) res.add(new ArrayList<>(tmp));

        for (String w : graph.get(word)) {
            if (distance.get(w) == distance.get(word) + 1)
                dfs(graph, w, endWord, res, tmp, distance);
        }
        tmp.remove(tmp.size() - 1);
    }

    public static void main(String[] args) {
        SSt sst = new SSt();
        ArrayList<String> ls = new ArrayList<>();
        ls.add("hot");
        ls.add("dot");
        ls.add("dog");
        ls.add("lot");
        ls.add("log");
        ls.add("cog");
        sst.findLadders("hit", "cog", ls);
    }

}
