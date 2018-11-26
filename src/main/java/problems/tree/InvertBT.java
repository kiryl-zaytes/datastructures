package problems.tree;

/**
 * Created by kiryl_zayets on 11/26/18.
 */
public class InvertBT {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        helper(root);
        return root;
    }


    private TreeNode helper(TreeNode root) {
        if (root == null) return null;
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        TreeNode tmp = left;
        root.left = right;
        root.right = tmp;
        return root;
    }


    public static void main(String[] args) {

        TreeNode r = new TreeNode(4);
        TreeNode g1 = new TreeNode(2);
        TreeNode g2 = new TreeNode(7);
        r.left = g1;
        r.right = g2;
        g2.left = new TreeNode(6);
        g2.right = new TreeNode(9);
        g1.left = new TreeNode(1);
        g1.right = new TreeNode(3);

        InvertBT ib = new InvertBT();
        ib.invertTree(r);

    }

}
