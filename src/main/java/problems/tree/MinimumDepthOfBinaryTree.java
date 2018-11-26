package problems.tree;

/**
 * Created by kiryl_zayets on 11/23/18.
 */
public class MinimumDepthOfBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public int minDepth(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode root){
        if (root == null) return 0;
        int resL = helper(root.left);
        int resR = helper(root.right);

        if (resL == 0) return 1+resR;
        if (resR == 0) return 1+resL;
        else return 1 + Math.min(resL, resR);
    }



    public static void main(String[] args){
        MinimumDepthOfBinaryTree mdb = new MinimumDepthOfBinaryTree();

        TreeNode r = new TreeNode(3);
        TreeNode g1 = new TreeNode(9);
//        TreeNode g2 = new TreeNode(20);
        r.left = g1;
//        r.right = g2;
//        g2.left = new TreeNode(15);
//        g2.right = new TreeNode(17);
        System.out.print(mdb.minDepth(r));
    }


}
