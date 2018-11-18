package datastructures.trie;

/**
 * Created by kiryl_zayets on 11/15/18.
 */
public class Trie {

    private static int R = 256;
    private Node root;

    class Node {
        boolean val;
        private Node[] next = new Node[R];
    }

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        //root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        put(word, true);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return get(word);
    }

    public boolean get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return false;
        return x.val;
    }

    public void put(String key, boolean v) {
        root = put(root, key, v, 0);
    }

    public boolean startWith(String prefix) {
        Node x = get(root, prefix, 0);
        if (x == null) return false;
        return x.next.length > 0;
    }

    private Node put(Node root, String key, boolean v, int d) {
        if (root == null) root = new Node();
        if (key.length() == d) {
            root.val = v;
            return root;
        }
        char c = key.charAt(d);
        root.next[c] = put(root.next[c], key, v, d + 1);
        return root;
    }

    private Node get(Node root, String key, int d) {
        if (root == null) return null;
        if (key.length() == d) return root;
        Character c = key.charAt(d);
        return get(root.next[c], key, d + 1);
    }


    public static void main(String[] args) {
        Trie tr = new Trie();
        tr.insert("word");
        tr.startWith("wor");
        tr.search("word");
    }

}
