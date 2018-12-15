package problems.tree;

/**
 * Created by kiryl_zayets on 11/28/18.
 */
public class SumOfLeftLeaves {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }


    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, true);
    }


    private int helper(TreeNode root, boolean isLeft){
        if (root == null) return 0;
        if (isLeft && root.left == null && root.right == null) return root.val;
        int l = helper(root.left, true);
        int r = helper(root.right, false);
        return l+r;
    }

    public static void main(String[] args) {
        TreeNode r = new TreeNode(3);
        TreeNode g1 = new TreeNode(9);
        TreeNode g2 = new TreeNode(20);
        r.left = g1;
        r.right = g2;
//           g1.left = new TreeNode(3);
//        g1.right = new TreeNode(3);
        g2.left = new TreeNode(15);
        g2.right = new TreeNode(7);

        SumOfLeftLeaves sml = new SumOfLeftLeaves();
        System.out.print(sml.sumOfLeftLeaves(r));

    }

}
