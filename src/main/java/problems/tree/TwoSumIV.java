package problems.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kiryl_zayets on 12/27/18.
 */
public class TwoSumIV {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }


    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> storage = new HashSet<>();
        return walkTree(root, k, storage);
    }


    private boolean walkTree(TreeNode root, int target, Set<Integer> storage) {
        if (root == null) return false;
        if (storage.contains(target - root.val)) return true;
        storage.add(target - root.val);
        return walkTree(root.right, target, storage) || walkTree(root.left, target, storage);
    }
}
