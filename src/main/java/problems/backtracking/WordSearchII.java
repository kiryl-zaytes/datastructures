package problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiryl_zayets on 11/21/18.
 */
public class WordSearchII {

    static class Trie<T> {
        static int R = 256;
        Node root;

        private static class Node {
            Node[] next = new Node[R];
            Object val;
        }

        public void insert(String key, T val) {
            this.root = insert(root, key, val, 0);
        }

        // do not return as we need to go deeper as oppose to binary tree
        private Node insert(Node root, String key, T val, int d) {
            if (root == null) root = new Node();
            if (key.length() == d) {
                root.val = val;
                return root;
            }
            char c = key.charAt(d);
            root.next[c] = insert(root.next[c], key, val, d + 1);
            return root;
        }

    }

    Trie<String> tr;

    public List<String> findWords(char[][] board, String[] words) {
        ArrayList res = new ArrayList();
        if (words.length == 0 || board.length == 0) return res;
        tr = new Trie<>();
        for (int i = 0; i < words.length; i++) {
            tr.insert(words[i], words[i]);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                move(board, i, j, tr.root, res);
            }
        }
        return res;
    }


    private void move(char[][] board,
            int i,
            int j,
            Trie.Node node,
            ArrayList res) {

        char c = board[i][j];
        if (c == '#' || node.next[c] == null) return;
        node = node.next[c];
        if (node.val != null) {
            res.add(node.val);
            node.val = null;
        }

        board[i][j] = '#';

        if (i > 0) move(board, i - 1, j, node, res);
        if (j > 0) move(board, i, j - 1, node, res);
        if (i < board.length - 1) move(board, i + 1, j, node, res);
        if (j < board[0].length - 1) move(board, i, j + 1, node, res);

        board[i][j] = c;

    }


}
