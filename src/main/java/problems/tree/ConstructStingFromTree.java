package problems.tree;

/**
 * Created by kiryl_zayets on 12/7/18.
 */
public class ConstructStingFromTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public String tree2str(TreeNode t) {
        return helper(t);
    }

    private String helper(TreeNode root) {
        if (root == null) return "";
        if (root.left == null && root.right == null) return root.val + "";
        if (root.right == null) return root.val + "(" + helper(root.left) + ")";

        return root.val + "(" + helper(root.left) + ")" + "(" +
                helper(root.right) + ")";
    }

    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);
        TreeNode g1 = new TreeNode(2);
        TreeNode g2 = new TreeNode(3);
        r.left = g1;
        r.right = g2;

        g1.left = new TreeNode(4);
        //g1.right = new TreeNode(2);

        ConstructStingFromTree cst = new ConstructStingFromTree();
        System.out.print(cst.tree2str(r));
    }
}
