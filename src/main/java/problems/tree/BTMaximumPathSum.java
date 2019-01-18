package problems.tree;

/**
 * Created by kiryl_zayets on 1/17/19.
 */
public class BTMaximumPathSum {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return max;
    }


    private int helper(TreeNode root){
        if (root == null) return 0;

        int l = helper(root.left);
        int r = helper(root.right);

        if (l < 0) max = Math.max(max, Math.max(root.val, root.val + r));
        else if (r < 0) max = Math.max(max, Math.max(root.val, root.val + l));
        else max = Math.max(max, root.val + l + r);

        return Math.max(root.val, Math.max(root.val + l, root.val + r));

    }


    public static void main(String[] args){
        BTMaximumPathSum bt = new BTMaximumPathSum();

        TreeNode r = new TreeNode(-10);
        TreeNode g1 = new TreeNode(9);
        TreeNode g2 = new TreeNode(20);
        r.left = g1;
        r.right = g2;
        g2.left = new TreeNode(15);
        g2.right = new TreeNode(7);
        bt.helper(r);
    }

}
