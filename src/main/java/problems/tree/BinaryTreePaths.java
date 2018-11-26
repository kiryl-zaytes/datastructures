package problems.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiryl_zayets on 11/26/18.
 */
public class BinaryTreePaths {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res=  new ArrayList<>();
        if (root == null) return res;
        helper(root, res, "");
        return res;
    }


    private void helper(TreeNode root, List<String> res, String path){
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
            return;
        }
        if (root.left != null) helper(root.left, res, path+root.val+"->");
        if (root.right != null) helper(root.right, res, path + root.val+"->");

    }


    public static void main(String[] args){
        BinaryTreePaths btp = new BinaryTreePaths();
        TreeNode r = new TreeNode(1);
        TreeNode g1 = new TreeNode(2);
        TreeNode g2 = new TreeNode(3);
        r.left = g1;
        r.right = g2;
//        g2.left = new TreeNode(6);
//        g2.right = new TreeNode(9);
//        g1.left = new TreeNode(1);
        g1.right = new TreeNode(5);
        btp.binaryTreePaths(r);
    }

}
