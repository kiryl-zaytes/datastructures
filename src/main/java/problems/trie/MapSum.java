package problems.trie;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kiryl_zayets on 11/16/18.
 */
public class MapSum {

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


        Node get(Node root, String key, int d) {
            if (root == null) return null;
            if (key.length() == d) return root;
            char c = key.charAt(d);
            return get(root.next[c], key, d + 1);
        }

        private void collect(Node root, String prefix, Queue<Integer> q) {
            if (root == null) return;
            if (root.val != null) q.add((Integer) root.val);
            for (int i = 0; i < R; i++) collect(root.next[i], prefix + i, q);
        }

        int sum(String prefix) {
            Queue<Integer> queue = new LinkedList<>();
            Node node = get(this.root, prefix, 0);
            collect(node, prefix, queue);
            int res = 0;
            for (Integer q : queue) {
                res += q;
            }
            return res;
        }
    }

    MapSum.Trie<Integer> tr;

    public MapSum() {
        tr = new MapSum.Trie<Integer>();
    }

    public void insert(String pref, int v) {
        tr.insert(pref, v);
    }

    public int sum(String prefix) {
        return tr.sum(prefix);
    }


    public static void main(String[] args) {
        MapSum ms = new MapSum();
        ms.insert("apple", 3);
        System.out.print(ms.sum("ap"));
        ms.insert("app", 2);
        System.out.print(ms.sum("ap"));
    }


}
