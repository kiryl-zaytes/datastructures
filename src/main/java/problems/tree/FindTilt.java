package problems.tree;

/**
 * Created by kiryl_zayets on 12/6/18.
 */
public class FindTilt {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    int tilt = 0;

    public int findTilt(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode root){

        if (root == null) return 0;

        int lTilt = helper(root.left);
        int rTilt = helper(root.right);
        tilt+= Math.abs(lTilt - rTilt);
        return lTilt + rTilt + root.val;

    }


    public static void main(String[] args){
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


        FindTilt ft = new FindTilt();
        System.out.print(ft.findTilt(r));
    }


}
