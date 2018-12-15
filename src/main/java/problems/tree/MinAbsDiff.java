package problems.tree;

/**
 * Created by kiryl_zayets on 12/5/18.
 */
public class MinAbsDiff {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    TreeNode prev = null;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;
        getMinimumDifference(root.left);
        if (prev != null) min = Math.min(min, root.val - prev.val);
        prev = root;
        getMinimumDifference(root.right);
        return min;
    }


    public static void main(String[] args) {

        TreeNode r = new TreeNode(5);
//        TreeNode g1 = new TreeNode(6);
//        TreeNode g2 = new TreeNode(20);
//        r.right = g1;
//        g1.right = new TreeNode(8);
        r.left = new TreeNode(3);
        r.left.left = new TreeNode(2);
//        r.right = g2;
//        g2.left = new TreeNode(15);
//        g2.right = new TreeNode(17);


        MinAbsDiff minAbsDiff = new MinAbsDiff();
        System.out.print(minAbsDiff.getMinimumDifference(r));
    }

}
