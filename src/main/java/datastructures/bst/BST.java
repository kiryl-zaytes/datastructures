package datastructures.bst;

/**
 * Created by kiryl_zayets on 9/14/18.
 */
public class BST<K extends Comparable<K>, V> {

    Node root;

    class Node {
        private Node left;
        private Node right;
        private K key;
        private V value;

        private int N = 0;

        public Node(K key, V value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }

    }

    private int size(Node n) {
        if (n == null) return 0;
        return n.N;
    }

    public V get(K key) {
        return get(root, key);
    }

    public void put(K key, V value) {
        put(root, key, value);
    }

    private Node put(Node root, K key, V value) {
        if (root == null) {
            return new Node(key, value, 1);
        }
        if (key.compareTo(root.key) > 0)
            return root.left = put(root.left, key, value);
        else if (key.compareTo(root.key) < 0)
            return root.right = put(root.right, key, value);
        else root.value = value;
        root.N = size(root.left) + size(root.right) + 1;
        return root;

    }

    private V get(Node node, K key) {
        if (node == null) return null;
        if (node.key.compareTo(key) < 0) return get(node.left, key);
        else if (node.key.compareTo(key) > 0) return get(node.right, key);
        else return node.value;
    }


    public static void main(String[] args) {
        BST<String, Integer> bst = new BST<String, Integer>();

    }
}
