package problems.tree;

/**
 * Created by kiryl_zayets on 12/26/18.
 */
public class ClosestBSTValue {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    double closest = Integer.MAX_VALUE;
    int tmp = 0;

    public int closestValue(TreeNode root, double target) {
        return helper(root, target, root.val);
    }


    private int helper(TreeNode root, double target, int value) {
        if (root == null) return value;
        if (Math.abs(root.val - target) < Math.abs(value - target)) value = root.val;
        if (target < root.val) value = helper(root.left, target, value);
        else if (target > root.val) value = helper(root.right, target, value);
        return value;
    }


    public static void main(String[] args) {
        TreeNode r = new TreeNode(2147483647);
//        TreeNode g1 = new TreeNode(2);
//        TreeNode g2 = new TreeNode(5);
//        r.left = g1;
//        r.right = g2;
//
//        g1.left = new TreeNode(1);
//        g1.right = new TreeNode(3);

        ClosestBSTValue closestBSTValue = new ClosestBSTValue();
        closestBSTValue.closestValue(r, 0.0);

    }
}
