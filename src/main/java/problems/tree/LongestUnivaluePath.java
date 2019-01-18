package problems.tree;

/**
 * Created by kiryl_zayets on 1/16/19.
 */


public class LongestUnivaluePath {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    int max = 0;
    int current = 0;

    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        int left = helper(root.left);
        int right =  helper(root.right);

        if (root.left != null && root.val == root.left.val) left++;
        if (root.right != null && root.val == root.right.val) right++;

        max = Math.max(max, left+right);

        return Math.max(left, right);
    }

    public static void main(String[] args){
        LevelOrderTraversalII lot2 = new LevelOrderTraversalII();
        TreeNode r = new TreeNode(1);
        TreeNode g1 = new TreeNode(4);
        TreeNode g2 = new TreeNode(5);
        r.left = g1;
        r.right = g2;
//        g2.left = new TreeNode(15);
        g2.right = new TreeNode(5);

        g1.left = new TreeNode(4);
        g1.right = new TreeNode(4);
//        lot2.levelOrderBottom(r);

        LongestUnivaluePath lup = new LongestUnivaluePath();
        lup.longestUnivaluePath(r);
    }
}
