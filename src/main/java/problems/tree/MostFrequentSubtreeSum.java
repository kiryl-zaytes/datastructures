package problems.tree;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kiryl_zayets on 1/22/19.
 */
public class MostFrequentSubtreeSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    int maxKey = Integer.MIN_VALUE;
    int maxVal = Integer.MIN_VALUE;

    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> storage = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        helper(root, storage);

        for (HashMap.Entry<Integer, Integer> s: storage.entrySet()){
            if (s.getValue() != maxVal) continue;
            res.add(s.getKey());
        }

        int[] arr = new int[res.size()];
        int  j= 0;
        for (int i: res) {
            arr[j++] = i;
        }

        return arr;

    }

    private int helper(TreeNode root, HashMap<Integer, Integer> storage){
        if (root == null) return 0;

        int l = helper(root.left, storage);
        int r = helper(root.right, storage);

        storage.put(l + r + root.val, storage.getOrDefault(l + r + root.val, 0)+1);
        maxVal = Math.max(maxVal, storage.getOrDefault(l + r + root.val, 0));
        return l + r + root.val;
    }

}
