package problems.tree;

/**
 * Created by kiryl_zayets on 10/16/18.
 */
public class LowestCommonAncestor {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root,
            TreeNode p,
            TreeNode q) {


        if (root == null || root.val == p.val || root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        else if (left != null) return left;
        else if (right != null) return right;
        else return null;

    }


    public static void main(String[] args) {
        LowestCommonAncestor lwa = new LowestCommonAncestor();
        TreeNode r = new TreeNode(3);
        TreeNode g1 = new TreeNode(5);
        TreeNode g2 = new TreeNode(1);
        r.left = g1;
        r.right = g2;
        g2.left = new TreeNode(0);
        g2.right = new TreeNode(8);
        g1.left = new TreeNode(6);
        g1.right = new TreeNode(2);
        g1.right.left = new TreeNode(7);
        g1.right.right = new TreeNode(4);


        System.out.print(lwa.lowestCommonAncestor(r, g1, g2).val);
    }

}
