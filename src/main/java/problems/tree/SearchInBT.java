package problems.tree;

/**
 * Created by kiryl_zayets on 11/2/18.
 */
public class SearchInBT {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (val < root.val) return searchBST(root.left, val);
        else if (val > root.val) return searchBST(root.right, val);
        else return root;
    }

}
