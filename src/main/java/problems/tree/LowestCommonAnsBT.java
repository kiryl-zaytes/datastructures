package problems.tree;

/**
 * Created by kiryl_zayets on 11/9/18.
 */
public class LowestCommonAnsBT {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }



    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        else if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        else return root;
    }


    public static void main(String[] args) {
        LowestCommonAnsBT lows = new LowestCommonAnsBT();
        TreeNode r = new TreeNode(6);
        TreeNode g1 = new TreeNode(2);
        TreeNode g2 = new TreeNode(8);
        r.left = g1;
        r.right = g2;
        g2.left = new TreeNode(7);
        g2.right = new TreeNode(9);
        g1.left = new TreeNode(0);
        g1.right = new TreeNode(4);
        g1.right.left = new TreeNode(3);
        g1.right.right = new TreeNode(5);

        System.out.print(lows.lowestCommonAncestor(r, g1, g2).val);
    }


}
