package problems.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by kiryl_zayets on 11/23/18.
 */
public class LevelOrderTraversalII {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, new LinkedList<TreeNode>(), res);
        return res;

    }

    private void helper(TreeNode root,
            Queue<TreeNode> storage,
            List<List<Integer>> res) {
        storage.add(root);
        while (!storage.isEmpty()) {
            int l = storage.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < l; i++) {
                TreeNode node = storage.poll();
                if (node.left != null) storage.add(node.left);
                if (node.right != null) storage.add(node.right);
                tmp.add(node.val);
            }
            res.add(0, tmp);
        }
    }


    public static void main(String[] args){
        LevelOrderTraversalII lot2 = new LevelOrderTraversalII();
        TreeNode r = new TreeNode(3);
        TreeNode g1 = new TreeNode(9);
        TreeNode g2 = new TreeNode(20);
        r.left = g1;
        r.right = g2;
        g2.left = new TreeNode(15);
        g2.right = new TreeNode(17);
        lot2.levelOrderBottom(r);
    }
}
