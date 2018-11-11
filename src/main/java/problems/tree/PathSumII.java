package problems.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * To remove last piece of path you shoud know where is it left or right so
 * ned to add two additional conditional if root.left!=null and right, and then
 * remove last step from path when you reach end.
 * As oppose to delete from list you can do it on each step recursively.
 * If path was unsuccessful remove full path if it was successful - remove last step
 * as answer could be also from opposite part at same level.
 */
public class PathSumII {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        helper(root, sum, new ArrayList<Integer>(), res);
        return res;
    }


    private void helper(TreeNode root,
            int sum,
            List<Integer> res,
            List<List<Integer>> storage) {

//        if (root == null) return;
        res.add(root.val);

        if (root.left == null && root.right == null) {
            if (sum - root.val == 0) storage.add(new ArrayList<Integer>(res));
            return;
        }

        if (root.left != null) {
            helper(root.left, sum - root.val, res, storage);
            res.remove(res.size()-1);
        }
        if (root.right !=null) {
            helper(root.right, sum - root.val, res, storage);
            res.remove(res.size()-1);
        }
    }


    public static void main(String[] args) {
        TreeNode r = new TreeNode(5);
        TreeNode g1 = new TreeNode(4);
        TreeNode g2 = new TreeNode(8);
        r.left = g1;
        r.right = g2;

        g1.left = new TreeNode(11);


        g1.left.left = new TreeNode(1);
        g1.left.right = new TreeNode(2);

        g2.left = new TreeNode(13);
        g2.right = new TreeNode(4);
        g2.right.right = new TreeNode(1);
        g2.right.left = new TreeNode(5);
        PathSumII pp = new PathSumII();
        pp.pathSum(r, 22);
    }
}
