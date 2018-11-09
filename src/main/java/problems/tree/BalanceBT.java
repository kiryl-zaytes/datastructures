package problems.tree;

/**
 * Created by kiryl_zayets on 11/9/18.
 */
public class BalanceBT {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    boolean balanced = true;


    public boolean isBalanced(TreeNode root) {
        helper(root);
        return balanced;
    }

    private int helper(TreeNode root) {
        if (root == null || !balanced) return 0;

        int lH = helper(root.left);
        int rH = helper(root.right);

        if (Math.abs(lH - rH) > 1) balanced = false;

        return 1+ Math.max(lH, rH);

    }

    public static void main(String[] args){

        BalanceBT b = new BalanceBT();
        TreeNode r = new TreeNode(1);
        TreeNode g1 = new TreeNode(2);
        TreeNode g2 = new TreeNode(2);
        r.left = g1;
        r.right = g2;
//        g2.left = new TreeNode(7);
//        g2.right = new TreeNode(9);
        g1.left = new TreeNode(3);
        g1.right = new TreeNode(3);
        g1.right.left = new TreeNode(4);
        g1.right.right = new TreeNode(4);

        System.out.print(b.isBalanced(r));
    }


}
