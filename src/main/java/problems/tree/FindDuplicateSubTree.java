package problems.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kiryl_zayets on 11/14/18.
 */
public class FindDuplicateSubTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> storage = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, storage, res);
        return res;
    }


    private String helper(TreeNode root,
            HashMap<String, Integer> storage,
            List<TreeNode> res) {
        if (root == null) return "#";

        String n1 = helper(root.left, storage, res);
        String n2 = helper(root.right, storage, res);
        String serial = root.val + "," + n1 + "," + n2;
        storage.put(serial, storage.getOrDefault(serial, 0) + 1);

        if (storage.get(serial) == 2) {
            res.add(root);
        }

        return serial;
    }

    public static void main(String[] args) {
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

        FindDuplicateSubTree fs = new FindDuplicateSubTree();
        fs.findDuplicateSubtrees(r);
    }
}
