package problems.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kiryl_zayets on 9/26/18.
 */
public class ZigZagTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, deque, res);
        return res;
    }


    public static void helper(TreeNode root,
            Deque<TreeNode> storage,
            List<List<Integer>> res) {
        if (root == null) return;
        storage.add(root);
        int run = 1;
        while (!storage.isEmpty()) {
            int l = storage.size();
            TreeNode tr;
            List<Integer> intr = new LinkedList<>();
            for (int i = 0; i < l; i++) {
                tr = storage.poll();
                if (run % 2 == 0) intr.add(0, tr.val); // check for linked list
                else intr.add(tr.val);
                if (tr.left != null) storage.add(tr.left);
                if (tr.right != null) storage.add(tr.right);
            }
            run++;
            res.add(intr);
        }
    }


    public static void main(String[] args) {
        TreeNode r = new TreeNode(3);
        TreeNode g1 = new TreeNode(9);
        TreeNode g2 = new TreeNode(20);
        TreeNode g3 = new TreeNode(15);
        TreeNode g4 = new TreeNode(7);
        r.left = g1;
        r.right = g2;
        g2.left = g3;
        g2.right = g4;

        g1.left = new TreeNode(4);
        g1.right = new TreeNode(5);
        g3.right = new TreeNode(16);
        ZigZagTraversal.zigzagLevelOrder(r);
    }
}
