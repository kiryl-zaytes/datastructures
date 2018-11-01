package problems.tree;

/**
 * Created by kiryl_zayets on 10/26/18.
 */
public class PathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && sum - root.val ==0) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


    private int helper(TreeNode root, int sum) {

        if (root == null || sum==0) {
            return sum;
        }
        sum = sum - root.val;
        int res1 = helper(root.left, sum);
        int res2 = helper(root.right, sum);


        if (res1 == 0 || res2 == 0) return 0;
        else return -1;
    }


    public static void main(String[] args) {
        PathSum ps = new PathSum();

        TreeNode r = new TreeNode(1);
//        TreeNode g1 = new TreeNode(4);
//        TreeNode g2 = new TreeNode(8);
//        r.left = g1;
//        r.right = g2;
//
//        g1.left = new TreeNode(11);
//
//        g1.left.left = new TreeNode(7);
//        g1.left.right = new TreeNode(2);
//
//        g2.left = new TreeNode(20);
//        g2.right = new TreeNode(4);
//        g2.right.right = new TreeNode(1);

        System.out.print(ps.hasPathSum(r, 0));
    }

}
