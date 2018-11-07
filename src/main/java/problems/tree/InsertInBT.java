package problems.tree;

/**
 * Created by kiryl_zayets on 11/2/18.
 */
public class InsertInBT {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }


    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val > root.val ) root.right = insertIntoBST(root.right, val);
        else if (val < root.val) root.left = insertIntoBST(root.left, val);
        else if (val == root.val) root.val = val;
        return root;

    }

}
