package problems.trie;

/**
 * Created by kiryl_zayets on 11/21/18.
 */
public class WordDictionary {
    class Trie {
        int R = 256;
        Node root;

        class Node {
            Node[] next = new Node[256];
            String val;
        }


        public void insert(String key) {
            root = insert(root, key, 0);
        }

        private Node insert(Node root, String key, int d) {
            if (root == null) root = new Node();

            if (key.length() == d) {
                root.val = key;
                return root;
            }
            char c = key.charAt(d);
            root.next[c] = insert(root.next[c], key, d + 1);
            return root;
        }

        public boolean search(String word) {
            Node res = search(root, word, 0);
            if (res != null && res.val != null && res.val.length() == word.length()) return true;
            return false;
        }

        private Node search(Node root, String word, int d) {
            if (root == null) return null;
            if (word.length() == d) return root;

            char c = word.charAt(d);
            if (c == '.') {
                for (int i = 0; i < R; i++) {
                    if (root.next[i] != null)  {
                        Node res = search(root.next[i], word, d + 1);
                        if (res != null) return res;
                    }
                }
            } else return search(root.next[c], word, d + 1);
            return root;
        }

    }


    /**
     * Initialize your data structure here.
     */
    Trie tr;

    public WordDictionary() {
        tr = new Trie();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        tr.insert(word);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the
     * dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return tr.search(word);
    }

    public static void main(String[] args){

        WordDictionary wd = new WordDictionary();

        wd.addWord("at");
        wd.addWord("and");
        wd.addWord("an");
        wd.addWord("add");

        System.out.println(wd.search("a"));
        System.out.println(wd.search(".at"));
        wd.addWord("bat");
        System.out.println(wd.search(".at"));
//        System.out.println(wd.search("aa"));
//        System.out.println(wd.search("a"));
//        System.out.println(wd.search(".a"));
//        System.out.println(wd.search("a."));
    }

}
