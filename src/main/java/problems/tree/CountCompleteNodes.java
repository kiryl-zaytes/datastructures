package problems.tree;

/**
 * Created by kiryl_zayets on 1/22/19.
 */
public class CountCompleteNodes {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    int count = 0;


    private int height(TreeNode root){
        if (root == null) return 0;
        return 1+ height(root.left);
    }

    public int countNodes(TreeNode root){
        int h = height(root);
        if (h - 1  == height(root.right)) return (int) (Math.pow(2, h) - 1 + countNodes(root.right));
        else return (int) Math.pow(2, h-1) + countNodes(root.left);

    }

    private void helper(TreeNode root){
        if (root != null) count++;
        if (root == null) return;
        helper(root.left);
        helper(root.right);
    }

}
