package problems.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by kiryl_zayets on 9/14/18.
 */
public class LevelOrderTraversal {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
    
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        List<List<Integer>> s = new LinkedList<List<Integer>>();
        if (root == null) return s;
        qu.add(root);
        while (!qu.isEmpty()) {
            int levels = qu.size();
            List<Integer> sub = new LinkedList<Integer>();
            for (int j = 0; j < levels; j++) {
                TreeNode n = qu.remove();
                if (n.left != null) qu.offer(n.left);
                if (n.right != null) qu.offer(n.right);
                sub.add(n.val);
            }
            s.add(sub);
        }

        return s;
    }

    public static void main(String[] args) {
        TreeNode r = new TreeNode(3);
        TreeNode g1 = new TreeNode(9);
        TreeNode g2 = new TreeNode(20);
        r.left = g1;
        r.right = g2;
        g2.left = new TreeNode(15);
        g2.right = new TreeNode(17);
        g1.left = new TreeNode(14);
        LevelOrderTraversal.levelOrder(r);

    }


}
