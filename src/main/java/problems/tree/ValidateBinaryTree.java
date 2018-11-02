package problems.tree;

/**
 * Created by kiryl_zayets on 9/14/18.
 */
public class ValidateBinaryTree {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public static boolean isValid(TreeNode treeNode) {
        return isValidBST(treeNode, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    public static boolean isValidBST(TreeNode root,
            long minVal,
            long maxValue) {
        if (root == null) return true;
        if (root.val < minVal || root.val > maxValue) return false;

        return  (isValidBST(root.left, root.val, maxValue) && isValidBST(root
                .right, minVal, root.val));
    }


    private boolean validate(TreeNode root, int min, int max){
        if (root == null) return true;
        if ((min < root.val) || (max > root.val)) return false;
        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }














    public static void main(String[] args) {
        TreeNode r = new TreeNode(5);
        TreeNode g1 = new TreeNode(1);
        TreeNode g2 = new TreeNode(4);
        r.left = g1;
        r.right = g2;
        g2.left = new TreeNode(3);
        g2.right = new TreeNode(6);
//        g1.left = new TreeNode(14);
        //g2.left.left = new TreeNode(10);
        System.out.print(ValidateBinaryTree.isValid(r));
    }
}
