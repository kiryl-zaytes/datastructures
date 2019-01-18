package problems.tree;

import java.util.*;

/**
 * Created by kiryl_zayets on 1/18/19.
 */
public class ClosestLeafBT {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }


    HashMap<TreeNode, TreeNode> pathBack = new HashMap<>();

    Queue<TreeNode> queue = new LinkedList<>();

    Set<TreeNode> visited = new HashSet<>();

    public int findClosestLeaf(TreeNode root, int k) {

        TreeNode treeNode = dfs(root, k);
        queue.add(treeNode);
        visited.add(treeNode);
        return bfs(queue);

    }

    private int bfs(Queue<TreeNode> queue){

        while (!queue.isEmpty()){

            TreeNode node = queue.poll();

            if (node.left == null && node.right == null) return node.val;

            if (node.left != null && visited.add(node.left)) queue.add(node.left);

            if (node.right != null && visited.add(node.right)) queue.add(node.right);

            if (pathBack.containsKey(node) && visited.add(pathBack.get(node))) queue.add(pathBack.get(node));
        }
        return -1;
    }

    private TreeNode dfs(TreeNode root, int k) {

        if (root.val == k) return root;

        if (root.left != null) {
            pathBack.put(root.left, root);
            TreeNode left = dfs(root.left, k);
            if (left != null) return left;
        }
        if (root.right != null) {
            pathBack.put(root.right, root);
            TreeNode right = dfs(root.right, k);
            if (right != null) return right;
        }
        return null;
    }

}
