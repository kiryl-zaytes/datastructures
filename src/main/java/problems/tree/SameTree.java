package problems.tree;

/**
 * Created by kiryl_zayets on 11/22/18.
 */
public class SameTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    boolean eq = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return walk(p, q);
    }

    private boolean walk(TreeNode root1, TreeNode root2) {
        if ((root1 == root2) && root1 == null) return true;
        else if (root1 == null || root2 == null) return false;

        if (root1.val != root2.val) return false;
        return walk(root1.left, root2.left) && walk(root1.right, root2.right);
    }


    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);
        TreeNode g1 = new TreeNode(2);
        TreeNode g2 = new TreeNode(2);
        r.left = g1;
        r.right = g2;
        g1.left = new TreeNode(3);
        g1.right = new TreeNode(3);
        g2.left = new TreeNode(4);
        g2.right = new TreeNode(5);


        TreeNode r1 = new TreeNode(1);
        TreeNode b1 = new TreeNode(2);
        TreeNode b2 = new TreeNode(2);
        r1.left = b1;
        r1.right = b2;
        b1.left = new TreeNode(3);
        b1.right = new TreeNode(3);
        b2.left = new TreeNode(4);
        b2.right = new TreeNode(5);


        SameTree st = new SameTree();
        System.out.print(st.isSameTree(r, r1));
    }

}
