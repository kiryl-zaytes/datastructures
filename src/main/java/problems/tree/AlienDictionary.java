package problems.tree;

import java.util.*;

/**
 * Created by kiryl_zayets on 1/11/19.
 */
public class AlienDictionary {

    public String alienOrder(String[] words) {

        String res = "";
        if (words == null || words.length == 0) return res;

        HashMap<Character, Set<Character>> storage = new HashMap<>();
        HashMap<Character, Integer> degree = new HashMap<>();

        for (String w : words) {
            for (char c : w.toCharArray()) degree.put(c, 0);
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            int len = Math.min(w1.length(), w2.length());

            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if (c1 != c2) {
                    HashSet set = new HashSet<>();
                    if (storage.containsKey(c1))
                        set = (HashSet) storage.get(c1);

                    if (!set.contains(c2)) {
                        set.add(c2);
                        storage.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();

        for (Character c : degree.keySet()) {
            if (degree.get(c) == 0) queue.add(c);
        }

        while (!queue.isEmpty()) {
            char c = queue.poll();
            res += c;
            if (storage.containsKey(c)) {
                HashSet<Character> seq = (HashSet<Character>) storage.get(c);
                for (char ch : seq) {
                    int d = degree.get(ch) - 1;
                    if (d == 0) queue.add(ch);
                    degree.put(ch, d);
                }
            }
        }

        if (res.length() != degree.size()) return "";
        return res;
    }


}
