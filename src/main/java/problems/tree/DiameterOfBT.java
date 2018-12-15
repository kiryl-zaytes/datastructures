package problems.tree;

/**
 * Created by kiryl_zayets on 12/5/18.
 */
public class DiameterOfBT {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int l = diameterOfBinaryTree(root.left);
        int r = diameterOfBinaryTree(root.right);
        max = Math.max(max, l + r);

        return Math.max(l , r) + 1;

    }


}
