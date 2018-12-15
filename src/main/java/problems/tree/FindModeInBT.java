package problems.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kiryl_zayets on 12/5/18.
 */
public class FindModeInBT {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    int max = 0;


    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> storage = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        helper(root, storage);
        for (Map.Entry<Integer, Integer> s : storage.entrySet()) {
            if (s.getValue() == max) res.add(s.getKey());
        }

        int[] ar = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ar[i] = res.get(i);
        }

        return ar;

    }

    private void helper(TreeNode root, HashMap<Integer, Integer> storage) {
        if (root == null) return;
        storage.put(root.val, storage.getOrDefault(root.val, 0) + 1);
        max = Math.max(max, storage.getOrDefault(root.val, 0));
        helper(root.left, storage);
        helper(root.right, storage);
    }
}
