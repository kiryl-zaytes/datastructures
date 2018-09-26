package problems.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiryl_zayets on 9/26/18.
 */
public class InorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) helper(root, res);
        return res;
    }


    public static void helper(TreeNode root, List<Integer> l) {
        if (root == null) return;
        helper(root.left, l);
        System.out.println(root.val);
        l.add(root.val);
        helper(root.right, l);
    }


    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);
        TreeNode g1 = new TreeNode(2);
        TreeNode g2 = new TreeNode(3);
        r.right = g1;
//        r.right = g2;
//        g2.left = new TreeNode(15);
//        g2.right = new TreeNode(17);
        g1.left = g2;

        InorderTraversal.inorderTraversal(r);
    }


}
