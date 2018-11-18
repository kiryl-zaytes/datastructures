package problems.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiryl_zayets on 11/18/18.
 */
public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        if (dict.size() == 0 || sentence.length() == 0) return sentence;
        Trie tr = new Trie();
        for (String s : dict) tr.insert(s, s);

        String[] sent = sentence.split(" ");

        for (int i = 0; i < sent.length; i++) {
            String root = tr.search(sent[i]);
            if (!root.equals("")) sent[i] = root;
        }
        return String.join(" ", sent);
    }


    class Trie {
        int R = 256;
        Node root;

        class Node {
            Node[] next = new Node[256];
            String val;
        }


        public void insert(String key, String val) {
            this.root = insert(root, key, val, 0);
        }

        // do not return as we need to go deeper as oppose to binary tree
        private Node insert(Node root, String key, String val, int d) {
            if (root == null) root = new Node();
            if (key.length() == d) {
                root.val = val;
                return root;
            }
            char c = key.charAt(d);
            root.next[c] = insert(root.next[c], key, val, d + 1);
            return root;
        }


        public String search(String word) {
            int n = search(root, word, 0, 0);
            return word.substring(0, n);
        }

        private int search(Node root, String word, int d, int l) {
            if (root == null) return l;
            if (root.val != null) {
                l= d;
                return l;
            }
            if (d == word.length()) return l;
            char c = word.charAt(d);
            return search(root.next[c], word, d + 1, l);

        }
    }

    public static void main(String[] args) {
        ReplaceWords rpw = new ReplaceWords();
        List<String> words = new ArrayList<>();
        words.add("a");
        words.add("aa");
        words.add("aaa");
        words.add("aaaa");
        System.out.print(rpw.replaceWords(words, "a aa a aaaa aaa aaa aaa " +
                "aaaaaa bbb baba ababa"));
    }

}