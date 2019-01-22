package problems.tree;

/**
 * Created by kiryl_zayets on 1/22/19.
 */
public class FlattenBT {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }



    public void flatten2(TreeNode root){
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;

        flat(left);
        flat(right);

        root.right = left;

        TreeNode current = root;

        while (current.right != null) current = current.right;
        current.right = right;
    }


    public void flatten(TreeNode root) {
        TreeNode l = flat(root.left);
        TreeNode r = flat(root.right);
        root.right = l;
        while (l.right != null)  l = l.right;
        l.right = r;
        root.left = null;
    }


    private TreeNode flat(TreeNode root) {
        if (root == null) return null;
        TreeNode l = flat(root.left);
        TreeNode r = flat(root.right);

        if (l != null) {
            root.right = l;
            l.right = r;
            root.left = null;
        }

        return root;
    }


    public static void main(String[] args) {
        FlattenBT fbt = new FlattenBT();

        TreeNode r = new TreeNode(1);
        TreeNode g1 = new TreeNode(2);
        TreeNode g2 = new TreeNode(5);
        r.left = g1;
        r.right = g2;

        g2.right = new TreeNode(6);
//        g2.right.right = new TreeNode(6);

        g1.left = new TreeNode(3);
        g1.right = new TreeNode(4);
//        g1.right.left = new TreeNode(8);
//        g1.right.right = new TreeNode(9);


        fbt.flatten(r);
    }


}
