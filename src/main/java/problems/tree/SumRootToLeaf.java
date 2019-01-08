package problems.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiryl_zayets on 12/26/18.
 */
public class SumRootToLeaf {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        ArrayList<String> ar = new ArrayList<>();
        helper(root, "", ar);
        int res = 0;
        for (String x : ar) res+=Integer.parseInt(x);
        return res;
    }

    private void helper(TreeNode root, String path, List<String> tmp){
        if (root.left == null && root.right == null) {
            tmp.add(path + root.val);
            return;
        }
        if (root.left != null) helper(root.left, path + root.val, tmp);
        if (root.right != null) helper(root.right, path + root.val, tmp);
    }


    public static void main(String[] args) {
        TreeNode r = new TreeNode(4);
        TreeNode g1 = new TreeNode(9);
        TreeNode g2 = new TreeNode(0);
        r.left = g1;
        r.right = g2;

        g1.left = new TreeNode(5);
        g1.right = new TreeNode(1);

        SumRootToLeaf srl = new SumRootToLeaf();
        srl.sumNumbers(r);

    }
}
