package problems.tree;

import java.util.*;

/**
 * Created by kiryl_zayets on 10/15/18.
 */
public class WordLadder {

    class Item {
        String word;
        int len = 0;

        public Item(String w, int l) {
            this.word = w;
            this.len = l;
        }

    }


    public int ladderLength(String beginWord,
            String endWord,
            List<String> wordList) {
        int num = 1;

        Item item = new Item(beginWord, 1);
        Queue<Item> storage = new LinkedList<>();
        storage.offer(item);

        while (!storage.isEmpty()) {
            Item wordToSearch = storage.poll();

            for (int i = 0; i < wordList.size(); i++) {
                String s = wordList.get(i);
                if (noMoreThanOne(s, wordToSearch.word)) {
                    int lNew = wordToSearch.len + 1;
                    storage.offer(new Item(s, lNew));
                    wordList.remove(i);
                    if (s.equals(endWord)) return lNew;
                }
            }

        }
        return 0;
    }


    private boolean noMoreThanOne(String word, String pattern) {
        int notMatch = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != pattern.charAt(i)) notMatch++;
        }
        return (notMatch == 1);
    }


    public int ladderLength1(String beginWord,
            String endWord,
            List<String> wordList) {

        HashSet<String> reached = new HashSet<>();
        HashSet<String> words = new HashSet<>(wordList);

        reached.add(beginWord);
        words.add(endWord);

        int lvl = 1;
        while (!reached.contains(endWord)) {
            HashSet<String> toAdd = new HashSet<>();
            for (String reach : reached) {
                for (int i = 0; i < reach.length(); i++) {
                    char[] r = reach.toCharArray();
                    for (char j = 'a'; j <= 'z'; j++) {
                        r[i] = j;
                        String rs = new String(r);
                        if (words.contains(rs)) {
                            toAdd.add(rs);
                            words.remove(rs);
                        }
                    }
                }
            }
            lvl++;
            if (toAdd.size() == 0) return 0;
            reached = toAdd;
        }
        return lvl;
    }


    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        System.out.print(wordLadder.ladderLength("toon", "plea", new
                ArrayList<>(Arrays
                .asList(new
                        String[]{"poon", "plee", "same", "poie", "plie",
                        "poin", "plea"}))));
    }
}

