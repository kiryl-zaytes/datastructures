package problems.tree;

/**
 * Created by kiryl_zayets on 11/6/18.
 */
public class DeleteInBT {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }


    public TreeNode deleteNode(TreeNode root, int key) {

        if (root.val == key && root.left==null && root.right == null) return null;
        return helper(root, key);
    }

    private TreeNode deleteMin(TreeNode root) {
        if (root.left == null) return root.right;
        root.left = deleteMin(root.left);
        return root;
    }

    private TreeNode min(TreeNode root) {
        if (root.left == null) return root;
        return min(root.left);
    }


    public TreeNode helper(TreeNode root, int key) {
        if (root == null) return null;
        if (key > root.val) root.right = helper(root.right, key);
        else if (key < root.val) root.left = helper(root.left, key);
        else {

            if (root.right == null) return root.left;
            if (root.left == null) return root.right;

            TreeNode t = root;
            root = min(t.right);

            root.right = deleteMin(t.right);

            root.left = t.left;

        }
        return root;
    }


    public static void main(String[] args) {
        DeleteInBT deleteInBT = new DeleteInBT();

        TreeNode x = new TreeNode(1);
        x.left = null;
        x.right = new TreeNode(2);
        TreeNode r = deleteInBT.deleteNode(x, 1);
        System.out.print(r.left);

    }


}
