package problems.tree;

/**
 * Created by kiryl_zayets on 9/14/18.
 */
public class MaxDepth {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }


    public static int maxDepth(TreeNode root) {

        if (root == null) return 0;

        return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));

    }


    public static void main(String[] args) {
        TreeNode r = new TreeNode(3);
        TreeNode g1 = new TreeNode(9);
        TreeNode g2 = new TreeNode(20);
        r.left = g1;
        r.right = g2;
        g2.left = new TreeNode(15);
        g2.right = new TreeNode(7);
//        g1.left = new TreeNode(14);
        g2.left.left = new TreeNode(10);
        MaxDepth.maxDepth(r);
    }
}
