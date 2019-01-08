package problems.tree;

/**
 * Created by kiryl_zayets on 12/28/18.
 */
public class InorderSuccessorInBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return helper(root, p);
    }

    private TreeNode helper(TreeNode root, TreeNode target){
        if (root == null) return null;
        if (target.val >= root.val) return helper(root.right, target);
        else {
            TreeNode left =  helper(root.left, target);
            if (left == null) return root;
            return left;
        }
    }


    public static void main(String[] args){
        TreeNode r = new TreeNode(5);
        TreeNode g1 = new TreeNode(3);
        TreeNode g2 = new TreeNode(6);
        r.left = g1;
        r.right = g2;
        g1.left = new TreeNode(2);
        g1.right = new TreeNode(4);
        g1.left.left = new TreeNode(1);

        InorderSuccessorInBST insbt = new InorderSuccessorInBST();
        System.out.print(insbt.inorderSuccessor(r, new TreeNode(6)).val);

    }

}
